package com.assignment2.rectanglegenerator.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Rectangle {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private int width;

    @NotNull
    private int height;

    @NotNull
    private String color;


    public Rectangle() {

    }

    public Rectangle(String name, int width, int height, String color) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (!(o instanceof Rectangle))
        return false;
        Rectangle rectangle = (Rectangle) o;
      return Objects.equals(this.id, rectangle.id) && Objects.equals(this.name, rectangle.name)
          && Objects.equals(this.width, rectangle.width) && Objects.equals(this.height, rectangle.height)
          && Objects.equals(this.color, rectangle.color);
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.name, this.width, this.height, this.color);
    }
  
    @Override
    public String toString() {
      return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", width='" + this.width + '\''
            + ", height='" + this.height + '\'' + ", color='" + this.color + '\'' + '}';
    }

}