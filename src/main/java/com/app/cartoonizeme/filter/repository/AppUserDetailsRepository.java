package com.app.cartoonizeme.filter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.cartoonizeme.filter.model.App_User_Details;

public interface AppUserDetailsRepository extends JpaRepository<App_User_Details, Long>{
	 
    @Query("SELECT c FROM App_User_Details c WHERE c.username = :username")
      App_User_Details findByUsername(String username); 
}
