package validate;

public class Validate {
    private static final String NAME = "^((?![0-9\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\=\\-\\[\\]\\{\\}\\;\\:\\\"\\\\\\/\\<\\>\\?\\.]).)+$";
    private static final String ID_CARD = "^[0-9]{9}$";
    private static final String PHONE = "^0[0-9]{9}";
    private static final String EMAIL = "^\\w+@\\w+\\.\\w+$";

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

}
