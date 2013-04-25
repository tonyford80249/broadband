package com.cdoe.biz.model;

/**
 *
 * @author Tony Ford
 */
public class Payee {
 private String name;
 private String number; 

    public Payee() {
    }

    public Payee(District district) {
      this.number = district.getCode();
      this.name = district.getName();              
    }

    public Payee(String name, String number) {
        this.name = name;
        this.number = number;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameAndNumber() {
        return this.number + " - " + this.name;                
    } 
 
}
