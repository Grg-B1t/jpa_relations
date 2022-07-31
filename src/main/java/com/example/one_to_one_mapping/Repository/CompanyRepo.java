package com.example.one_to_one_mapping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.one_to_one_mapping.Entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long>{
    List<Company> findByCompanyName(String companyName);
    List<Company> findByCompanyNameContaining(String companyName);
}
