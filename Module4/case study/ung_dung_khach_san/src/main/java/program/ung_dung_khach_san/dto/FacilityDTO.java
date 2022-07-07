package program.ung_dung_khach_san.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.entities_facility.Facility;
import program.ung_dung_khach_san.model.entities_facility.RentType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDTO {
    private Facility facility;
    private List<RentType> rentTypeList;
}
