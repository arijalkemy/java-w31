package com.calculadora.calorias.model;

import java.util.List;
import java.util.Objects;

public class Dish {
     private String name;
     private List<Ingredient> ingredients;
     private int totalWeigth;

     public Dish(String name, List<Ingredient> ingredients, int totalWeigth) {
          this.name = name;
          this.ingredients = ingredients;
          this.totalWeigth = totalWeigth;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public List<Ingredient> getIngredients() {
          return ingredients;
     }

     public void setIngredients(List<Ingredient> ingredients) {
          this.ingredients = ingredients;
     }

     public int getTotalWeigth() {
          return totalWeigth;
     }

     public void setTotalWeigth(int totalWeigth) {
          this.totalWeigth = totalWeigth;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Dish dish = (Dish) o;
          return totalWeigth == dish.totalWeigth && Objects.equals(name, dish.name) && Objects.equals(ingredients, dish.ingredients);
     }

     @Override
     public int hashCode() {
          return Objects.hash(name, ingredients, totalWeigth);
     }

     @Override
     public String toString() {
          return "Dish{" +
                  "name='" + name + '\'' +
                  ", ingredients=" + ingredients +
                  ", totalWeigth=" + totalWeigth +
                  '}';
     }
}
