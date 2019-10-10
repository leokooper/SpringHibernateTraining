package ru.leonchenko.spring.chopchopsushi.data;


import ru.leonchenko.spring.chopchopsushi.Taco;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface TacoRepository  {

  Taco save(Taco design);
  
}
