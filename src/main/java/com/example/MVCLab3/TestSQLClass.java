package com.example.MVCLab3;

import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQLClass {

    static Gson gson = new Gson();
    static DBWorker dbWorker = new DBWorker();

    private static User ReadUser(int id) throws SQLException {
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

    private static void UpdateUser(int id,String data) throws SQLException {
        String query = "update users set name=?,surname=?,date=?,socials=?,email=? where id=?";
        PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);

        statement.setInt(6,id);

        User userToUpdate = ReadUser(id);
        User updatedUser = gson.fromJson(data,User.class);


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

    public static void main(String[] args) throws SQLException {
        String json = "{\"Name\":\"Ivan\",\"Surname\":\"Minaleev\",\"Date\":\"12.12.2021\",\"Socials\":\"vk.com/exmaple\",\"Email\":\"mail@mail.ru\"}";

        UpdateUser(3,json);

    }
}
