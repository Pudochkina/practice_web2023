package ru.Pudochkina.controller;

import org.springframework.web.bind.annotation.*;
import ru.Pudochkina.model.ApplicationForm;
import ru.Pudochkina.service.ApplicationFormService;

import java.util.Collection;

@RestController
@RequestMapping("/applicationForm")
public class ApplicationFormController {

    private final ApplicationFormService applicationFormService;

    public ApplicationFormController(ApplicationFormService applicationFormService) {
        this.applicationFormService = applicationFormService;
    }

    @GetMapping
    public Collection<ApplicationForm> getAllApplicationForms() {
        return applicationFormService.getAllApplicationForms();
    }

    @PostMapping
    public void createApplicationForm(@RequestBody ApplicationForm applicationForm) {
        applicationFormService.createApplicationForm(applicationForm);
    }

    @PatchMapping("/{id}")
    public void updateApplicationForm(@PathVariable("id") Long id, @RequestBody  String status){
        applicationFormService.updateApplicationForm(id, status);
    }

}
