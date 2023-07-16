package ru.Pudochkina.service;

import ru.Pudochkina.model.ApplicationForm;

import java.util.Collection;
import java.util.List;

public interface ApplicationFormService {

    Collection<ApplicationForm> getAllApplicationForms();

    void createApplicationForm(ApplicationForm applicationForm);

    void updateApplicationForm(Long id, String status);
}
