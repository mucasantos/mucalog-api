package com.mucasantos.mucalog.domain.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mucasantos.mucalog.domain.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String>{

	Optional<UserModel> findByUsername(String username);
}
