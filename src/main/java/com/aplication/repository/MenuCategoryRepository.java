package com.aplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aplication.entitys.MenuCategory;


public interface MenuCategoryRepository extends CrudRepository<MenuCategory,Integer> {
  
	  @Query(value = "select * from menu_category where category_name = ?1", nativeQuery = true)
	  MenuCategory findByName(String name);
}
