package com.aloha.product_rest.service;

import java.util.List;

import com.aloha.product_rest.dto.Pagination;
import com.github.pagehelper.PageInfo;

public interface BaseService<E> {
	
	List<E> list();
	E select(Integer no);
	PageInfo<E> page(Pagination pagination);
	E selectById(String id);
	boolean insert(E entity);
	boolean update(E entity);
	boolean updateById(E entity);
	boolean delete(Integer no);
	boolean deleteById(String id);

}
