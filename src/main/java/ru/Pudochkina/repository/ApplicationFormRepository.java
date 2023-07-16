package ru.Pudochkina.repository;

import ru.Pudochkina.model.ApplicationForm;

import java.util.Collection;

public interface ApplicationFormRepository {

    Collection<ApplicationForm> getAllApplicationForms();

    void create(ApplicationForm applicationForm);

    void updateApplicationForm (Long id, String status);
}
