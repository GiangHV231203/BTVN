package domain_model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
@Table(name="CuaHang")
public class CuaHang {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="ThanhPho")
    private String ThanhPho;
    @Column(name="QuocGia")
    private String QuocGia;
    @OneToMany(mappedBy = "cuaHang", fetch = FetchType.LAZY)
    List<NhanVien> listNhanVien;


}
