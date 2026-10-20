package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Config.ThymeleafConfig;
import org.example.model.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/employee/add")
public class EmployeeFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", new Employee());
        ThymeleafConfig.render(
                req,
                resp,
                variables,
                "AddNewEmployeeForm");
    }
}
