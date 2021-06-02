package com.cognizant.hotelservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.hotelservice.bean.MenuItem;

@RestController
@RequestMapping("/menuItem")
public class MenuItemController {
	
	public static Map<Integer,MenuItem> menuItemList = new HashMap<>();
	
	{
		menuItemList.put(1,new MenuItem(1,"Chicken Biriyani",300.0));
		menuItemList.put(2,new MenuItem(2,"Chicken Chap",150.0));
		menuItemList.put(3,new MenuItem(3,"Hakka Noodles",150.0));
		menuItemList.put(4,new MenuItem(4,"Mutton Korma",325.0));
	}
	
	@GetMapping("")
	public ResponseEntity<Object> viewMenuItemList() {
		return new ResponseEntity<>(menuItemList.values(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> viewMenuItem(@PathVariable("id") int id) {
		if (!menuItemList.containsKey(id)) {
			return new ResponseEntity<>("Menu Item with id:" + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(menuItemList.get(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editMenuItem(@PathVariable("id") int id, @RequestBody MenuItem menuItem) {
		if (!menuItemList.containsKey(id)) {
			return new ResponseEntity<>("Menu Item with id:" + id + " not found", HttpStatus.NOT_FOUND);
		}
		menuItem.setMenuItemId(id);
		menuItemList.remove(id);
		menuItemList.put(id, menuItem);
		return new ResponseEntity<>(menuItemList.get(id) + " Updated Successfully", HttpStatus.OK);
	}
}
