package program.ung_dung_khach_san.model.entities_facility;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rent_type_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    private List<Facility> facilities;
}
