package com.coupang.WEBAPP003.cnjplay.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.coupang.WEBAPP003.cnjplay.comparator.ProudctComparator;
import com.coupang.WEBAPP003.cnjplay.exception.SearchConditionException;
import com.coupang.WEBAPP003.cnjplay.product.Product;
import com.coupang.WEBAPP003.cnjplay.product.ProductData;
import com.coupang.WEBAPP003.cnjplay.util.ChosungSearcher;


public class WEBAPP003Impl implements WEBAPP003 {


	@Override
	public List<Product> getProudctList() {
		ProductData data = new ProductData();  
		List<Product> list = data.getProductList();  
		return list;
	}

	@Override
	public void printProduct(List<Product> searchList) {
		if (searchList == null || searchList.isEmpty()) {
			System.out.println("검색된 결과가 없습니다.");
		} else {
			Iterator<Product> iter2 = searchList.iterator();
			while (iter2.hasNext()) {
				Product product = iter2.next();

				NumberFormat nf = NumberFormat.getNumberInstance();
	 
				System.out.println("상품명 : " + product.getProductName()
						+ " 총매출액 : " + nf.format(product.getTotalPrice()));
			}
		}
	}

	@Override
	public List<Product> searchProductList(String searchText)
			throws SearchConditionException {

		if (searchText == null) {
			throw new SearchConditionException("검색 조건을 입력 하세세요");
		} else if (searchText.length() < 2) {
			throw new SearchConditionException("검색조건은 2자 이상을 입력하십시오.");
		}
		
		List<Product> list = getProudctList();
		Iterator<Product> iter = list.iterator();
		List<Product> searchList = new ArrayList<Product>();  
																 
		while (iter.hasNext()) {
			Product product = iter.next();
	 
			
			
			if (ChosungSearcher.matchString(product.getProductName(),
					searchText)) {
				searchList.add(product);
			}
		}
		Collections.sort(searchList, new ProudctComparator());  
		return searchList;
	}

	public static void main(String[] args) throws IOException {

		WEBAPP003Impl main = new WEBAPP003Impl();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			String searchText = null;
			System.out.println("#############################################");
			System.out.println("화면에 exit 를 입력후 Enter Key 입력시 프로그램이 종료됩니다.");
			System.out.println("#############################################");
			System.out.print("초성 검색어: ");
			
			while (!(searchText = br.readLine()).equals("exit")) {
				try {
					List<Product> searchList = main
							.searchProductList(searchText);
					main.printProduct(searchList);
				} catch (SearchConditionException sce) {
					System.err.println(sce.getMessage());
				}
				System.out.print("초성 검색어: ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
}
