package com.example.destination;

public class Destination {
private String name,populair;

public Destination(String name, String populair) {
	this.name = name;
	this.populair = populair;
}

public String getPopulair() {
	return populair;
}

public void setPopulair(String populair) {
	this.populair = populair;
}

public String getName() {
	return name;
}

public Destination() {
}

public void setName(String name) {
	this.name = name;
}
}
