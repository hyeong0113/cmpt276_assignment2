package com.assignment2.rectanglegenerator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.assignment2.rectanglegenerator.models.Rectangle;
import com.assignment2.rectanglegenerator.repositories.RectangleRepository;


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
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No rectangle with" + id));
    }

    public Rectangle updateRectangle(Rectangle rectangle, Long id) {
        Rectangle found = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No rectangle with" + id));
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
