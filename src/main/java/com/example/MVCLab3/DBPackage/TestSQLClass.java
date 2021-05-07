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

    private static void UpdateUser(String name,String surname,String JsonData) throws SQLException {
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
    private static void DeleteUser(String name,String surname) throws SQLException {
        String query = "delete from users where name =? and surname =?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
        statement.setString(1,name);
        statement.setString(2,surname);

        statement.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        String json = "{\"Name\":\"Ivan\",\"Surname\":\"Minaleev\",\"Date\":\"12.12.2021\",\"Socials\":\"vk.com/exmaple\",\"Email\":\"mail@mail.ru\"}";

        DeleteUser("Ivan","Minaleev");

        //System.out.println(user.toString());

    }
}
