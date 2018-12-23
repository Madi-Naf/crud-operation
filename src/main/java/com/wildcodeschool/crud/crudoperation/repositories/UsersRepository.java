package com.wildcodeschool.crud.crudoperation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.crud.crudoperation.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
