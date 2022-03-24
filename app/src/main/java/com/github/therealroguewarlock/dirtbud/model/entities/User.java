package com.github.therealroguewarlock.dirtbud.model.entities;

public class User {

	private final String userId;

	private String firstName;
	private String lastName;
	private int age;

	private Garage garage;
	private Inventory inventory;

	public User(String userId, String firstName, String lastName, int age) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
	}

	public int getAge() {
		return age;
	}

	public Garage getGarage() {
		return garage;
	}

	public Inventory getInventory() {
		return inventory;
	}

	// FIXME: Remove this?
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
