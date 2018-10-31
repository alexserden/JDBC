package service;

import model.Companies;
import repository.impl.JdbcCompaniesRepositoryImpl;

import java.util.List;

public class CompaniesService {
    JdbcCompaniesRepositoryImpl jdbcCompaniesRepositoryimpl;
    public void save(Companies companies){
        jdbcCompaniesRepositoryimpl.save(companies);
    }
    public void update(Companies developers){
        jdbcCompaniesRepositoryimpl.update(developers);
    }
    public boolean delete(Long id){
        return jdbcCompaniesRepositoryimpl.delete(id);
    }
    public Companies getById(Long id){
        return jdbcCompaniesRepositoryimpl.getById(id);
    }
    public List<Companies> getAll(){
        return jdbcCompaniesRepositoryimpl.getAll();
    }
}
