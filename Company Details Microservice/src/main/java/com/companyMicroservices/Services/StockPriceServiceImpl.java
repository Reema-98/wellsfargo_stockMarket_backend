package com.companyMicroservices.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyMicroservices.Model.StockPrice;
import com.companyMicroservices.Repository.StockPriceRepository;

@Service
public class StockPriceServiceImpl implements StockPriceService{
	@Autowired StockPriceRepository stockpricerepository;
	
	@Override
	public List<StockPrice> getStockprice(int company_id,Date fromdate, Date todate)
	{
		List<StockPrice> results=stockpricerepository.getStockPrice(company_id, fromdate, todate);
		return results;
	}
	
	

}
