package service;

import model.Projects;
import repository.impl.JdbcProjectsRepositoryImpl;

import java.util.List;

public class ProjectsService {
    JdbcProjectsRepositoryImpl jdbcProjectsRepository;
    public void save(Projects developers){
        jdbcProjectsRepository.save(developers);
    }
    public void update(Projects developers){
        jdbcProjectsRepository.update(developers);
    }
    public boolean delete(Long id){
        return jdbcProjectsRepository.delete(id);
    }
    public Projects getById(Long id){
        return jdbcProjectsRepository.getById(id);
    }
    public List<Projects> getAll(){
        return jdbcProjectsRepository.getAll();
    }
}
