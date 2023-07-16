package ru.Pudochkina.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.Pudochkina.model.ApplicationForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class JdbcApplicationFormRepositoryImpl implements ApplicationFormRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationFormRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<ApplicationForm> getAllApplicationForms() {
        return jdbcTemplate.query("select * from Applicform3", new StorageExtractor()).values();
    }

    @Override
    public void create(ApplicationForm applicationForm) {
        jdbcTemplate.update("insert into Applicform3 (dateOfPost, sortOfWork, houseNumber, message, status) values (?,?,?,?,'не выполнено')",
                applicationForm.getDateOfPost(), applicationForm.getSortOfWork(), applicationForm.getHouseNumber(),
                applicationForm.getMessage());
    }

    @Override
    public void updateApplicationForm(Long id, String status) {
        jdbcTemplate.update("update Applicform3 set status =? where id=?", status, id);
    }

    public static class StorageExtractor implements ResultSetExtractor<Map<Long, ApplicationForm>> {

        @Override
        public Map<Long, ApplicationForm> extractData(ResultSet rs) throws SQLException, DataAccessException {

            Map<Long, ApplicationForm> result = new LinkedHashMap<>();

            while (rs.next()) {
                Long applicationFormId = rs.getLong(1);
                String dateOfPost = rs.getString(2);
                String sortOfName = rs.getString(3);
                int houseNumber = rs.getInt(4);
                String message = rs.getString(5);
                String status = rs.getString(6);

                ApplicationForm applicationForm = new ApplicationForm(applicationFormId, dateOfPost, sortOfName, houseNumber, message, status);

                result.putIfAbsent(applicationFormId, applicationForm);

            }
            return result;
        }
    }
}
