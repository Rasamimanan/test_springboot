package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Afaka mamorona queries manokana koa raha ilaina
}
