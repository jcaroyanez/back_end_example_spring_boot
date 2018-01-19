package com.aplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aplication.entitys.MenuCategory;
import com.aplication.service.ServiceMenuCategory;

import com.aplication.util.ConsUtil;
import com.aplication.util.ResponseUtil;

@RestController
public class ControllerMenuCategory {
     
	@Autowired
	ServiceMenuCategory serviceMenuCategory;
	
	@RequestMapping(method = RequestMethod.POST, value="/menuCategory")
	public ResponseEntity<?> addMenuCategory(@RequestParam String name){
		
      MenuCategory menuCategory = new MenuCategory();
      menuCategory.setCategoryName(name);
      menuCategory.setState(0);
      ResponseUtil responseUtil =  new ResponseUtil();
      MenuCategory menuCategoryAux = serviceMenuCategory.findByName(name);
      if(menuCategoryAux != null){
	      responseUtil.setMessage(ConsUtil.MSG_CATEGORY_SAVE_ERROR);
	      responseUtil.setTipo(ConsUtil.CODE_ERROR);
      }else{
	      serviceMenuCategory.createMenuCategory(menuCategory);     
	      responseUtil.setMessage(ConsUtil.MSG_CATEGORY_SAVE_SUCCESS);
	      responseUtil.setTipo(ConsUtil.CODE_OK); 		
      }
      return new ResponseEntity(responseUtil, HttpStatus.OK);  
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/menuCategory/{id}")
	public ResponseEntity<?> addMenuCategory(@PathVariable Integer id){
		
	   serviceMenuCategory.deleteMenuCategory(id);
	   
	   return new ResponseEntity("Categoria eliminada exitosamente ", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/menuCategory")
	public ResponseEntity<?> FindAllMenuCategory(){
		
	  
	   return new ResponseEntity(serviceMenuCategory.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/menuCategory/{id}")
	public ResponseEntity<?> FindOneMenuCategory(@PathVariable Integer id){
		
	  
	   return new ResponseEntity(serviceMenuCategory.findOne(id), HttpStatus.OK);
	}
	
	
	
}
