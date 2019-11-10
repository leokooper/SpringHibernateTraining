package ru.leonchenko.spring.chopchopsushi;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Data
@Entity
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Date createdAt;

  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  private String name;

  @ManyToMany(targetEntity=Ingredient.class)
  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

}
