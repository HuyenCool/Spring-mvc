package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.DishEntity;


public interface DishRepository  extends JpaRepository<DishEntity, Long> {

}
