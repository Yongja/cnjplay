
package com.coupang.WEBPS004.cnjplay.main;

import java.util.Iterator;
import java.util.Map;

import com.coupang.WEBPS004.cnjplay.items.DealItem;



public interface WEBPS004 {
	final String SORT_DESC = "DESC";
	final String SORT_ASC = "ASC";
	
	/**
	 * 아이템 등록
	 */
	void saveItem(String dealId, String dealOptionId);
	
	
	/**
	 * 등록된 아이템 조회
	 * @return
	 */
	Map<String, DealItem<String>> getItems();
	
	
	
	/**
	 * 아이템 출력
	 * @param iter
	 * @param sortOptions
	 */
	void printItem(Iterator<String> iter , String sortOptions);
	
	/**
	 * 아이템 정렬
	 * @param items
	 * @param sortMethod
	 * @return
	 */
	Iterator<String> sortDealId(Map<String, DealItem<String>> items,String sortMethod);
	
	
	/**
	 * 아이템 초기화
	 */
	void clear();


	/**
	 * 프린트
	 * @param dealIdSort
	 * @param optionIdSort
	 */
	void printItem(String dealIdSort, String optionIdSort);
}
