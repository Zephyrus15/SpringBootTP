package com.example.demo.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.datatransfert.UserData;
import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.BookService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@Controller
@RequestMapping(UserController.BASE_ROUTE)
public class UserController extends BaseCrudController<UserEntity, UserData> {

    public static final String TEMPLATE_NAME = "user";
    public static final String BASE_ROUTE = "user";

    public UserController() {
        super(TEMPLATE_NAME);
    }

    @Autowired
    private UserService service;

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private UserRepo repository;

    @GetMapping("testgen")
    public void testGen() {
    	this.roleService.generateRole();
        this.service.generateUsers(20, this.roleService.findAll());
    }
    
    @Override
    public String index(Model model, HttpServletResponse response) {
    	this.roleService.generateRole();
        this.service.generateUsers(5, this.roleService.findAll());
        for (UserEntity user : this.service.getSeller()) {
            user.addBook(bookService.generateBooks());
            user.addBook(bookService.generateBooks());
            this.repository.save(user);
        }

    	return super.index(model, response);
    }

    @Override
    protected void preCreateGet(final Model model) {
        model.addAttribute("roles", this.roleService.getTemplateList());
    }

    @Override
    protected UserEntity preCreatePost(UserData dto, HttpServletRequest request) throws Exception {
        UserEntity user = new UserEntity();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        if (dto.getRoleId() != null) {
            RoleEntity role = this.roleService.findRole(dto.getRoleId());
            if (role == null) {
                throw new Exception("Cannot find whished role");
            }
            user.setRole(role);
        }

        return user;
    }
    
    
    @GetMapping("connect/{id}")
    public void connect(@PathVariable final Long id, final HttpServletResponse response) throws IOException {
    	Cookie cookie = new Cookie("idUser", Long.toString(id));
    	cookie.setPath("/");
    	response.addCookie(cookie);
    	Optional<UserEntity> user = service.findById(id);
		UserEntity myUser = user.get();
		if(myUser.getRole().getName().equals("Seller")) {
			response.sendRedirect("/book/create");
		}
		else if (myUser.getRole().getName().equals("Customer")) {
			response.sendRedirect("/book/index");
		}
		
    }

    @SuppressWarnings("static-access")
	@GetMapping("myBook")
	protected String buyAbook(@CookieValue(value= "idUser", defaultValue = "0") String strIdUser, final Model model, final HttpServletResponse response, HttpServletRequest request) {
    	UserEntity myUser = service.findById(Long.parseLong(strIdUser)).get();
    	model.addAttribute("items", myUser.getBooks());

		return "/" + this.TEMPLATE_NAME + "/myBook";
	}
}