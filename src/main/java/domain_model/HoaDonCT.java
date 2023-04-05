package domain_model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HoaDonCT")
public class HoaDonCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name="IdHoaDon" ,nullable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name="IdChiTietSP",nullable = false)
    private ChiTietSP chiTietSP;

    @Column(name="SoLuong")
    private int SoLuong;

    @Column(name="DonGia")
    private BigDecimal DonGia;


}
