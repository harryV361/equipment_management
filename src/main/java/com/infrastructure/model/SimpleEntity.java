package com.infrastructure.model;

public class SimpleEntity<PKType extends Number> extends Entity<PKType> {	
    private String name; 
    
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}	
}
