package com.cognizant.hotelservice.bean;

public class MenuItem {
	private int menuItemId;
	private String menuName;
	private double price;

	public MenuItem(int menuItemId, String menuName, double price) {
		super();
		this.menuItemId = menuItemId;
		this.menuName = menuName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuItem [menuItemId=" + menuItemId + ", menuName=" + menuName + ", price=" + price + "]";
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
