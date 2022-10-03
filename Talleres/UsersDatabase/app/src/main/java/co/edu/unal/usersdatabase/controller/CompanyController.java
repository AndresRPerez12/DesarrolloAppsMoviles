package co.edu.unal.usersdatabase.controller;

import android.content.Context;

import java.util.List;

import co.edu.unal.usersdatabase.dataAccess.model.Company;
import co.edu.unal.usersdatabase.dataAccess.repository.CompanyRepository;

public class CompanyController {

    private CompanyRepository companyRepository;
    public  CompanyController(){}

    public List<Company> getAllCompanies(Context context){
        companyRepository = new CompanyRepository(context);
        return companyRepository.getAllUsers();
    }

    public Company getCompanyById(int id, Context context){
        companyRepository = new CompanyRepository(context);
        return companyRepository.getCompanyById(id);
    }

    public Company getCompanyByEmail(String email, Context context){
        companyRepository = new CompanyRepository(context);
        return companyRepository.getCompanyByEmail(email);
    }

    public void createCompany(final Company company, Context context){
        companyRepository = new CompanyRepository(context);
        companyRepository.createCompany(company);
        System.out.println("Company " + company.getName() + " created.");
    }

    public void updateCompany(final Company company, Context context){
        companyRepository = new CompanyRepository(context);
        companyRepository.updateCompany(company);
        System.out.println("Company " + company.getName() + " updated.");
    }

    public void deleteCompany(int id, Context context){
        companyRepository = new CompanyRepository(context);
        companyRepository.deleteUser(id);
        System.out.println("Company with id" + id + " deleted.");
    }

    public List<Company> filterByName(String filterName, Context context){
        companyRepository = new CompanyRepository(context);
        return companyRepository.filterByName(filterName);
    }

    public List<Company> filterByClassification(String filterClassification, Context context){
        companyRepository = new CompanyRepository(context);
        return companyRepository.filterByClassification(filterClassification);
    }

}
