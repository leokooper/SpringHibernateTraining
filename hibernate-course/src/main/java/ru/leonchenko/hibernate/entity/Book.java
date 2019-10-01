package ru.leonchenko.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    private int id;
//
//    private String name;

    @Column (insertable = false, updatable = false)
    private int author_id;

    @ManyToOne
    @JoinColumn
    private Author author;

    @Embedded
    private CommonFields commonFields;

}
