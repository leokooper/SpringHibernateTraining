package ru.leonchenko.spring.chopchopsushi.data;


import ru.leonchenko.spring.chopchopsushi.Order;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface OrderRepository {

  Order save(Order order);
  
}
