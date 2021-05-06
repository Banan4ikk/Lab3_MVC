package com.example.MVCLab3;

import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOwSQL {

    Gson gson = new Gson();

    DBWorker dbWorker = new DBWorker();

    private void CreateUser(String jsonString) throws SQLException {
        String query = "insert into users values(?,?,?,?,?,?)";

        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);

        User newUser = gson.fromJson(jsonString,User.class);

        statement.setString(1, null);
        statement.setString(2, newUser.getName());
        statement.setString(3, newUser.getSurname());
        statement.setString(4, newUser.getDate());
        statement.setString(5, newUser.getEmail());
        statement.setString(6, newUser.getSocials());
        statement.execute();
    }

    private User ReadUser(int id) throws SQLException {
        String query = "select * from users where id=?";

        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();

        User newUser = new User();
        while (resultSet.next()){
            newUser.setId(resultSet.getInt("id"));
            newUser.setName(resultSet.getString("name"));
            newUser.setSurname(resultSet.getString("surname"));
            newUser.setDate(resultSet.getString("date"));
            newUser.setEmail(resultSet.getString("email"));
            newUser.setSocials(resultSet.getString("socials"));
        }
        return newUser;
    }

    private String ReadAllUsers() throws SQLException {
        List<User> AllUsersList = new ArrayList<>();

        String query = "select * from users";
        Statement statement = dbWorker.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            User newUser = new User();
            newUser.setId(resultSet.getInt("id"));
            newUser.setName(resultSet.getString("name"));
            newUser.setSurname(resultSet.getString("surname"));
            newUser.setDate(resultSet.getString("date"));
            newUser.setEmail(resultSet.getString("email"));
            newUser.setSocials(resultSet.getString("socials"));
            AllUsersList.add(newUser);
        }
        return gson.toJson(AllUsersList);
    }

    private void UpdateUser(int id,String NewUserData) throws SQLException {
        String query = "update users set name=?,surname=?,date=?,socials=?,email=? where id=?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);

        statement.setInt(6,id);

        User userToUpdate = ReadUser(id);
        User updatedUser = gson.fromJson(NewUserData,User.class);

        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setSurname(updatedUser.getSurname());
        userToUpdate.setDate(updatedUser.getDate());
        userToUpdate.setSocials(updatedUser.getSocials());
        userToUpdate.setEmail(updatedUser.getEmail());

        statement.setString(1,updatedUser.getName());
        statement.setString(2,updatedUser.getSurname());
        statement.setString(3,updatedUser.getDate());
        statement.setString(4,updatedUser.getSocials());
        statement.setString(5,updatedUser.getEmail());

        statement.executeUpdate();
    }

}
