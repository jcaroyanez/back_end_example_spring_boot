package com.aplication.methods;

import java.util.List;

import com.aplication.entitys.MenuCategory;

public interface MenuCategoryImpl {

	public void createMenuCategory(MenuCategory m);
	
	public void deleteMenuCategory(Integer id);
	
	public List<MenuCategory> findAll();
	
	public MenuCategory findOne(Integer id);
}
