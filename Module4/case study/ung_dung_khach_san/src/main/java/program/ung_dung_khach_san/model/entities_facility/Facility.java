package program.ung_dung_khach_san.model.entities_facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name="facility_type_id",nullable = false,referencedColumnName = "facility_type_id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name="rent_type_id",nullable = false,referencedColumnName = "rent_type_id")
    private RentType rentType;


    @OneToMany(mappedBy = "facility")
    @JsonIgnore
    private List<Contract> contracts;

}
