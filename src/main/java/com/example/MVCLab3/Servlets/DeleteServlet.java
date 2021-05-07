package com.example.MVCLab3.Servlets;

import com.example.MVCLab3.DBPackage.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO userDAO = UserDAO.GetInstance();
        int id = new BufferedReader(new InputStreamReader(req.getInputStream())).read();

        try {
            userDAO.DeleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}