package ru.leonchenko.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL

//    private long id;
//
//    private String name;

    @Column(name = "surname")
    private String secondName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    //@Basic(fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    @Embedded
    protected CommonFields commonFields;


//    public Author(long id, String name){
//        this.id = id;
//        this.name = name;
//    }
//
//    public Author(CommonFields commonFields){
//        this.commonFields = commonFields;
//    }




}
