package service;

import model.Skills;
import repository.impl.JdbcSkillsRepositoryImpl;

import java.util.List;

public class SkillsService {
    JdbcSkillsRepositoryImpl jdbcSkillsRepository;
    public void save(Skills developers){
        jdbcSkillsRepository.save(developers);
    }
    public void update(Skills developers){
        jdbcSkillsRepository.update(developers);
    }
    public boolean delete(Long id){
        return jdbcSkillsRepository.delete(id);
    }
    public Skills getById(Long id){
        return jdbcSkillsRepository.getById(id);
    }
    public List<Skills> getAll(){
        return jdbcSkillsRepository.getAll();
    }
}
