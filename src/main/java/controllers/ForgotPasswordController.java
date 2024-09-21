package controllers;

import Constant.Path;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.IUserService;
import services.impl.UserServiceImpl;

import java.io.IOException;

import static Constant.Path.REGISTER;

@WebServlet(urlPatterns = "/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(Path.FORGOTPASSWORD);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String alertMsg = "";
        IUserService service = new UserServiceImpl();

        boolean isSuccess = service.checkUserByEmail(username, email);
        if (isSuccess) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + Path.RESETPASSWORD);
        } else {
            alertMsg = "Username hoặc email không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Path.FORGOTPASSWORD).forward(req, resp);
        }
    }
}
