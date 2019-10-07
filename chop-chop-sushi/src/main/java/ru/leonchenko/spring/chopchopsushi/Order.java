package ru.leonchenko.spring.chopchopsushi;

import lombok.Data;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@Data
public class Order {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
