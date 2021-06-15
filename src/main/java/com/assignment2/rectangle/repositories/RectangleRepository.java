package com.assignment2.rectangle.repositories;

import com.assignment2.rectangle.models.Rectangle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectangleRepository extends JpaRepository<Rectangle, Long> {

}