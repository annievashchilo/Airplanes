package utils;

import exceptions.CompanyNotFoundException;


public interface DataSrcUtils {

    public String getAviacompany(String companyName) throws CompanyNotFoundException;

    public void getAirplanes();
}
