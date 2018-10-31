package controller;

import model.Companies;
import service.CompaniesService;

import java.util.List;

public class CompaniesController {
    CompaniesService companiesService;
    public void save(Companies developers){
        companiesService.save(developers);
    }
    public void update(Companies developers){
        companiesService.update(developers);
    }
    public boolean delete(Long id){
        return companiesService.delete(id);
    }
    public Companies getById(Long id){
        return companiesService.getById(id);
    }
    public List<Companies> getAll() {
        return companiesService.getAll();
    }
}
