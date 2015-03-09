package com.coupang.WEBPS004.cnjplay.items;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DealItem<T> {

	public static final String SORT_ASC = "ASC";
	public static final String SORT_DESC = "DESC";

	private String dealId; // Deal ID

	private List<T> dealOptions; // Deal Options

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public List<T> getDealOptions(String sortOptions) {
		return sort(dealOptions, sortOptions);
	}

	public void addOptions(T option) {
		if (dealOptions == null) {
			dealOptions = new ArrayList<T>();
		}
		dealOptions.add(option);
	}


	public List<T> sort(List<T> list, final String sortOptions) {
		Comparator<T> comparator = new Comparator<T>() {
			@Override
			public int compare(T arg0, T arg1) {
				int returnValue = 0;
				if (arg0 instanceof Integer) {
					Integer obj0 = (Integer) arg0;
					Integer obj1 = (Integer) arg1;

					if (SORT_ASC.equals(sortOptions)) {
						if (obj0 > obj1) {
							returnValue = 1;
						} else if (obj0 < obj1) {
							returnValue = -1;
						}
					} else {
						if (obj0 > obj1) {
							returnValue = -1;
						} else if (obj0 < obj1) {
							returnValue = 0;
						}
					}

				} else if (arg0 instanceof String) {
					String obj0 = (String) arg0;
					String obj1 = (String) arg1;

					if (SORT_ASC.equals(sortOptions)) {
						returnValue = obj0.compareTo(obj1);
					} else {
						returnValue = obj1.compareTo(obj0);

					}
				}

				return returnValue;
			}
		};

		Collections.sort(list, comparator);
		return list;
	}
}
