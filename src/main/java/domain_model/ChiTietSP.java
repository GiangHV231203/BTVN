package domain_model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="ChiTietSP")
public class ChiTietSP {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String Id;

    @ManyToOne
    @JoinColumn(name = "IdSP",nullable = false)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx",nullable = false)
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac",nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP",nullable = false)
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int NamBH;

    @Column(name = "MoTa")
    private String MoTa;

    @Column(name = "SoLuongTon")
    private int SoLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal GiaNhap;

    @Column(name = "GiaBan")
    private BigDecimal GiaBan;

    @OneToMany(mappedBy = "chiTietSP" ,fetch = FetchType.LAZY)
    List<HoaDonCT> listHDCT;

    @OneToMany(mappedBy = "chiTietSP",fetch = FetchType.LAZY)
    List<GioHangCT> listGHCT;


}
