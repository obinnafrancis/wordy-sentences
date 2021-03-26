package com.vlad.wordysentences.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {
    @Column(unique = true)
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customer_staffs")
    private Set<Staff> staffList;

    public Customer(CreateCustomerRequest createCustomerRequest) {
        this.name = createCustomerRequest.getName();
    }

    public Customer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(Set<Staff> staffList) {
        this.staffList = staffList;
    }

    public String toString(){
        return "{" +"name:"+name+
                "}";
    }
}
