package repository;

import model.Projects;

import java.util.List;

public interface ProjectsRepository extends GenericRepository<Projects,Long> {
    void save(Projects developers);

    void update(Projects developers);

    boolean delete(Long id);


    Projects getById(Long id);

    List<Projects> getAll();
}
