package controller;

import domain_model.DongSP;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import repository.DongSPRepository;

import view_model.QLChucVu;
import view_model.QLDongSP;

import java.io.IOException;


@WebServlet(
        {
                "/dongSP/index",    // GET
                "/dongSP/create",   // GET
                "/dongSP/edit",     // GET
                "/dongSP/delete",   // GET
                "/dongSP/store",    // POST
                "/dongSP/update",   // POST
        }
)
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dspRepo;

    public DongSPServlet() {

        this.dspRepo = new DongSPRepository();
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
        DongSP dsp = this.dspRepo.findByMa(ma);
        request.setAttribute("dsp",dsp);
        request.getRequestDispatcher("/views/dongSP/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        DongSP dsp = this.dspRepo.findByMa(ma);
        this.dspRepo.delete(dsp);
        response.sendRedirect("/BTVN_war_exploded/dongSP/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachDongSP",this.dspRepo.findAll());
        request.setAttribute("view", "/views/dongSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/dongSP/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/daongSP/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DongSP dsp = new DongSP();
            BeanUtils.populate(dsp,request.getParameterMap());
            dspRepo.insert(dsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/dongSP/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            DongSP dsp = dspRepo.findByMa(ma);
            BeanUtils.populate(dsp,request.getParameterMap());
            dspRepo.update(dsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/dongSP/index");
    }
}
