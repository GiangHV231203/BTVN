package domain_model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="GioHangCT")
public class GioHangCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int SoLuong;

    @Column(name = "DonGia")
    private BigDecimal DonGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal DonGiaKhiGiam;


}
