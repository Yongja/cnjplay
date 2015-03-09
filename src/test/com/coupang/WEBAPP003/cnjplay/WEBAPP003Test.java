package com.coupang.WEBAPP003.cnjplay;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.junit.Test;

import com.coupang.WEBAPP003.cnjplay.exception.SearchConditionException;
import com.coupang.WEBAPP003.cnjplay.main.WEBAPP003;
import com.coupang.WEBAPP003.cnjplay.main.WEBAPP003Impl;
import com.coupang.WEBAPP003.cnjplay.product.Product;
import com.coupang.WEBAPP003.cnjplay.util.ChosungSearcher;


public class WEBAPP003Test {

	private WEBAPP003 webapp003 = new WEBAPP003Impl();

	/**
	 * ChosungSearcher test
	 */
	@Test
	public void test01() {

		String testString = "도드람포크 돼지갈비";

		String searchText = "ㄷㄷㄹ";

		assertThat(ChosungSearcher.matchString(testString, searchText),
				is(true));

		assertThat(ChosungSearcher.matchString(testString, "돼지갈비"), is(true));

		assertThat(ChosungSearcher.matchString(testString, "ㄷㅈㄱㅂ"), is(true));

	}


	@Test
	public void testGetProductList() {

		List<Product> prodList = webapp003.getProudctList();
		assertThat(true, is(not(prodList.isEmpty()))); 
	}

	@Test
	public void testSearchProductList() {

		List<Product> searchList;


		String message = "";
		boolean isBoolean = false;
		try {
			searchList = webapp003.searchProductList("");
			// assertThat(searchList.size() > 0, is(false));
		} catch (SearchConditionException e) {
			// assertThat(e.getMessage(), false);
			isBoolean = true;
			message = e.getMessage();
		}

		assertThat(message, true, is(isBoolean));

		try {
			searchList = webapp003.searchProductList("..");
			assertThat(searchList.size() > 0, is(false));
		} catch (SearchConditionException e) {
			assertThat(e.getMessage(), false);
			isBoolean = true;
			message = e.getMessage();
		}

		assertThat(message, true, is(isBoolean));

	 
		try {
			searchList = webapp003.searchProductList("K");
			isBoolean = false;
			assertThat(searchList.size() > 0, is(false));
		} catch (SearchConditionException e) {
			// assertThat(e.getMessage(), false);
			isBoolean = true;
			message = e.getMessage();
		}
		assertThat(message, true, is(isBoolean));

	 
		try {
			searchList = webapp003.searchProductList("ㅇㅈ");
			assertThat(searchList.size() > 0, is(true));
		} catch (SearchConditionException e) {
			assertThat(e.getMessage(), true);
		}

	
		try {
			searchList = webapp003.searchProductList("[정자]");
			assertThat(searchList.size() > 0, is(false));
		} catch (SearchConditionException e) {
			assertThat(e.getMessage(), true);
		}
	}


	@Test
	public void testPrintProduct() {
		try {
			List<Product> searchList = webapp003.searchProductList("ㅊㄱ");
			assertThat(searchList.size() > 0, is(true));
			webapp003.printProduct(searchList);
		} catch (Exception e) {
			assertThat(e.getMessage(), false);
		}
	}

}
