package models;

import play.db.jpa.JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bar {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

}