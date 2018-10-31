package controller;

import model.Projects;
import service.ProjectsService;

import java.util.List;

public class ProjectsController {
    ProjectsService projectsService;
    public void save(Projects developers){
        projectsService.save(developers);
    }
    public void update(Projects developers){
        projectsService.update(developers);
    }
    public boolean delete(Long id){
        return projectsService.delete(id);
    }
    public Projects getById(Long id){
        return projectsService.getById(id);
    }
    public List<Projects> getAll(){
        return projectsService.getAll();
    }
}
