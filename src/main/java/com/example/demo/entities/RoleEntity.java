package com.example.demo.entities;

import javax.persistence.Entity;

@Entity
public class RoleEntity extends Enti {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}