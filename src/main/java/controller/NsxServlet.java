package controller;

import domain_model.NSX;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.MauSacRepository;
import repository.NsxRepository;
import view_model.QLMauSac;
import view_model.QLNsx;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/nsx/index",    // GET
        "/nsx/create",   // GET
        "/nsx/edit",     // GET
        "/nsx/delete",   // GET
        "/nsx/store",    // POST
        "/nsx/update",   // POST
})
public class NsxServlet extends HttpServlet {
    private NsxRepository nsxRepo;

    public NsxServlet() {
        this.nsxRepo = new NsxRepository();
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
        NSX domainsx = this.nsxRepo.findByMa(ma);
        request.setAttribute("nsx",domainsx);
        request.getRequestDispatcher("/views/nsx/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        NSX domainsx = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(domainsx);
        response.sendRedirect("/BTVN_war_exploded/nsx/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachNSX",this.nsxRepo.findAll());
        request.setAttribute("view", "/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nsx/create.jsp").forward(request,respons);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/nsx/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse respons) throws IOException {
        try {
            NSX domainnsx = new NSX();
            BeanUtils.populate(domainnsx,request.getParameterMap());
            nsxRepo.insert(domainnsx);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        respons.sendRedirect("/BTVN_war_exploded/nsx/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            NSX domainnsx = nsxRepo.findByMa(ma);
            BeanUtils.populate(domainnsx,request.getParameterMap());
            nsxRepo.update(domainnsx);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/nsx/index");
    }
}
