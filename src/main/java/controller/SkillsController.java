package controller;

import model.Skills;
import service.SkillsService;

import java.util.List;

public class SkillsController {
    SkillsService skillsService;
    public void save(Skills skills){

        skillsService.save(skills);
    }
    public void update(Skills skills){
        skillsService.update(skills);
    }
    public boolean delete(Long id){
        return skillsService.delete(id);
    }
    public Skills getById(Long id){
        return skillsService.getById(id);
    }
    public List<Skills> getAll(){
        return skillsService.getAll();
    }
}
