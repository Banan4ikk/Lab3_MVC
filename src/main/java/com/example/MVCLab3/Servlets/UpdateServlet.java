package com.example.MVCLab3.Servlets;

import com.example.MVCLab3.DBPackage.UserDAO;
import com.example.MVCLab3.Model.User;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.stream.Collectors;

@WebServlet( value = "/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        UserDAO userDAO = UserDAO.GetInstance();

        String UserData = new BufferedReader(new InputStreamReader(req.getInputStream())).lines().collect(Collectors.joining());

        User newUser = gson.fromJson(UserData,User.class);
        String name = (String) req.getAttribute("Name");
        String surname = (String) req.getAttribute("Surname");

        try {
            userDAO.UpdateUser(newUser,name,surname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
