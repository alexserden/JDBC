package repository;

import model.Developers;

import java.util.List;

public interface DevelopersRepository extends GenericRepository<Developers,Long> {

    void save(Developers developers);

    void update(Developers developers);

    boolean delete(Long id);


    Developers getById(Long id);

    List<Developers> getAll();
}
