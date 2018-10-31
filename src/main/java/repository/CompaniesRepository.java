package repository;

import model.Companies;

import java.util.List;

public interface CompaniesRepository extends GenericRepository<Companies,Long> {
    void save(Companies developers);

    void update(Companies developers);

    boolean delete(Long id);


    Companies getById(Long id);

    List<Companies> getAll();
}
