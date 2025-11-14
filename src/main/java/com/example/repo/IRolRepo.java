package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Rol;

public interface IRolRepo extends JpaRepository<Rol, Integer> {

}
