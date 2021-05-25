package com.example.MVCLab3.Servlets;

import com.example.MVCLab3.DBPackage.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.stream.Collectors;

//create user
@WebServlet( value = "/create")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String UserData = new BufferedReader(new InputStreamReader(req.getInputStream())).lines().collect(Collectors.joining());

        UserDAO userDAO = UserDAO.GetInstance();

        try {
            userDAO.CreateUser(UserData);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}