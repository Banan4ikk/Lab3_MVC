package com.example.MVCLab3.Servlets;

import com.example.MVCLab3.DBPackage.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO userDAO = UserDAO.GetInstance();

        String name = req.getParameter("UserName");
        String surname = req.getParameter("UserSurname");

        try {
            userDAO.DeleteUser(name,surname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
