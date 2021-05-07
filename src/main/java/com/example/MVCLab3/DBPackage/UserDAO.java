package com.example.MVCLab3.DBPackage;

import com.example.MVCLab3.Model.User;
import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    Gson gson = new Gson();

    DBWorker dbWorker = new DBWorker();

    public static UserDAO GetInstance(){
        return new UserDAO();
    }

    public void CreateUser(String jsonString) throws SQLException {
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


    public String ReadAllUsers() throws SQLException {
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

    private User ReadUser(String name, String surname) throws SQLException {
        String query = "select * from users where name =? and surname = ?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
        statement.setString(1,name);
        statement.setString(2,surname);

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

    private void UpdateUser(String name,String surname,String JsonData) throws SQLException {
        String query = "update users set name=?,surname=?,date=?,socials=?,email=? where name =? and surname = ?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);

        statement.setString(6,name);
        statement.setString(7,surname);

        User userToUpdate = ReadUser(name, surname);
        User updatedUser = gson.fromJson(JsonData,User.class);


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
    private void DeleteUser(String name,String surname) throws SQLException {
        String query = "delete from users where name =? and surname =?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
        statement.setString(1,name);
        statement.setString(2,surname);

        statement.executeUpdate();
    }

}