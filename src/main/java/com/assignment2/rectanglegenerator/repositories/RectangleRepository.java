package com.assignment2.rectanglegenerator.repositories;

import com.assignment2.rectanglegenerator.models.Rectangle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectangleRepository extends JpaRepository<Rectangle, Long> {

}