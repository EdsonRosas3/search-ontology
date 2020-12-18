package com.buscador.buscadorontology.controller;

import com.buscador.buscadorontology.ServiceOntology;
import com.buscador.buscadorontology.model.Frase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class buscadorController {

    @GetMapping("/")
    public String buscador(Model model){
        model.addAttribute("frase", new Frase());
        return "form";
    }
    @PostMapping("/resultados")
    public ModelAndView resultados(@ModelAttribute("frase") Frase frase){
        ModelAndView mav = new ModelAndView("resultados");
        mav.addObject("frase", frase);
        ServiceOntology service = new ServiceOntology();
        service.search(frase.getFrase());
        return mav;
    }
}
