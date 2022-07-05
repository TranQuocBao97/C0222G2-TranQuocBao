package program.ung_dung_khach_san.model.entities_facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import program.ung_dung_khach_san.model.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="facility_id")
    private Integer id;
    private String name;
    private Double area;
    private Double cost;
    private String standardRoom;
    private String convenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name="facility_type_id",nullable = false,referencedColumnName = "facility_type_id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name="rent_type_id",nullable = false,referencedColumnName = "rent_type_id")
    private RentType rentType;


    @OneToMany(mappedBy = "facility")
    @JsonBackReference
    private List<Contract> contracts;

}
