package ru.leonchenko.spring.chopchopsushi.data;

import ru.leonchenko.spring.chopchopsushi.Taco;

public interface TacoRepository  {

  Taco save(Taco design);
  
}
