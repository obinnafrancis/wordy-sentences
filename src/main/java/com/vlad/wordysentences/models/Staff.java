package com.vlad.wordysentences.models;

import javax.persistence.*;

@Entity
@Table(name = "staffs")
public class Staff extends AbstractModel{
    @Column(unique = true)
    private String name;


    public Staff (){}

    public Staff(CreateStaffRequest createStaffRequest) {
        this.name= createStaffRequest.getFirstname()+ " "+createStaffRequest.getLastname();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
