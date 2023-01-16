package com.example.activeMQ.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tutorials")
@NamedQueries({
        @NamedQuery(name = "tutorials.findAll", query = "Select t from Tutorial t"),
//        @NamedQuery(name = "tutorials.insert", query = "")
})
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private Boolean published;
}
