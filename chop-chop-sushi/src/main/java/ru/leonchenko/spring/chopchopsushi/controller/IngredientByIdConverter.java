package ru.leonchenko.spring.chopchopsushi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ru.leonchenko.spring.chopchopsushi.Ingredient;
import ru.leonchenko.spring.chopchopsushi.data.IngredientRepository;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private IngredientRepository ingredientRepo;

  @Autowired
  public IngredientByIdConverter(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
  
  @Override
  public Ingredient convert(String id) {
    return ingredientRepo.findById(id);
  }

}
