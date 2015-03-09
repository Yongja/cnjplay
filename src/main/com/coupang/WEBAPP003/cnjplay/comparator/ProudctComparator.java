package com.coupang.WEBAPP003.cnjplay.comparator;

import java.util.Comparator;

import com.coupang.WEBAPP003.cnjplay.product.Product;

public class ProudctComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		int returnValue = 0;

		if (o1.getTotalPrice() > o2.getTotalPrice()) {
			returnValue = -1;
		} else if (o1.getTotalPrice() < o2.getTotalPrice()) {
			returnValue = 1;
		}
		return returnValue;
	}
}
