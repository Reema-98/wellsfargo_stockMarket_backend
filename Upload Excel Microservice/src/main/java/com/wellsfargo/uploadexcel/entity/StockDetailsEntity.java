package com.wellsfargo.uploadexcel.entity;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="stock")
@Table(schema = "stock_price", name="stock")
public class StockDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id")
	private int stockId;
	
	@Column(name = "company_id")
	private int companyCode;	
	
	@Column(name = "exchange_id")
	private String stockExchangeCode;
	
	@Column(name = "price")
	private float pricePerShare;
	
	@Column(name = "date")
	private LocalDate date;	
	
	@Column(name = "time")
	private LocalTime time;

	public StockDetailsEntity() {}
	
	public StockDetailsEntity(int companyCode, String stockExchangeCode, float pricePerShare,
			LocalDate date, LocalTime time) {
		this.companyCode = companyCode;
		this.stockExchangeCode = stockExchangeCode;
		this.pricePerShare = pricePerShare;
		this.date = date;
		this.time = time;
	}
	
	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchangeCode() {
		return stockExchangeCode;
	}

	public void setStockExchangeCode(String stockExchangeCode) {
		this.stockExchangeCode = stockExchangeCode;
	}

	public float getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}