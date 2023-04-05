package controller;

import domain_model.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import repository.MauSacRepository;

import view_model.QLDongSP;
import view_model.QLMauSac;

import java.io.IOException;


@WebServlet({"/mau-sac/index",    // GET
        "/mau-sac/create",   // GET
        "/mau-sac/edit",     // GET
        "/mau-sac/delete",   // GET
        "/mau-sac/store",    // POST
        "/mau-sac/update",   // POST
        })
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;

    public MauSacServlet() {
        this.msRepo = new MauSacRepository();
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
        MauSac domainMs = this.msRepo.findByMa(ma);
        request.setAttribute("ms",domainMs);
        request.getRequestDispatcher("/views/mau_sac/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        MauSac domainMs = this.msRepo.findByMa(ma);
        this.msRepo.delete(domainMs);
        response.sendRedirect("/BTVN_war_exploded/mau-sac/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachMS",this.msRepo.findAll());
        request.setAttribute("view", "/views/mau_sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mau_sac/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/mau-sac/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            MauSac domainModelMs = new MauSac();
            BeanUtils.populate(domainModelMs, request.getParameterMap());
            this.msRepo.insert(domainModelMs);
        }catch (Exception e){
            e.printStackTrace();

        }
        response.sendRedirect("/BTVN_war_exploded/mau-sac/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            MauSac domainModelMs = this.msRepo.findByMa(ma);
            BeanUtils.populate(domainModelMs,request.getParameterMap());
            msRepo.update(domainModelMs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/mau-sac/index");
    }
}
