package com.assignment2.rectangle.controllers;

import java.util.List;

import com.assignment2.rectangle.models.Rectangle;
import com.assignment2.rectangle.services.RectangleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleController {
    @Autowired
    private RectangleService service;

    @PostMapping("/rectangle")
    public Rectangle createRectangle(@RequestBody Rectangle rectangle) {
        return service.createRectangle(rectangle);
    }

    @GetMapping("/rectangle")
    public List<Rectangle> getAllRectangles() {
        return service.getRectangles();
    }

    @GetMapping("/rectangle/{id}")
    public Rectangle getRectangle(@PathVariable Long id) {
        return service.getRectangleById(id);
    }

    @PutMapping("/rectangle/{id}")
    public Rectangle updateRectangle(Rectangle rectangle, @PathVariable Long id) {
        return service.updateRectangle(rectangle, id);
    }

    @DeleteMapping("/rectangle/{id}")
    public void deleteRectangleById(@PathVariable Long id) {
        service.deleteRectangle(id);
    }
}
