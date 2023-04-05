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
@Table(name="KhachHang")
public class KhachHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    @Column(name="TenDem")
    private String TenDem;

    @Column(name="Ho")
    private String Ho;

    @Column(name="NgaySinh")
    private Date NgaySinh;

    @Column(name="Sdt")
    private String Sdt;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="ThanhPho")
    private String ThanhPho;

    @Column(name="QuocGia")
    private String QuocGia;

    @Column(name="MatKhau")
    private String MatKhau;

    @OneToMany(mappedBy = "kh",fetch = FetchType.LAZY)
    List<HoaDon> listHd;

    @OneToMany(mappedBy = "khachHang",fetch = FetchType.LAZY)
    List<GioHang> listGH;

}
