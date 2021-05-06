package com.example.MVCLab3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/list")
public class ListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OldUserDAO oldUserDAO = OldUserDAO.GetInstance();

        String DataToSend = oldUserDAO.GetJsonString();

        resp.getWriter().print(DataToSend);

        resp.flushBuffer();
    }
}
