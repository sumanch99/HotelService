package com.cognizant.hotelservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.hotelservice.bean.MenuItem;


@RestController
@RequestMapping("/cart")
public class CartController {
	
	public static Map<Integer,MenuItem> cart = new HashMap<>();
	
	@PostMapping("/{id}")
	public ResponseEntity<Object> addToCartViaPost(@PathVariable("id") int id) {
		if(!MenuItemController.menuItemList.containsKey(id)) {
			return new ResponseEntity<>("MenuItem with Id:"+id+" Not Found", HttpStatus.NOT_FOUND);
		}
		MenuItem menuItem = MenuItemController.menuItemList.get(id);
		cart.put(id, menuItem);
		
		return new ResponseEntity<>("MenuItem added to cart successfully", HttpStatus.CREATED);
	}
	

	@PatchMapping("/")
	public ResponseEntity<Object> addToCart(@RequestBody MenuItem m) {
		
		if(!MenuItemController.menuItemList.containsKey(m.getMenuItemId())) {
			return new ResponseEntity<>("MenuItem with Id:"+m.getMenuItemId()+" Not Found", HttpStatus.NOT_FOUND);
		}
		
		MenuItem menuItem = MenuItemController.menuItemList.get(m.getMenuItemId());
		cart.put(m.getMenuItemId(), menuItem);
		
		return new ResponseEntity<>("MenuItem added to cart successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<Object> viewCart() {
		return new ResponseEntity<>(cart.values(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCartItem(@PathVariable("id") int id) {
		if (!cart.containsKey(id)) {
			return new ResponseEntity<>("Cart Item with id:" + id + " not found", HttpStatus.NOT_FOUND);
		}
		MenuItem menuItem = cart.get(id);
		cart.remove(id);
		return new ResponseEntity<>(menuItem + "is deleted successsfully", HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<Object> deleteCart() {
		cart.clear();
		return new ResponseEntity<>("All Cart Items deleted successsfully", HttpStatus.OK);
	}
}
