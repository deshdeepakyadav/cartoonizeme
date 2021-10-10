package com.app.cartoonizeme.filter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.cartoonizeme.filter.exception.UserNotFoundException;
import com.app.cartoonizeme.filter.model.App_User_Details;
import com.app.cartoonizeme.filter.repository.AppUserDetailsRepository;

@RestController
public class UserController {

	@Autowired
	private AppUserDetailsRepository appUserDetailsRepository;

	@PostMapping("/signup")
	public String processRegister(@RequestBody App_User_Details user) {
		System.out.println("user.getUsername() : " + user.getUsername());
		appUserDetailsRepository.save(user);
		return user.getUsername() + " registered";
	}

	@PutMapping("/resetpassword")
	public String updatePassword(@RequestBody App_User_Details user) {
		App_User_Details tempUser = appUserDetailsRepository.findByUsername(user.getUsername());
        if (tempUser != null) {
        	tempUser.setPassword(user.getPassword());
        	appUserDetailsRepository.save(tempUser);
        } else {
            throw new UserNotFoundException("Could not find any user with the username " + user.getUsername());
        }
        return "Password updated.";
	}

}
