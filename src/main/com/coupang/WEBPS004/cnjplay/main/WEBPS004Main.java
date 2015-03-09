package com.coupang.WEBPS004.cnjplay.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.coupang.WEBPS004.cnjplay.items.DealItem;

public class WEBPS004Main {

	public static void main(String[] args) {

		WEBPS004 webps004 = new WEBPS004Impl();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("ex) 100,1 의 형식으로 id,option Id를 공백없이 입력하세요.");

			System.out
					.println("#################################################");
			System.out.println("모두 입력 후 정렬 exit 를 입력하세요");
			System.out
					.println("#################################################");

			String inputItems = null;
			while (!(inputItems = br.readLine()).equals("exit")) {

				String[] inputDeals = inputItems.split(",");

				if (inputDeals != null) {

					if (inputDeals.length == 2) {
						String id = inputDeals[0];
						String options = inputDeals[1];
						webps004.saveItem(id, options);
					} else {
						System.out
								.println("ex) 100,1 의 형식으로 id,option Id를 공백없이 입력하세요.");
					}
				}
			}
		} catch (Exception e) {
			System.err.println("오류가 발생했습니다.");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		Iterator<String> iter = webps004.sortDealId(webps004.getItems(),
				WEBPS004.SORT_ASC);
		webps004.printItem(iter, DealItem.SORT_ASC);

	}
}