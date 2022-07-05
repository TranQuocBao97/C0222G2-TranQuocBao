package program.ung_dung_khach_san.dto;

import lombok.Data;
import program.ung_dung_khach_san.model.entities_facility.Facility;
import program.ung_dung_khach_san.model.entities_facility.RentType;

import java.util.List;

@Data
public class FacilityDTO {
    private Facility facility;
    private List<RentType> rentTypeList;
}
