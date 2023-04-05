package domain_model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HoaDon")
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "IdKH",nullable = false)
    private KhachHang kh;

    @ManyToOne
    @JoinColumn(name = "IdNV",nullable = false)
    private NhanVien nv;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgayThanhToan")
    private Date NgayThanhToan;

    @Column(name = "NgayShip")
    private Date NgayShip;

    @Column(name = "NgayNhan")
    private Date NgayNhan;

    @Column(name = "TinhTrang")
    private int TinhTrang;

    @Column(name = "TenNguoiNhan")
    private String TenNguoiNhan;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "Sdt")
    private String Sdt;

    @OneToMany(mappedBy = "hoaDon",fetch = FetchType.LAZY)
    List<HoaDonCT> listHDCT;


}
