package com.companyMicroservices.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.companyMicroservices.Model.StockPrice;
import com.companyMicroservices.Services.StockPriceServiceImpl;

@RestController
public class StockPriceController {
	
	@Autowired StockPriceServiceImpl stockpriceservice;
	
	@GetMapping("/getstockprice/{cid}/{fdate}/{tdate}")
	public List<StockPrice> getstockprice(@PathVariable int cid,@PathVariable String fdate,@PathVariable String tdate)
	{
		Date fromdate=Date.valueOf(fdate);
		Date todate=Date.valueOf(tdate);
		return stockpriceservice.getStockprice(cid, fromdate, todate);
	}

}
