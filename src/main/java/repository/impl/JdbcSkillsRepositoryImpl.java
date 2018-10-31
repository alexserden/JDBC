package repository.impl;

import model.Skills;
import repository.SkillsRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JdbcSkillsRepositoryImpl implements SkillsRepository {

    public void save(Skills skills) {
        Statement statement;
        try {
            statement = JDBC.getConnection().createStatement();
            statement.executeQuery("INSERT INTO skills (id,name)"+ " VALUES ("
                    + skills.getId()+"," + skills.getName()+")"
            );

        } catch (SQLException e) {
            System.out.println("Failed to get statement in method save.");
        }
        JDBC.close();


    }

    public void update(Skills skills) {
        Statement statement;
        try {
            statement = JDBC.getConnection().createStatement();
            statement.executeQuery("UPDATE  skills (id,name)"+ " SET ("
                    + skills.getId()+"," + skills.getName()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.close();
    }

    public boolean delete(Long id) {
        Statement statement;
        try {
            statement = JDBC.getConnection().createStatement();
            statement.executeQuery("DELETE FROM skills WHERE id = "+id);

        } catch (SQLException e) {
            System.out.println("Failed to get statement in method delete.");

            return false;
        }
        JDBC.close();
        return true;
    }

    public Skills getById(Long id) {
        Statement statement;
        String name = "";
        try {
            statement = JDBC.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM skills WHERE id = "+ id);
            while(resultSet.next()){
                name = resultSet.getString("name");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.close();
        return new Skills(id,name);
    }

    public List<Skills> getAll() {
        List<Skills> skillsList = new ArrayList<Skills>();
        Statement statement;
        Long id;
        String name;
        try {
            statement = JDBC.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM skills");
            while(resultSet.next()){
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                skillsList.add(new Skills(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillsList;
    }
}
