package program.ung_dung_khach_san.model.entities_facility;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="facility_type_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "facilityType")
    private List<Facility> facilities;

}
