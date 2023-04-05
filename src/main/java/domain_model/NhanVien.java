package domain_model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="NhanVien")
public class NhanVien {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    @Column(name="TenDem")
    private String TenDem;

    @Column(name="Ho")
    private String Ho;

    @Column(name="GioiTinh")
    private String GioiTinh;

    @Column(name="NgaySinh")
    private Date NgaySinh;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="Sdt")
    private String Sdt;

    @Column(name="MatKhau")
    private String MatKhau;

    @ManyToOne
    @JoinColumn(name = "IdCH", nullable = false)
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "IdCV", nullable = false)
    private ChucVu chucVu;

    @Column(name="IdGuiBC")
    private String IdGuiBC;

    @Column(name="TrangThai")
    private int TrangThai;

    @OneToMany(mappedBy = "nv",fetch = FetchType.LAZY)
    List<HoaDon> listHd;

    @OneToMany(mappedBy = "nhanVien",fetch = FetchType.LAZY)
    List<GioHang> listGH;


}
