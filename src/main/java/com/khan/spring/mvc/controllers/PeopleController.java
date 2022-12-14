package com.khan.spring.mvc.controllers;

import com.khan.spring.mvc.DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO dao;
    @Autowired
    public PeopleController(PersonDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", dao.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", dao.show(id));
        return "people/show";
    }
    @GetMapping("pal")
    public String pal() {
        return "second/pal";
    }
    @GetMapping("exit")
    public String exit() {
        return "second/exit";
    }
}
