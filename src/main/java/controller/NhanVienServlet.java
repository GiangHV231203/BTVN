package controller;

import domain_model.ChucVu;
import domain_model.CuaHang;
import domain_model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import repository.CuaHangRepository;
import repository.NhanVienRepository;
import view_model.QLChucVu;
import view_model.QLNhanVien;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@WebServlet({"/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/edit",     // GET
        "/nhan-vien/delete",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/update",   // POST
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;
    private ChucVuRepository cvRepo ;
    private CuaHangRepository chRepo ;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
        this.cvRepo = new ChucVuRepository();
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
        request.setAttribute("listCuaHang",chRepo.findAll());
        request.setAttribute("listChucVu",cvRepo.findAll());
        String id = request.getParameter("id");
        NhanVien nv = this.nvRepo.findById(id);
        request.setAttribute("nv",nv);
        request.getRequestDispatcher("/views/nhan_vien/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhanVien DomainModelNv = this.nvRepo.findById(id);
        this.nvRepo.delete(DomainModelNv);
        response.sendRedirect("/BTVN_war_exploded/nhan-vien/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachNV",this.nvRepo.findAll());
        request.setAttribute("view", "/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachCV",this.cvRepo.findAll());
        request.setAttribute("danhsachCH",this.chRepo.findAll());
        request.getRequestDispatcher("/views/nhan_vien/create.jsp").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/nhan-vien/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVien DomainModelNv = new NhanVien();
        String idCv = request.getParameter("chucVu");
        String idCh = request.getParameter("cuaHang");
        ChucVu DomainModelCv = this.cvRepo.findById(idCv);
        CuaHang DomainModelCh = this.chRepo.findById(idCh);
        DomainModelNv.setMa(nv.getMa());
        DomainModelNv.setTen(nv.getTen());
        DomainModelNv.setTenDem(nv.getTenDem());
        DomainModelNv.setHo(nv.getHo());
        DomainModelNv.setGioiTinh(nv.getGioiTinh());
        DomainModelNv.setNgaySinh(Date.valueOf(nv.getNgaySinh()));
        DomainModelNv.setDiaChi(nv.getDiaChi());
        DomainModelNv.setSdt(nv.getSdt());
        DomainModelNv.setMatKhau(nv.getMatKhau());
        DomainModelNv.setCuaHang(DomainModelCh);
        DomainModelNv.setChucVu(DomainModelCv);
//        DomainModelNv.setIdGuiBaoCao(nv.getGuiBaoCao());
        DomainModelNv.setTrangThai(Integer.valueOf(nv.getTrangThai()));
        try {
            this.nvRepo.insert(DomainModelNv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/nhan-vien/index");

    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id = request.getParameter("id");
        NhanVien nv12 = this.nvRepo.findById(id);
        String idCv = request.getParameter("chucVu");
        String idCh = request.getParameter("cuaHang");
        ChucVu DomainModelCv = this.cvRepo.findById(idCv);
        CuaHang DomainModelCh = this.chRepo.findById(idCh);
//        nv12.setMa(nv.getMa());
        nv12.setTen(nv.getTen());
        nv12.setTenDem(nv.getTenDem());
        nv12.setHo(nv.getHo());
        nv12.setGioiTinh(nv.getGioiTinh());
        nv12.setNgaySinh(Date.valueOf(nv.getNgaySinh()));
        nv12.setDiaChi(nv.getDiaChi());
        nv12.setSdt(nv.getSdt());
        nv12.setMatKhau(nv.getMatKhau());
        nv12.setCuaHang(DomainModelCh);
        nv12.setChucVu(DomainModelCv);
//        DomainModelNv.setIdGuiBaoCao(nv.getGuiBaoCao());
        nv12.setTrangThai(Integer.valueOf(nv.getTrangThai()));
        try {

            BeanUtils.populate(nv,request.getParameterMap());
            nvRepo.update(nv12);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/BTVN_war_exploded/nhan-vien/index");
    }
}
