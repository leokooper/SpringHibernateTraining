package ru.leonchenko.spring.chopchopsushi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import ru.leonchenko.spring.chopchopsushi.Ingredients;
import ru.leonchenko.spring.chopchopsushi.Ingredients.Type;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@Slf4j
@Controller
@RequestMapping("/desing")
public class DesingSushiController {
    @GetMapping
    public String showDesignForm(Model model){

        List<Ingredients> ingredients = Arrays.asList(
                new Ingredients("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredients("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredients("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredients("CARN", "Carnitas", Type.PROTEIN),
                new Ingredients("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredients("LETC", "Lettuce", Type.VEGGIES),
                new Ingredients("CHED", "Cheddar", Type.CHEESE),
                new Ingredients("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredients("SLSA", "Salsa", Type.SAUCE),
                new Ingredients("SRCR", "Sour Cream", Type.SAUCE)
        );
        Type[] types = Ingredients.Type.values();
        for (Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));

        }

        model.addAttribute("desing", new Sushi());

        return "desing";

    }

    private List<Ingredients> filterByType(
            List<Ingredients> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
