package com.coupang.WEBAPP003.cnjplay.product;

import java.util.ArrayList;
import java.util.List;

public class ProductData {

	private List<Product> productList = new ArrayList<Product>();

	public ProductData() {

		productList.add(new Product("24771911", "KFC 치킨불고기 콤보", 2600, 27));
		productList.add(new Product("24756487", "소다/카시오패션스포츠시계", 49800, 2));
		productList.add(new Product("24750911", "[목동] 육감숯불구이", 21600, 4));
		productList.add(new Product("24718904", "[정자] 박종일 프로헤어", 29000, 1));
		productList.add(new Product("24703223", "[구로디지털] LA식당", 30000, 29));
		productList.add(new Product("24702630", "고려홍삼명가 명기홍삼정", 65300, 1));
		productList.add(new Product("24692301", "쿠쿠 압력밥속", 21000, 2));
		productList.add(new Product("24671273", "나이키 BEST 런닝화 22종", 45000, 20));
		productList.add(new Product("24670532", "투세븐 자체제작F/W신상슈즈", 34900, 2));
		productList.add(new Product("24669991", "가을맞이 모던큐트로퍼/플랫", 17900, 9));
		productList.add(new Product("24669702", "트루릴리젼 프리미엄스니커즈", 37500, 1));
		productList.add(new Product("24667948", "나이키 남녀 팬츠 모음전", 49000, 1));
		productList.add(new Product("24664912", "축구/농구/배구 공모음전", 14000, 6));
		productList.add(new Product("24661322", "쿨제이 가을신상트랜디셔츠", 19800, 2));
		productList.add(new Product("24660422", "도드람포크 돼지갈비", 5400, 1));
		productList.add(new Product("24659696", "[후쿠오카]자유여행 3일189000", 189000,1));
		productList.add(new Product("24659141", "HK CLA다이어트", 29700, 1));
		productList.add(new Product("24654726", "[청담] 민한복", 350000, 15));
		productList.add(new Product("24654255", "[동대문] 애니피부", 15000, 4));
		productList.add(new Product("24651025", "영진 표고버섯 슬라이스1kg", 18500, 2));

	}

	public void addProduct(Product product) {

		productList.add(product);

	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}