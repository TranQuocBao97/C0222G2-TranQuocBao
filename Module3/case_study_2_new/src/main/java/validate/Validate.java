package validate;

import model.Division;
import model.EducationDegree;
import model.Employee;
import model.EmployeePosition;
import modelDTO.EmployeeDTO;
import repository.DivisionRepository;
import repository.EducationDegreeRepository;
import repository.EmployeePositionRepository;
import repository.EmployeeRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Validate {
    private static final List<EmployeeDTO> employeeDTOList = new EmployeeRepository().getAllEmployeeDTO();

    private static final String NAME = "^((?![0-9\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\=\\-\\[\\]\\{\\}\\;\\:\\\"\\\\\\/\\<\\>\\?\\.]).)+$";
    private static final String ID_CARD = "^([0-9]{9})|([0-9]{12})$";
    private static final String PHONE = "^(090[0-9]{7})|(091[0-9]{7})";
    private static final String EMAIL = "^\\w+@\\w+\\.\\w+$";
    private static final String CUSTOMER_ID = "^KH-[0-9]{4}$";
    private static final String SERVICE_ID = "^DV-[0-9]{4}$";
    private static final String STRING_EMPTY = "^(^$)|(\\s+)$";
    private static final String EMPTY_WITH_SPACE = "^\\s+$";


    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static boolean checkDateType(String date){
        Date dateParse;
        try {
            dateParse = simpleDateFormat.parse(date);
        } catch (ParseException e) {
           return false;
        }
        return true;
    }
    public static boolean checkBirthdayTime(String date){
        Date dateParse;
        try {
            dateParse = simpleDateFormat.parse(date);
            if(dateParse.getTime()>new Date().getTime()){
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }



    public static boolean checkName(String name){
        return name.matches(NAME);
    }
    public static boolean checkIdCard(String idCard){
        return idCard.matches(ID_CARD);
    }
    public static boolean checkSalary(Double salary){
        return !salary.isNaN();
    }
    public static boolean checkPhone(String phone){
        return phone.matches(PHONE);
    }
    public static boolean checkEmail(String email){
        return email.matches(EMAIL);
    }
    public static boolean checkEmptyWithSpace(String str){
        return str.matches(EMPTY_WITH_SPACE);
    }
    public static boolean checkCustomerId (String customerId){
        return customerId.matches(CUSTOMER_ID);
    }
    public static boolean checkServiceId(String serviceId){
        return serviceId.matches(SERVICE_ID);
    }
    public static boolean checkPositiveNumber(Double numberDouble){
        return numberDouble>0;
    }
    public static boolean checkPositiveNumber(Integer numberDouble){
        return numberDouble>0;
    }
    public static boolean checkStringEmpty(String string){
        return !string.matches(STRING_EMPTY);
    }

    public static boolean checkPositionIdAvailable(Integer positionId){
        List<EmployeePosition> positionList =  new EmployeePositionRepository().getListEmployeePosition();
        for(EmployeePosition position : positionList){
            if(position.getPositionId().equals(positionId)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkEducationIdAvailable(Integer educationId){
        List<EducationDegree> educationDegreeList =  new EducationDegreeRepository().getListEducationDegree();
        for(EducationDegree education : educationDegreeList){
            if(education.getEducationDegreeId().equals(educationId)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDivisionAvailable(Integer divisionId){
        List<Division> divisionList = new DivisionRepository().getListDivision();
        for(Division division: divisionList){
            if (division.getDivisionId().equals(divisionId)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneEmployeeAlreadyExist(String phone){
        for(EmployeeDTO employeeDTO : employeeDTOList){
            if(employeeDTO.getPhone().equals(phone)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkIdCardEmployeeAlreadyExist(String idCard){
        for(EmployeeDTO employeeDTO : employeeDTOList){
            if(employeeDTO.getIdCard().equals(idCard)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkEmailEmployeeAlreadyExist(String email){
        for(EmployeeDTO employeeDTO : employeeDTOList){
            if(employeeDTO.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}

