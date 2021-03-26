package com.vlad.wordysentences.models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
