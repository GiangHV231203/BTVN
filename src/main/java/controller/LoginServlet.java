package controller;

import domain_model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.NhanVienRepository;

import java.io.IOException;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nvRP = new NhanVienRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/login.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NhanVien nv = this.nvRP.login(ma, matKhau);
        HttpSession session = request.getSession();
        if (nv == null) {
            session.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
            response.sendRedirect("/BTVN_war_exploded/login");
        } else {
            session.setAttribute("nv", nv);
            response.sendRedirect("/BTVN_war_exploded/khach-hang/index");
        }
    }
}
