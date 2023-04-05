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
@Table(name="ChucVu")
public class ChucVu {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;

    @OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
    List<NhanVien> listNhanVien;

}
