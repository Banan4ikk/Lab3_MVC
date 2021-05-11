package com.example.MVCLab3.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/Name")
public class GetNameAndSurnameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("UserName");
        String surname = req.getParameter("UserSurname");

        req.setAttribute("Name",name);
        req.setAttribute("Surname",surname);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/update");

        if(dispatcher!= null)
            dispatcher.forward(req,resp);
        else
            System.err.println("Dispatcher is null");
    }
}
