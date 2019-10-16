package ru.leonchenko.spring.chopchopsushi.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.leonchenko.spring.chopchopsushi.Order;

import java.util.Date;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface OrderRepository extends CrudRepository<Order, Long> {

//  Order save(Order order);

//    List<Order> findByDeliveryZip(String deliveryZip);

//    List<Order> readOrderByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    @Query("Order o where o.deliveryCity = 'Seattle")
    List<Order> findByDeliveryCityOrderByDeliveryTo(String city);
}
