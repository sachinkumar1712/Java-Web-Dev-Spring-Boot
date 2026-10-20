
package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Config.ThymeleafConfig;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        List<Employee> employees = employeeDao.findAll();

        Map<String, Object> data = new HashMap<>();
        data.put("employees", employees);

        ThymeleafConfig.render(
                req,
                res,
                data,
                "employee"
        );
    }
}
