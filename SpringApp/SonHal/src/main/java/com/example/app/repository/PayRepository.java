package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.Pay;

public interface PayRepository extends JpaRepository<Pay, Integer>{
}
