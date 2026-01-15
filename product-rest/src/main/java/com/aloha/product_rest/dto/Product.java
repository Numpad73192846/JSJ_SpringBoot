package com.aloha.product_rest.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Product")
public class Product extends Base {
	
	private String productName;
	private Integer price;
	private Integer stock;

}
