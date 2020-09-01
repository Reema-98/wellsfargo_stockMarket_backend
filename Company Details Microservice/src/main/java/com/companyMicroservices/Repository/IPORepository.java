package com.companyMicroservices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.companyMicroservices.Model.IPO;

public interface IPORepository extends JpaRepository<IPO, Integer>
{

	@Query("select d from IPO d WHERE d.company_id= ?1 ORDER BY d.open_date")
	List<IPO> searchIpo(int  id);

}