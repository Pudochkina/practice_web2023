package ru.Pudochkina.service;

import org.springframework.stereotype.Service;
import ru.Pudochkina.model.ApplicationForm;
import ru.Pudochkina.repository.ApplicationFormRepository;

import java.util.Collection;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService{

    private final ApplicationFormRepository applicationFormRepository;

    public ApplicationFormServiceImpl(ApplicationFormRepository applicationFormRepository) {
        this.applicationFormRepository = applicationFormRepository;
    }

    @Override
    public Collection<ApplicationForm> getAllApplicationForms() {
        return applicationFormRepository.getAllApplicationForms();
    }

    @Override
    public void createApplicationForm(ApplicationForm applicationForm) {
        applicationFormRepository.create(applicationForm);
    }

    @Override
    public void updateApplicationForm(Long id, String status) {
        applicationFormRepository.updateApplicationForm(id, status);
    }
}
