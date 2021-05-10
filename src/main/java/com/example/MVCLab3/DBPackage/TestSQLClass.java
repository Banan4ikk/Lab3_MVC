package com.example.MVCLab3.DBPackage;

import com.example.MVCLab3.Model.User;
import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQLClass {

    static Gson gson = new Gson();
    static DBWorker dbWorker = new DBWorker();

    private static User ReadUser(String name, String surname) throws SQLException {
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

    private static void UpdateUser(User updatedUser,String name,String surname) throws SQLException {
        String query = "update users set name=?,surname=?,date=?,socials=?,email=? where name =? and surname = ?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);

        statement.setString(6,name);
        statement.setString(7,surname);

        User userToUpdate = ReadUser(name, surname);

        if(!updatedUser.getName().equals(""))
        userToUpdate.setName(updatedUser.getName());

        if(!updatedUser.getSurname().equals(""))
        userToUpdate.setSurname(updatedUser.getSurname());

        if(!updatedUser.getDate().equals(""))
        userToUpdate.setDate(updatedUser.getDate());

        if(!updatedUser.getSocials().equals(""))
        userToUpdate.setSocials(updatedUser.getSocials());

        if(!updatedUser.getEmail().equals(""))
        userToUpdate.setEmail(updatedUser.getEmail());

        statement.setString(1,userToUpdate.getName());
        statement.setString(2,userToUpdate.getSurname());
        statement.setString(3,userToUpdate.getDate());
        statement.setString(4,userToUpdate.getSocials());
        statement.setString(5,userToUpdate.getEmail());

        statement.executeUpdate();
    }
    private  void DeleteUser(String name,String surname) throws SQLException {
        String query = "delete from users where name =? and surname =?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
        statement.setString(1,name);
        statement.setString(2,surname);

        statement.executeUpdate();
    }

    public  void CreateUser(String jsonString) throws SQLException {
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
    public static void main(String[] args) throws SQLException {
        String json = "{\"Name\":\"Ivan\",\"Surname\":\"\",\"Date\":\"12.12.2021\",\"Socials\":\"vk.com/exmaple\",\"Email\":\"mail@mail.ru\"}";

        Gson gson = new Gson();
        User newuser = gson.fromJson(json,User.class);
        UpdateUser(newuser,"Ivana","Minaleeva");
    }
}
