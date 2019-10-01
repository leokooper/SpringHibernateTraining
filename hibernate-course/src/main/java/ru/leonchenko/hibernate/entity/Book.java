package ru.leonchenko.hibernate.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of = "id")
@ToString(of = "name", includeFieldNames = false)
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column (insertable = false, updatable = false)
    private int author_id;

    @ManyToOne
    @JoinColumn
    private Author author;

}
