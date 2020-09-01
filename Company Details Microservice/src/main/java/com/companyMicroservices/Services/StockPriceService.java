package com.companyMicroservices.Services;

import java.sql.Date;
import java.util.List;

import com.companyMicroservices.Model.StockPrice;

public interface StockPriceService {
	public abstract List<StockPrice> getStockprice(int company_id,Date fromdate, Date todate);

}
