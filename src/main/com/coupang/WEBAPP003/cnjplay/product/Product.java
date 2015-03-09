package com.coupang.WEBAPP003.cnjplay.product;

public class Product {
	private String productNo;

	private String productName;

	private long price;

	private long saleCount;

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(long saleCount) {
		this.saleCount = saleCount;
	}

	public Product(String productNo, String productName, long price,
			long saleCount) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
		this.saleCount = saleCount;
	}

	public long getTotalPrice() {
		return this.price * this.saleCount;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName="
				+ productName + ", price=" + price + ", saleCount=" + saleCount
				+ "]";
	}

}