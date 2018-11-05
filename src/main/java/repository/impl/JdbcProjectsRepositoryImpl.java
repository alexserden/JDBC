package repository.impl;

import model.Projects;
import repository.util.ConnectionUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectsRepositoryImpl {
    public void save(Projects projects) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("INSERT INTO projects (id,name)"+ " VALUES ("
                    + projects.getId()+"," + projects.getName()+")"
            );

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to save projects");
        }
        ConnectionUtil.close();


    }

    public void update(Projects projects) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("UPDATE  projects (id,name)"+ " SET ("
                    + projects.getId()+"," + projects.getName()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionUtil.close();
    }

    public boolean delete(Long id) {
        Statement statement;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            statement.executeQuery("DELETE FROM projects WHERE id = "+id);

        } catch (SQLException e) {
            System.out.println("IN save - error occurred trying to delete projects");

            return false;
        }
        ConnectionUtil.close();
        return true;
    }

    public Projects getById(Long id) {
        Statement statement;
        String name = "";
        try {
            statement = ConnectionUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects WHERE id = "+ id);
            while(resultSet.next()){
                name = resultSet.getString("name");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionUtil.close();
        return new Projects(id,name);
    }

    public List<Projects> getAll() {
        List<Projects> skillsList = new ArrayList<Projects>();
        Statement statement;
        Long id;
        String name;
        try {
            statement = ConnectionUtil.getConnection().createStatement();
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
