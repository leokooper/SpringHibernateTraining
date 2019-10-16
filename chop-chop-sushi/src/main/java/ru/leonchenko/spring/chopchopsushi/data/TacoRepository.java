package ru.leonchenko.spring.chopchopsushi.data;

import org.springframework.data.repository.CrudRepository;
import ru.leonchenko.spring.chopchopsushi.Taco;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface TacoRepository extends CrudRepository<Taco, Long> {

//  Taco save(Taco design);
  
}
