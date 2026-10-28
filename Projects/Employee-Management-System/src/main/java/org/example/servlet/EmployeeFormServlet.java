
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
import java.util.Map;

@WebServlet(urlPatterns = {"/employee/add", "/employee/update"})
public class EmployeeFormServlet extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, Object> variables = new HashMap<>();

        // Open Add Employee form
        if (req.getServletPath().equals("/employee/add")) {
            variables.put("employee", new Employee());

            ThymeleafConfig.render(
                    req,
                    resp,
                    variables,
                    "AddNewEmployeeForm"
            );
            return;
        }

        // Get employee ID from URL
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            resp.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Employee ID is required!"
            );
            return;
        }

        Long id;

        try {
            id = Long.parseLong(idParam);
        } catch (NumberFormatException e) {
            resp.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid Employee ID!"
            );
            return;
        }

        // Fetch existing employee
        Employee employee = employeeDao.findById(id);

        if (employee == null) {
            resp.sendError(
                    HttpServletResponse.SC_NOT_FOUND,
                    "Employee Not Found!"
            );
            return;
        }

        // IMPORTANT: Pass the fetched employee to Thymeleaf
        variables.put("employee", employee);

        ThymeleafConfig.render(
                req,
                resp,
                variables,
                "updateEmployee"
        );
    }
}
