package program.ung_dung_khach_san.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "date_of_birth", columnDefinition = "DATE");
    private LocalDate dateOfBirth;

}
