package controller;

import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.NsxRepository;
import repository.SanPhamRepository;
import view_model.QLNsx;
import view_model.QLSanPham;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/san-pham/index",    // GET
        "/san-pham/create",   // GET
        "/san-pham/edit",     // GET
        "/san-pham/delete",   // GET
        "/san-pham/store",    // POST
        "/san-pham/update",   // POST
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;

    public SanPhamServlet() {
        this.spRepo = new SanPhamRepository();
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
        }else{
            this.index(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham domainsp = this.spRepo.findByMa(ma);
        request.setAttribute("sp",domainsp);
        request.getRequestDispatcher("/views/san_pham/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        SanPham domainsp = this.spRepo.findByMa(ma);
        this.spRepo.delete(domainsp);
        response.sendRedirect("/BTVN_war_exploded/san-pham/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachSP",this.spRepo.findAll());
        request.setAttribute("view", "/views/san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/san_pham/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/san-pham/index");
        }
    }
    protected void store(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            SanPham domainsp = new SanPham();
            BeanUtils.populate(domainsp,request.getParameterMap());
            spRepo.insert(domainsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/san-pham/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            SanPham domainsp = spRepo.findByMa(ma);
            BeanUtils.populate(domainsp,request.getParameterMap());
            spRepo.update(domainsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/san-pham/index");
    }
}
