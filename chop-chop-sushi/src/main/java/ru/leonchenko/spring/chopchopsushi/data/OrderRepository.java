package ru.leonchenko.spring.chopchopsushi.data;

import ru.leonchenko.spring.chopchopsushi.Order;

public interface OrderRepository {

  Order save(Order order);
  
}
