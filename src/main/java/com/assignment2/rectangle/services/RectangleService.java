package com.assignment2.rectangle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.assignment2.rectangle.models.Rectangle;
import com.assignment2.rectangle.repositories.RectangleRepository;

@Service
public class RectangleService {
    @Autowired
    private RectangleRepository repository;

    public Rectangle createRectangle(Rectangle rectangle) {
        return repository.save(rectangle);
    }

    public List<Rectangle> getRectangles() {
        return repository.findAll();
    }

    public Rectangle getRectangleById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Rectangle updateRectangle(Rectangle rectangle, Long id) {
        Rectangle found = repository.findById(id).orElseThrow();
        found.setName(rectangle.getName());
        found.setWidth(rectangle.getWidth());
        found.setHeight(rectangle.getHeight());
        found.setColor(rectangle.getColor());

        return repository.save(found);
    }

    public void deleteRectangle(Long id) {
        repository.deleteById(id);
    }
}
