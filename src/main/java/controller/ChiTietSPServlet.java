package controller;

import domain_model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.*;
import view_model.QLChiTietSP;
import view_model.QLChucVu;
import view_model.QLCuaHang;
import view_model.QLNhanVien;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@WebServlet({
        "/chitietSP/index",    // GET
        "/chitietSP/create",   // GET
        "/chitietSP/edit",     // GET
        "/chitietSP/delete",   // GET
        "/chitietSP/store",    // POST
        "/chitietSP/update",   // POST
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository ctspRepo;
    private SanPhamRepository spRepo;
    private MauSacRepository msRepo;
    private DongSPRepository dspRepo;
    private NsxRepository nsxRepo;

    public ChiTietSPServlet() {
        this.ctspRepo = new ChiTietSPRepository();
        this.spRepo = new SanPhamRepository();
        this.msRepo = new MauSacRepository();
        this.dspRepo = new DongSPRepository();
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
        }else {
            this.index(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
//        UUID id = UUID.fromString(idStr);
        ChiTietSP DomainModelctsp = this.ctspRepo.findById(idStr);
        request.setAttribute("listSanPham", spRepo.findAll());
        request.setAttribute("listNsx",nsxRepo.findAll());
        request.setAttribute("listMauSac",msRepo.findAll());
        request.setAttribute("listDongSanPham",dspRepo.findAll());
        request.setAttribute("ctsp",DomainModelctsp);
        request.getRequestDispatcher("/views/chitiet_SP/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
//        UUID id = UUID.fromString(idStr);
        ChiTietSP DomainModelctsp = this.ctspRepo.findById(idStr);
        this.ctspRepo.delete(DomainModelctsp);
        response.sendRedirect("/BTVN_war_exploded/chitietSP/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachCTSP",this.ctspRepo.findAll());
        request.setAttribute("view", "/views/chitiet_SP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSanPham",spRepo.findAll());
        request.setAttribute("listNsx",nsxRepo.findAll());
        request.setAttribute("listMauSac",msRepo.findAll());
        request.setAttribute("listDongSanPham",dspRepo.findAll());
        request.getRequestDispatcher("/views/chitiet_SP/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/chitietSP/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        QLChiTietSP ctsp = new QLChiTietSP();
        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChiTietSP DomainModelctsp = new ChiTietSP();

        String maSp = request.getParameter("sanPham");
        String maDongSp = request.getParameter("dongSP");
        String maNsx = request.getParameter("nsx");
        String maMs = request.getParameter("mauSac");

        NSX nsx = this.nsxRepo.findById(maNsx);
        MauSac mauSac = this.msRepo.findById(maMs);
        DongSP dongSanPham = this.dspRepo.findById(maDongSp);
        SanPham sanPham = this.spRepo.findById(maSp);

        DomainModelctsp.setSanPham(sanPham);
        DomainModelctsp.setNsx(nsx);
        DomainModelctsp.setMauSac(mauSac);
        DomainModelctsp.setDongSP(dongSanPham);
        DomainModelctsp.setNamBH(Integer.valueOf(ctsp.getNamBH()));
//        DomainModelctsp.setNamBH(1111);
        DomainModelctsp.setMoTa(ctsp.getMoTa());
        DomainModelctsp.setSoLuongTon(Integer.valueOf(ctsp.getSoLuongTon()));
//        DomainModelctsp.setSoLuongTon(1111);
        DomainModelctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(ctsp.getGianhap())));
//        DomainModelctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(ctsp.getGiaNhap())));
        DomainModelctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(ctsp.getGiaban())));
        try {
            this.ctspRepo.insert(DomainModelctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/chitietSP/index");

    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLChiTietSP ctsp = new QLChiTietSP();
        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idStr = request.getParameter("id");
//        UUID id = UUID.fromString(idStr);
        ChiTietSP DomainModelctsp = this.ctspRepo.findById(idStr);

        String maSp = request.getParameter("sanPham");
        String maDongSp = request.getParameter("dongSP");
        String maNsx = request.getParameter("nsx");
        String maMs = request.getParameter("mauSac");

        NSX nsx = this.nsxRepo.findById(maNsx);
        MauSac mauSac = this.msRepo.findById(maMs);
        DongSP dongSanPham = this.dspRepo.findById(maDongSp);
        SanPham sanPham = this.spRepo.findById(maSp);

        DomainModelctsp.setSanPham(sanPham);
        DomainModelctsp.setNsx(nsx);
        DomainModelctsp.setMauSac(mauSac);
        DomainModelctsp.setDongSP(dongSanPham);
        DomainModelctsp.setNamBH(Integer.valueOf(ctsp.getNamBH()));
        DomainModelctsp.setMoTa(ctsp.getMoTa());
        DomainModelctsp.setSoLuongTon(Integer.valueOf(ctsp.getSoLuongTon()));
        DomainModelctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(ctsp.getGianhap())));
        DomainModelctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(ctsp.getGiaban())));
        try {
            this.ctspRepo.update(DomainModelctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/chitietSP/index");
    }
}
