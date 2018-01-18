package com.aplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.entitys.MenuCategory;
import com.aplication.methods.MenuCategoryImpl;
import com.aplication.repository.MenuCategoryRepository;

@Service
public class ServiceMenuCategory implements MenuCategoryImpl {

	@Autowired
	MenuCategoryRepository menuCategoryRepository;
	
	@Override
	public void createMenuCategory(MenuCategory m) {
		
		menuCategoryRepository.save(m);
	}

	@Override
	public void deleteMenuCategory(Integer id) {
		
		menuCategoryRepository.delete(id);	
	}

	@Override
	public List<MenuCategory> findAll() {
		
		return (List<MenuCategory>) menuCategoryRepository.findAll();	
	}

	@Override
	public MenuCategory findOne(Integer id) {
		
		return menuCategoryRepository.findOne(id);
	}

}
