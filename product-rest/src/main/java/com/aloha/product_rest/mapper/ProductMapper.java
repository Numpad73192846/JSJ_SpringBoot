package com.aloha.product_rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.product_rest.dto.Product;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

	List<Product> list();
	Product select(Integer no);
	int insert(Product product);
	int update(Product product);
	int delete(Integer no);	
	
}
