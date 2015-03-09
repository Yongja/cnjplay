package com.coupang.WEBPS004.cnjplay.main;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import com.coupang.WEBPS004.cnjplay.items.DealItem;

/**
 * @author Administrator
 * 
 */
public class WEBPS004Impl implements WEBPS004 {

	private Map<String, DealItem<String>> items = null;

	@Override
	public Map<String, DealItem<String>> getItems() {
		return this.items;
	}

	@Override
	public void saveItem(String dealId, String dealOptionId) {

		if (dealId != null && dealOptionId != null) {

			if (items == null) {
				items = new HashMap<String, DealItem<String>>();
			}

			DealItem<String> dealItem = items.get(dealId);

			if (dealItem == null) {
				dealItem = new DealItem<String>();
				dealItem.setDealId(dealId);
			}
			dealItem.addOptions(dealOptionId);

			items.put(dealId, dealItem);
		}
	}

	@Override
	public void printItem(String dealIdSort, String optionIdSort) {
		TreeSet<String> sortedSet = new TreeSet<String>(items.keySet());
		Iterator<String> iter = null;
		if (WEBPS004.SORT_ASC.equals(dealIdSort)) {
			iter = sortedSet.iterator();
		} else if (WEBPS004.SORT_DESC.equals(dealIdSort)) {
			iter = sortedSet.descendingIterator();
		}

		while (iter.hasNext()) {
			String dealId = iter.next();
			System.out.println(dealId + "->"
					+ items.get(dealId).getDealOptions(optionIdSort));
		}

	}

	@Override
	public void printItem(Iterator<String> iter, String sortOptions) {
		while (iter.hasNext()) {
			String dealId = iter.next();
			System.out.println(dealId + "->"
					+ items.get(dealId).getDealOptions(sortOptions));
		}
	}

	@Override
	public Iterator<String> sortDealId(Map<String, DealItem<String>> items,
			String sortMethod) {

		if (items == null) {
			return null;
		}
		TreeSet<String> sortedSet = new TreeSet<String>(items.keySet());
		Iterator<String> iter = null;
		if (WEBPS004.SORT_ASC.equals(sortMethod)) {
			iter = sortedSet.iterator();
		} else if (WEBPS004.SORT_DESC.equals(sortMethod)) {
			iter = sortedSet.descendingIterator();
		}
		return iter;
	}

	@Override
	public void clear() {
		if (items != null) {
			items.clear();
		}
	}
}
