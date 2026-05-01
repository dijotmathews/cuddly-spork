package com.dijo.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class Biller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String alias;

    private String npcibillerid;

    @ManyToOne
    private Vehicle vehicle;

    @Override
    public String toString() {
        return "Biller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", npcibillerid='" + npcibillerid + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNpcibillerid() {
        return npcibillerid;
    }

    public void setNpcibillerid(String npcibillerid) {
        this.npcibillerid = npcibillerid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
