package view_model;

import domain_model.ChucVu;
import domain_model.CuaHang;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLNhanVien {
    private String Ma;
    private String Ten;
    private String TenDem;
    private String Ho;
    private String GioiTinh;
    private String NgaySinh;
    private String DiaChi;
    private String Sdt;
    private String MatKhau;
    private String cuaHang;
    private String chucVu;
    private String IdGuiBC;
    private String TrangThai;
}
