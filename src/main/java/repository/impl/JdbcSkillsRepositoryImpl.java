package repository.impl;

import model.Skills;
import repository.SkillsRepository;
import repository.util.ConnectionUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JdbcSkillsRepositoryImpl implements SkillsRepository {

    public void save(Skills skills) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("INSERT INTO skills (id,name)"+ " VALUES ("
                    + skills.getId()+"," + skills.getName()+")"
            );

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to save skills");
        }
        ConnectionUtil.close();


    }

    public void update(Skills skills) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("UPDATE  skills (id,name)"+ " SET ("
                    + skills.getId()+"," + skills.getName()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionUtil.close();
    }

    public boolean delete(Long id) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("DELETE FROM skills WHERE id = "+id);

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to delete skills");

            return false;
        }
        ConnectionUtil.close();
        return true;
    }

    public Skills getById(Long id) {
        Statement statement;
        String name = "";
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM skills WHERE id = "+ id);
            while(resultSet.next()){
                name = resultSet.getString("name");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionUtil.close();
        return new Skills(id,name);
    }

    public List<Skills> getAll() {
        List<Skills> skillsList = new ArrayList<Skills>();
        Statement statement;
        Long id;
        String name;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
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
