package com.vinicius.ListaDeEventos.controllers;

import com.vinicius.ListaDeEventos.models.Evento;
import com.vinicius.ListaDeEventos.repositorys.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventRepository er;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento){
        er.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();
        return modelAndView.addObject("eventos", eventos);
    }
}
