package com.cognizant.hotelservice.bean;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<MenuItem> menuItemList = new ArrayList<>();
	private double total;
	
	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
