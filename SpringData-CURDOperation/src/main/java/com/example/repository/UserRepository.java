package com.example.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.entity.UserEntity;

@Repository
//CrudRepository Not Support for paging so we are using JPARepository,
//JPARepository Supports Paging and also sorting so we are Add JPA repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable>  {


}
