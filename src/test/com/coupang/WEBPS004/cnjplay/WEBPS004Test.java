package com.coupang.WEBPS004.cnjplay;

import java.util.Map;

import org.junit.Test;

import com.coupang.WEBPS004.cnjplay.items.DealItem;
import com.coupang.WEBPS004.cnjplay.main.WEBPS004;
import com.coupang.WEBPS004.cnjplay.main.WEBPS004Impl;



public class WEBPS004Test {

	WEBPS004 webps004 = new WEBPS004Impl();


	@Test
	public void testPrintItem() {

		webps004.saveItem("110", "10");
		webps004.saveItem("101", "9");
		webps004.saveItem("101", "8");
		webps004.saveItem("103", "7");
		webps004.saveItem("105", "6");
		webps004.saveItem("105", "5");
		webps004.saveItem("101", "4");
		webps004.saveItem("103", "3");
		webps004.saveItem("103", "2");
		webps004.saveItem("110", "1");
	
		Map<String, DealItem<String>> items = webps004.getItems();

		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("output)");
		webps004.printItem(WEBPS004.SORT_ASC, DealItem.SORT_ASC);
		
	}

}
