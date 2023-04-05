package controller;

import domain_model.ChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import view_model.QLChucVu;
import view_model.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/chuc-vu/index",    // GET
        "/chuc-vu/create",   // GET
        "/chuc-vu/edit",     // GET
        "/chuc-vu/delete",   // GET
        "/chuc-vu/store",    // POST
        "/chuc-vu/update",   // POST
}
)
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;

    public ChucVuServlet() {
        this.cvRepo = new ChucVuRepository();
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
        ChucVu cv = this.cvRepo.findByMa(ma);
        request.setAttribute("cv",cv);
        request.getRequestDispatcher("/views/chuc_vu/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(cv);
        response.sendRedirect("/BTVN_war_exploded/chuc-vu/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachCV",this.cvRepo.findAll());
        request.setAttribute("view", "/views/chuc_vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/chuc_vu/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/chuc-vu/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ChucVu cv = new ChucVu();
            BeanUtils.populate(cv,request.getParameterMap());
            cvRepo.insert(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/chuc-vu/index");

    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChucVu cv = cvRepo.findByMa(ma);
            BeanUtils.populate(cv,request.getParameterMap());
            cvRepo.update(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/chuc-vu/index");
    }
}
