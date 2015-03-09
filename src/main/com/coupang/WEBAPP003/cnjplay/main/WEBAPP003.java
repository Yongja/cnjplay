package com.coupang.WEBAPP003.cnjplay.main;

import java.util.List;

import com.coupang.WEBAPP003.cnjplay.exception.SearchConditionException;
import com.coupang.WEBAPP003.cnjplay.product.Product;

public interface WEBAPP003 {

	List<Product> getProudctList();

	
	void printProduct(List<Product> searchList);


	List<Product> searchProductList(String searchText)
			throws SearchConditionException;
}
