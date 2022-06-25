package program.form_dang_ky.dto;


import javax.validation.constraints.*;



public class UserDTO {

    @NotBlank(message = "Không được để trống và không có khoảng trống đầu cuối")
    @Pattern(regexp = "[a-zA-Z]+", message = "Chỉ được chứa chữ cái")
    @Size(min=2,max=30, message = "Độ dài phải đạt 2 đến 30 kí tự")
    private String firstName;

    @NotBlank(message = "Không được để trống và không có khoảng trống đầu cuối")
    @Pattern(regexp = "[a-zA-Z]+", message = "Chỉ được chứa chữ cái")
    @Size(min=2,max=30, message = "Độ dài phải đạt 2 đến 30 kí tự")
    private String lastName;

    @NotBlank(message = "Không được để trống và không có khoảng trống đầu cuối")
    @Pattern(regexp = "0[0-9]{9}", message = "Bắt đầu từ số 0, phải đủ 10 số")
    private String phoneNumber;

    @NotBlank(message = "Không được để trống và không có khoảng trống đầu cuối")
    @Min(value = 18, message = "Phải trên 18 tuổi")
    private String age;

    @NotBlank(message = "Không được có khoảng trống đầu cuối")
    @Email(message = "Email không hợp lệ")
    private String email;


    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
