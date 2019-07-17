package ru.leonchenko.spring.sprinthibernate.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@Entity
@Table (name = "author", catalog = "library")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 300)
    @Basic
    private String fio;

    @Column(nullable = false)
    private Date birthday;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    @Override
    public String toString() {return fio; }
}
