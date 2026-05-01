package com.dijo.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class VehicleDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String address;

    private String contactNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    private String contactEmail;

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }
}
