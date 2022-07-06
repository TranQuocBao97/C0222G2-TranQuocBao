package program.ung_dung_khach_san.model.entities_facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="facility_type_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "facilityType")
    @JsonBackReference
    private List<Facility> facilities;

}
