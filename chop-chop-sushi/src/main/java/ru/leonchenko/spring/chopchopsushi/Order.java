package ru.leonchenko.spring.chopchopsushi;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@Data
public class Order {

    @NotBlank(message = "Name is reqired")
    private String name;

    @NotBlank(message = "Street is reqired")
    private String street;

    @NotBlank(message = "City is reqired")
    private String city;

    @NotBlank(message = "State is reqired")
    private String state;

    @NotBlank(message = "Zip code is reqired")
    private String zip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "regexp=\"^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$",
    message = "Expiration date must be MM/YY format")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Inavlid CVV")
    private String ccCVV;
}
