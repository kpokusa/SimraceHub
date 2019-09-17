package com.setuphub.controller;

import com.setuphub.model.Setup;
import com.setuphub.model.SetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SetupController {

    @Autowired
    private SetupRepository setupRepository;

    @GetMapping("/registersetup")
    public String showAddSetupForm(Setup setup){
        return "add-setup";
    }

    @PostMapping("/addSetup")
    public String addSetup(@Valid Setup setup, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-setup";
        }
        setupRepository.save(setup);
        model.addAttribute( "setup", setupRepository.findAll() );
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteSetup(@PathVariable("id") long id, Model model){
        Setup setup = setupRepository.findById( id )
                .orElseThrow( ()-> new IllegalArgumentException( ("Wrong setup id: " + id) ) );
        setupRepository.delete( setup );
        model.addAttribute( "setup", setupRepository.findAll() );
        return "index";
    }
}
