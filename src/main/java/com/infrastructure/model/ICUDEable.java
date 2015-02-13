package com.infrastructure.model;

/**
 * 标识实体是否可以增、删、改、可用操作接口的集合
 *
 */
public interface ICUDEable extends ICreatable,IUpdatable,IDeletable,IEnableable {

}