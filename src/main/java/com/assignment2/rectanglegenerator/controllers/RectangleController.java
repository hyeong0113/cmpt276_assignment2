package com.assignment2.rectanglegenerator.controllers;

import javax.validation.Valid;

import com.assignment2.rectanglegenerator.models.Rectangle;
import com.assignment2.rectanglegenerator.services.RectangleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RectangleController {
    @Autowired
    private RectangleService service;

    // Display form to create a rectangle
    @GetMapping("/addrectangle")
    public String showCreateRectangleForm(Rectangle rectangle) {
        return "create_rectangle_form";
    }

    @PostMapping("/create")
    public String createRectangle(@Valid Rectangle rectangle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create_rectangle_form";
        }
        
        service.createRectangle(rectangle);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAllRectangles(Model model) {
        model.addAttribute("rectangle_list", service.getRectangles());
        return "index";
    }

    @GetMapping("/{id}")
    public String getRectangle(@PathVariable Long id, Model model) {
        model.addAttribute("rectangle", service.getRectangleById(id));
        return "detail_rectangle";
    }

    // Display form to edit a rectangle
    @GetMapping("/editrectangle/{id}")
    public String showEditRectangleForm(@PathVariable Long id, Model model) {
        model.addAttribute("rectangle", service.getRectangleById(id));
        return "edit_rectangle_form";
    }

    @RequestMapping("/edit/{id}")
    public String updateRectangle(Rectangle rectangle, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "edit_rectangle_form";
        }
        
        service.updateRectangle(rectangle, id);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRectangleById(@PathVariable("id") Long id) {
        service.deleteRectangle(id);
        return "redirect:/";
    }
}
