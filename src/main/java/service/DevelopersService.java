package service;

import model.Developers;
import repository.impl.JdbcDevelopersRepositoryImpl;

import java.util.List;

public class DevelopersService {
    JdbcDevelopersRepositoryImpl jdbcDevelopersRepository;

    public void save(Developers developers){
        jdbcDevelopersRepository.save(developers);
    }
    public void update(Developers developers){
        jdbcDevelopersRepository.update(developers);
    }
    public boolean delete(Long id){
        return jdbcDevelopersRepository.delete(id);
    }
    public Developers getById(Long id){
        return jdbcDevelopersRepository.getById(id);
    }
    public List<Developers> getAll(){
        return jdbcDevelopersRepository.getAll();
    }
}
