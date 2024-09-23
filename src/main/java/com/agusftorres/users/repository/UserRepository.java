package com.agusftorres.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agusftorres.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
