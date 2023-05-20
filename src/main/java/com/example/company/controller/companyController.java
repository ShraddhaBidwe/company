package com.example.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.entity.UserRole;
import com.example.company.repository.companyRepository;
import com.example.company.request.companyRequest;
import com.example.company.response.companyResponse;
import com.example.company.service.companyService;
//import com.example.company.serviceImpl.company;
//import com.example.company.serviceImpl.companyRequest;


@RestController
public class companyController {
	
	@Autowired
    private companyService service;
    
    @Autowired
    private companyRepository repository;
    
    
 // get all data
    @GetMapping("/companies")
    public ResponseEntity<List<companyResponse>> getAllCompanies() throws Exception {
        List<companyResponse> companies = service.getAllCompanies();
        return new ResponseEntity<List<companyResponse>>(companies, HttpStatus.OK);
    }
    
    // get data by id
    @GetMapping("/companies/{companyId}")
    public ResponseEntity<companyResponse> getCompanyById(@PathVariable Long companyId) throws Exception {
        Optional<companyResponse> optionalCompany = service.getCompanyById(companyId);
        if (optionalCompany.isPresent()) {
            return ResponseEntity.ok(optionalCompany.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   

    //post company
    @PostMapping("/register")
	public ResponseEntity<companyResponse> signUp(@RequestBody companyRequest companyRequest) throws Exception {
		companyResponse response = service.createCompany(companyRequest);
		return ResponseEntity.ok(response);
	}
    
	
    // update
    @PutMapping("/companies/update/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Long companyId, @RequestBody companyRequest request) throws Exception {
        String updateResult = service.updateCompany(companyId, request);
        return new ResponseEntity<String>(updateResult, HttpStatus.OK);
    }
	
	
//	@PutMapping("/{companyId}")
//    public ResponseEntity<String> updateCompany(@PathVariable Long companyId, @RequestBody companyRequest request) {
//        Optional<company> optionalCompany = companyRepository.findByCompanyId(companyId);
//        if (optionalCompany.isPresent()) {
//        	company company = optionalCompany.get();
//            company.setCompanyName(request.getCompanyName());
//            company.setPhoneNumber(request.getPhoneNumber());
//            company.setEmailId(request.getEmailId());
//            company.setAddress(request.getAddress());
//            company.setDeleted(request.getIsDeleted());
//            companyRepository.save(company);
//            return ResponseEntity.ok("Company updated successfully.");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    
    // delete data
    @DeleteMapping("/companies/delete/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId) throws Exception {
        String deleteResult =service.deleteCompany(companyId);
        return new ResponseEntity <String> (deleteResult, HttpStatus.OK);
    }

    
    
}
