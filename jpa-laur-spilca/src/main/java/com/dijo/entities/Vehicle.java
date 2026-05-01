package com.dijo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Vehicle implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private String type;

    private String couFlag;

    private String bouFlag;

    private String status;

    private String proxyIp;

    private String proxyPort;

    private String certFile;

    private String certPassword;

    @OneToOne (optional = true, fetch = FetchType.EAGER)
    private VehicleDetails vehicleDetails;

    @OneToMany
    @JoinTable( name = "vehicles_billers", joinColumns = @JoinColumn(name = "vehicle_id"), inverseJoinColumns = @JoinColumn(name = "biller_id"))
    private Set<Biller> billers;

    public Set<Biller> getBillers() {
        return billers;
    }

    public void setBillers(Set<Biller> billers) {
        this.billers = billers;
    }

    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", couFlag='" + couFlag + '\'' +
                ", bouFlag='" + bouFlag + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCouFlag() {
        return couFlag;
    }

    public void setCouFlag(String couFlag) {
        this.couFlag = couFlag;
    }

    public String getBouFlag() {
        return bouFlag;
    }

    public void setBouFlag(String bouFlag) {
        this.bouFlag = bouFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProxyIp() {
        return proxyIp;
    }

    public void setProxyIp(String proxyIp) {
        this.proxyIp = proxyIp;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getCertFile() {
        return certFile;
    }

    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }
}
