package com.example.one_to_one_mapping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.one_to_one_mapping.Entity.Company;
import com.example.one_to_one_mapping.Repository.CompanyRepo;

@Service
public class CompanyService implements CompanyServiceInterface{
    CompanyRepo cpr;
    
    @Autowired
    public CompanyService(CompanyRepo cpr) {
        this.cpr = cpr;
    }

    @Override
    public List<Company> getAll() {
        
        return cpr.findAll();
    }

    @Override
    public Company addCompany(Company company) {
        return cpr.save(company);
    }

    @Override
    public Company updateCompanyById(Company company) {
        Company updateCompany = cpr.findById(company.getCompanyID()).get();
        updateCompany.setCompanyName(company.getCompanyName());
        updateCompany.setEmp(company.getEmp());

        cpr.save(updateCompany);
        
        return updateCompany;
    }

    @Override
    public String deleteCompanyById(Long companyID) {
        Company deleteCompany = cpr.findById(companyID).get();
        cpr.delete(deleteCompany);
        return "Company is removed from Database!";
    }

    @Override
    public Company getCompanyByName(String companyName) {
        return cpr.findByCompanyName(companyName).get(0);
    }

    @Override
    public List<Company> getCompanyByNameContaining(String companyName) {
        return cpr.findByCompanyNameContaining(companyName);
    }
    
    
}
