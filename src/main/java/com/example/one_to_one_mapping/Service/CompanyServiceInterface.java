package com.example.one_to_one_mapping.Service;

import java.util.List;

import com.example.one_to_one_mapping.Entity.Company;

public interface CompanyServiceInterface {
    List<Company> getAll();
    Company addCompany(Company company);
    Company updateCompanyById(Company company);
    String deleteCompanyById(Long companyID);
    Company getCompanyByName(String companyName);
    List<Company> getCompanyByNameContaining(String companyName);
}
