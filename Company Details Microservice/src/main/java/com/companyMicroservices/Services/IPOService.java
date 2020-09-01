package com.companyMicroservices.Services;

import java.sql.Date;
import java.util.List;

import com.companyMicroservices.Model.IPO;


public interface IPOService {
   // public abstract IPO createSector(String name, String brief);
   public abstract IPO updateIpo(String ipo_id,String num_of_shares,String D,Float price_per_share,String remarks,int company_id);
   // public abstract boolean deleteSector(String id);
    public abstract List<IPO> getIpo(int id);
    public abstract List<IPO> getIpo();
    public abstract IPO createIpo(String num_of_shares,Date D,Float price_per_share,String remarks,int company_id);
}