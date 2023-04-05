package controller;

import domain_model.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.CuaHangRepository;
import view_model.QLChucVu;
import view_model.QLCuaHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/cua-hang/index",    // GET
        "/cua-hang/create",   // GET
        "/cua-hang/edit",     // GET
        "/cua-hang/delete",   // GET
        "/cua-hang/store",    // POST
        "/cua-hang/update",   // POST
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else {
            this.index(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.chRepo.findByMa(ma);
        request.setAttribute("ch",ch);
        request.getRequestDispatcher("/views/cua_hang/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.chRepo.findByMa(ma);
        this.chRepo.delete(ch);
        response.sendRedirect("/BTVN_war_exploded/cua-hang/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachCH",this.chRepo.findAll());
        request.setAttribute("view", "/views/cua_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/cua_hang/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/cua-hang/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            CuaHang ch = new CuaHang();
            BeanUtils.populate(ch,request.getParameterMap());
            chRepo.insert(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/cua-hang/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            CuaHang ch = chRepo.findByMa(ma);
            BeanUtils.populate(ch,request.getParameterMap());
            chRepo.update(ch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/cua-hang/index");
    }
}
