package controllers;

import Constant.Path;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.IUserService;
import services.impl.UserServiceImpl;

import java.io.IOException;

import static Constant.Path.REGISTER;
import static Constant.Path.RESETPASSWORD;

@WebServlet(urlPatterns = "/reset-password")
public class ResetPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Path.RESETPASSWORD);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String username = req.getParameter("username");
        String alertMsg = "";
        IUserService service = new UserServiceImpl();

        if(!password.equals(confirmPassword)) {
            alertMsg = "Mật khẩu không khớp!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(RESETPASSWORD).forward(req, resp);
            return;
        }
        boolean isSuccess = service.updatePassword(username, password);
        if (isSuccess) {
            alertMsg = "Cập nhật mật khẩu thành công";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(RESETPASSWORD).forward(req, resp);
            HttpSession session = req.getSession();
            session.removeAttribute("username");
            return;
        } else {
            alertMsg = "Cập nhật mật khẩu thất bại";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(RESETPASSWORD).forward(req, resp);
        }
    }
}
