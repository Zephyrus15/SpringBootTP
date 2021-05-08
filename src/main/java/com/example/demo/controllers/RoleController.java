package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.RoleEntity;
import com.example.demo.services.RoleService;

@Controller
@RequestMapping(RoleController.BASE_ROUTE)
public class RoleController extends BaseCrudController<RoleEntity, RoleEntity> {
    public static final String TEMPLATE_NAME = "role";
    public static final String BASE_ROUTE = "role";
    
    @Autowired
    private RoleService service;

    public RoleController() {
        super(TEMPLATE_NAME);
    }
    
    @GetMapping("testgen")
    public void testGen() {
        this.service.generateRole();
    }
}