package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.RoleEntity;
import com.example.demo.repositories.RoleRepo;

@Service
public class RoleService {

    @Autowired
    private RoleRepo repository;

    public Map<Long, String> getTemplateList(){
        Map<Long, String> result = new HashMap<>();
        for (RoleEntity item : this.repository.findAll()) {
            result.put(item.getId(), item.getName());
        }

        return result;
    }

    public RoleRepo findRole(final Long roleId) {
        return this.repository.findById(roleId).orElse(null);
    }
    
    public List<RoleRepo> findAll() {
		return this.repository.findAll();
	}

    public void generateRole() {
    	if(this.findAll().isEmpty()) {
    		RoleEntity roleSeller = new RoleEntity();
        	RoleEntity roleCustomer = new RoleEntity();
        	roleSeller.setName("Seller");
        	roleCustomer.setName("Customer");
        	this.repository.save(roleSeller);
        	this.repository.save(roleCustomer);
    	}
    }
}