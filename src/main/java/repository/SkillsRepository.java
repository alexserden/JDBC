package repository;

import model.Skills;

import java.util.List;

public interface SkillsRepository extends GenericRepository<Skills,Long> {

    void save(Skills developers);

    void update(Skills developers);

    boolean delete(Long id);


    Skills getById(Long id);

    List<Skills> getAll();
}
