package repository.impl;

import model.Companies;
import model.Developers;
import model.Projects;
import model.Skills;
import repository.DevelopersRepository;
import repository.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDevelopersRepositoryImpl implements DevelopersRepository {


    public void save(Developers developers) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("INSERT INTO developers (id,name,skills,projects,companies)"+ " VALUES ("
                    + developers.getId()+"," + developers.getName()+","+developers.getSkill()+","
                    + developers.getProject()+"," + developers.getProject()+")"
            );

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to save developer");
        }


    }

    public void update(Developers developers) {
          Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("UPDATE  developers (id,name,skills,projects,companies)"+ " SET ("
                    + developers.getId()+"," + developers.getName()+","+developers.getSkill()+","
                    + developers.getProject()+"," + developers.getProject()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean delete(Long id) {
        Statement statement;
        try {
             statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("DELETE FROM developers WHERE id = "+id);

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to delete developer");

            return false;
            }
        ConnectionUtil.close();
        return true;
        }

    public Developers getById(Long id) {
        Statement statement;
        String name = "";
        Skills skill = null;
        Projects project= null;
        Companies companies= null;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developers WHERE id = "+ id);
            while(resultSet.next()){
                name = resultSet.getString("name");
                skill = new Skills(id,resultSet.getString("skills"));
                project = new Projects(id,resultSet.getString("projects"));
                companies = new Companies(id,resultSet.getString("companies"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Developers(id,name,skill,project,companies);
    }

    public List<Developers> getAll() {
        List<Developers> developersList = new ArrayList<Developers>();
        Statement statement;
        Long id;
        String name;
        Skills skill;
        Projects project;
        Companies companies;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");
            while(resultSet.next()){
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                skill = new Skills(id,resultSet.getString("skills"));
                project = new Projects(id,resultSet.getString("projects"));
                companies = new Companies(id,resultSet.getString("companies"));
                developersList.add(new Developers(id,name,skill,project,companies));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developersList;
    }
}
