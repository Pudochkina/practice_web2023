package ru.Pudochkina.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Pudochkina.model.ApplicationForm;
import ru.Pudochkina.service.ApplicationFormService;

@Controller
public class ApplicationController {


    private final ApplicationFormService applicationFormService;

    public ApplicationController(ApplicationFormService applicationFormService) {
        this.applicationFormService = applicationFormService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("form");
        model.addAttribute("applicationForm", new ApplicationForm());
        return "form";
    }

    @PostMapping("/saveForm")
    public String addForm(@ModelAttribute ApplicationForm applicationForm){
        applicationFormService.createApplicationForm(applicationForm);
        return "redirect:";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("form");
        model.addAttribute("applicationForm", new ApplicationForm());
        return "form";
    }

    @GetMapping("/table")
    public String getTable(Model model) {
        model.addAttribute("table", applicationFormService.getAllApplicationForms());
        return "table";
    }

    @PatchMapping("/form/{id}")
    public String updateStatus(Model model, @PathVariable("id") Long id) {
        model.addAttribute("table", applicationFormService.getAllApplicationForms());
        model.addAttribute("applicationForm", new ApplicationForm());
        model.addAttribute("id", id);
        return "redirect:";
    }
}
