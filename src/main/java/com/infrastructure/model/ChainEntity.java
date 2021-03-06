package com.infrastructure.model;

import java.util.List;

public class ChainEntity<PKType extends Number, EntityType extends IChainEntity> extends EnableEntity<PKType> implements IChainEntity {
	
	private String levelCode;
	private int position;
	private String theValue;
	private EntityType parent;
	private List<EntityType> children;
	
	public int getPosition(){
		return this.position;
	}
	public void setPosition(int position){
		this.position=position;
	}
	
	public String getLevelCode(){
		return this.levelCode;
	}
	public void setLevelCode(String levelCode){
		this.levelCode=levelCode;
	}
    
	public String getTheValue(){
		return this.theValue;
	}
	public void setTheValue(String theValue){
		this.theValue=theValue;
	}
	
	public EntityType getParent(){
		return this.parent;
	}
	public void setParent(EntityType parent){
		this.parent=parent;
	}
	
	public List<EntityType> getChildren(){
		return this.children;
	}
	public void setChildren(List<EntityType> children){
		this.children=children;
	}
		
}
