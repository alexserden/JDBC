package repository.impl;

import model.Projects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectsRepositoryImpl {
    public void save(Projects skills) {
        Statement statement;
        try {
            statement = JDBC.getConnection().createStatement();
            statement.executeQuery("INSERT INTO projects (id,name)"+ " VALUES ("
                    + skills.getId()+"," + skills.getName()+")"
            );

        } catch (SQLException e) {
            System.out.println("Failed to get statement in method save.");
        }
        JDBC.close();


    }

    public void update(Projects projects) {
        Statement statement;
        try {
            statement = JDBC.getConnection().createStatement();
            statement.executeQuery("UPDATE  skills (id,name)"+ " SET ("
                    + projects.getId()+"," + projects.getName()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.close();
    }

    public boolean delete(Long id) {
        Statement statement;
        try {
            statement = JDBC.getConnection().createStatement();
            statement.executeQuery("DELETE FROM projects WHERE id = "+id);

        } catch (SQLException e) {
            System.out.println("Failed to get statement in method delete.");

            return false;
        }
        JDBC.close();
        return true;
    }

    public Projects getById(Long id) {
        Statement statement;
        String name = "";
        try {
            statement = JDBC.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects WHERE id = "+ id);
            while(resultSet.next()){
                name = resultSet.getString("name");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBC.close();
        return new Projects(id,name);
    }

    public List<Projects> getAll() {
        List<Projects> skillsList = new ArrayList<Projects>();
        Statement statement;
        Long id;
        String name;
        try {
            statement = JDBC.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
            while(resultSet.next()){
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                skillsList.add(new Projects(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillsList;
    }
}
