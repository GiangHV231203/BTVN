package domain_model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="GioHang")
public class GioHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "IdKH",nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV",nullable = false)
    private NhanVien nhanVien;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgayThanhToan")
    private Date NgayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String TenNguoiNhan;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "Sdt")
    private String Sdt;

    @Column(name = "TinhTrang")
    private int TinhTrang;

    @OneToMany(mappedBy = "gioHang",fetch = FetchType.LAZY)
    List<GioHangCT> listGHCT;
}
