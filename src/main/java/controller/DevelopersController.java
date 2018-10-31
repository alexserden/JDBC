package controller;

import model.Developers;
import service.DevelopersService;

import java.util.List;

public class DevelopersController {
    DevelopersService developersService;
    public void save(Developers developers){
        developersService.save(developers);
    }
    public void update(Developers developers){
        developersService.update(developers);
    }
    public boolean delete(Long id){
        return developersService.delete(id);
    }
    public Developers getById(Long id){
       return developersService.getById(id);
    }
    public List<Developers> getAll(){
        return developersService.getAll();
    }
}
