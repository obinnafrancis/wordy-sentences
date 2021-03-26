package com.vlad.wordysentences.models;

public class CreateStaffRequest {
    private String firstname;
    private String lastname;
    private int employerId;

    public CreateStaffRequest(){}

    public CreateStaffRequest(String firstname, String lastname, String employerId){
        this.firstname = firstname;
        this.lastname = lastname;
        this.employerId = Integer.parseInt(employerId);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }
}
