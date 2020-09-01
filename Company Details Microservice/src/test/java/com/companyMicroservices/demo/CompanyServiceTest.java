package com.companyMicroservices.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.companyMicroservices.Model.Company;
import com.companyMicroservices.Repository.CompanyRepository;
import com.companyMicroservices.Services.CompanyServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {
	@Autowired
	private CompanyServiceImpl companyservice;
	@MockBean
	private CompanyRepository companyrepository;

	
	
	

}
