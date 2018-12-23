package com.wildcodeschool.crud.crudoperation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildcodeschool.crud.crudoperation.entities.Users;
import com.wildcodeschool.crud.crudoperation.repositories.UsersRepository;

@RestController
public class UsersController {

	@Autowired
	UsersRepository usersRepo;
	
//  #################  CREATE ###################
// 	http://localhost:8080/create?firstName=momo&lastName=detoto&age=12
	@RequestMapping("/create")
	public Users createUser(String firstName, String lastName, int age) {
		Users user = new Users(firstName, lastName, age);
		return usersRepo.save(user);
	}
	
//  #################  READ BY ID ###################
//	http://localhost:8080/read?userId=1
	@RequestMapping("/read")
	public Users getUser(Long userId) {
		return usersRepo.findById(userId).get();
	}
	
//  #################  READ ALL ###################
//	http://localhost:8080/readall
	@RequestMapping("/readall")
	public List<Users> getAllUser() {
		return usersRepo.findAll();
	}
	
//  #################  UPDATE ###################
//	http://localhost:8080/update?userId=1&firstName=jeannoline&lastName=delarue&age=20
	@RequestMapping("/update")
	public Users updateUser(Long userId, String firstName, String lastName, int age) {
		Users userToUpdate = usersRepo.findById(userId).get();
		
		if(firstName != null) {
			userToUpdate.setfirstName(firstName);
		}
		if(lastName != null) {
			userToUpdate.setLastName(lastName);
		}
		if(age > 0) {
			userToUpdate.setAge(age);
		}
		return usersRepo.save(userToUpdate);
	}
//  #################  DELETE ###################
//	http://localhost:8080/delete?userId=1
	@RequestMapping("/delete")
	public void deleteUser(Long userId) {
		usersRepo.deleteById(userId);
	}
	
}


