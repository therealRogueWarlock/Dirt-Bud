package com.github.therealroguewarlock.dirtbud.model.entities;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private int weight;
	private int height;
	private int vo2Max;
	private int yearsRiding;


	public User(String firstName, String lastName, int age, int weight, int height, int vo2Max, int yearsRiding) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.vo2Max = vo2Max;
		this.yearsRiding = yearsRiding;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVo2Max() {
		return vo2Max;
	}

	public void setVo2Max(int vo2Max) {
		this.vo2Max = vo2Max;
	}

	public int getYearsRiding() {
		return yearsRiding;
	}

	public void setYearsRiding(int yearsRiding) {
		this.yearsRiding = yearsRiding;
	}
}
