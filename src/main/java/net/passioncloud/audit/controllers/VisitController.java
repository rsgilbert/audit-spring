package net.passioncloud.audit.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.passioncloud.audit.models.Visit;
import net.passioncloud.audit.repositories.VisitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitController {
    private final VisitRepository visitRepository;

    @GetMapping({ "/", "" })
    public String visits(Model model) {
        log.info("Getting visits");
        Iterable<Visit> visits = visitRepository.findAll();
        model.addAttribute("visits", visits);
        return "visits/index";
    }

    @GetMapping("/add")
    public String addVisit(Model model) {
        model.addAttribute("visit", new Visit());
        return "visits/add-visit";
    }

    @PostMapping("/add")
    public String addVisit(@ModelAttribute Visit visit, BindingResult errors, Model model) {
        visitRepository.save(visit);
        return "visits/index";
    }


}
