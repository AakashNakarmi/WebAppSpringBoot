package com.example.webappspringboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productoffers")
public class Productoffer {
    @Id
    @Column(name = "offerid", nullable = false, length = 20)
    private String offerid;

    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "hscode", length = 20)
    private String hscode;

    @Column(name = "offername", length = 20)
    private String offername;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unit", length = 10)
    private String unit;

    @Column(name = "unitprice")
    private Integer unitprice;

    public String getOfferid() {
        return offerid;
    }

    public void setOfferid(String offerid) {
        this.offerid = offerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }

}