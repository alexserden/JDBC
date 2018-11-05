package repository.impl;

import model.Companies;
import repository.CompaniesRepository;
import repository.util.ConnectionUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCompaniesRepositoryImpl implements CompaniesRepository {

    public void save(Companies companies) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("INSERT INTO companies (id,name)"+ " VALUES ("
                    + companies.getId()+"," + companies.getName()+")"
            );

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to save companies");
        }


    }

    public void update(Companies companies) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("UPDATE  companies (id,name)"+ " SET ("
                    + companies.getId()+"," + companies.getName()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(Long id) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("DELETE FROM companies WHERE id = "+id);

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to delete companies");

            return false;
        }
        ConnectionUtil.close();
        return true;
    }

    public Companies getById(Long id) {
        Statement statement;
        String name = "";
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM companies WHERE id = "+ id);
            while(resultSet.next()){
                name = resultSet.getString("name");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Companies(id,name);    }

    public List<Companies> getAll() {
        List<Companies> companiesList = new ArrayList<Companies>();
        Statement statement;
        Long id;
        String name;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");
            while(resultSet.next()){
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                companiesList.add(new Companies(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companiesList;
    }
}
