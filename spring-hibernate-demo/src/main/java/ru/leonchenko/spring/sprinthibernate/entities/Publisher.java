package ru.leonchenko.spring.sprinthibernate.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@EqualsAndHashCode(of = "id")
@Table(name = "publisher", catalog = "library")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Entity
@Getter
@Setter

public class Publisher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Basic(fetch = FetchType.LAZY)
        @OneToMany(mappedBy = "publisher")
        private List<Book> books;

        @Override
        public String toString() {
            return name;
        }
}