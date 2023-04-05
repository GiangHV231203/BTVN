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
@Table(name="SanPham")
public class SanPham {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;

    @OneToMany(mappedBy = "sanPham",fetch = FetchType.LAZY)
    List<ChiTietSP> listCTSP;
}
