package com.example.one_to_one_mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.one_to_one_mapping.Entity.Company;
import com.example.one_to_one_mapping.Service.CompanyService;

@RestController
@RequestMapping("/com")
public class Endpoint {
    CompanyService cs;

    @Autowired
    public Endpoint(CompanyService cs) {
        this.cs = cs;
    }

    @GetMapping("/GetAllCompanies")
    public ResponseEntity<List<Company>> getAllCompanies(){
        try {
            return new ResponseEntity<>(cs.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/AddNewCompany")
    public ResponseEntity<Company> addNewCompany(
        @RequestBody Company company){
            try {
                return new ResponseEntity<Company>(cs.addCompany(company), HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e);
                return new ResponseEntity<Company>(HttpStatus.BAD_GATEWAY);
            }
        }

    @PutMapping("updateCompanyById")
    public ResponseEntity<Company> updateCompanyById(@RequestBody Company company){
        try {
            return new ResponseEntity<Company>(cs.updateCompanyById(company), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("removeCompanyById/{companyID}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long companyID){
        try {
            return new ResponseEntity<>(cs.deleteCompanyById(companyID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findCompanyByname")
    public ResponseEntity<Company> findCompanyByName(@RequestParam String companyName){
        try {
            return new ResponseEntity<Company>(cs.getCompanyByName(companyName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findCompanyContainingName/{companyName}")
    public ResponseEntity<List<Company>> findCompanyContainingName(@PathVariable String companyName){
        try {
            return new ResponseEntity<>(cs.getCompanyByNameContaining(companyName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
