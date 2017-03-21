package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

}
