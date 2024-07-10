package com.example.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rent.entity.Photo;

@Repository
public interface PhotoDao extends JpaRepository<Photo,Integer>{

}
