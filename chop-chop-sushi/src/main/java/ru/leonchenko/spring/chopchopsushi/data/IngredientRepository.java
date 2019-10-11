package ru.leonchenko.spring.chopchopsushi.data;

import ru.leonchenko.spring.chopchopsushi.Ingredient;

public interface IngredientRepository {

  Iterable<Ingredient> findAll();
  
  Ingredient findById(String id);
  
  Ingredient save(Ingredient ingredient);
  
}
