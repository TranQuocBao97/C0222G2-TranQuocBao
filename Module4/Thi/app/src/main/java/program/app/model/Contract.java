package program.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    private String nameContract;

    private String personName;

    private String idCard;

    private String dateRent;

    private String timeRent;

    private Double totalPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="room_id",referencedColumnName = "room_id")
    private Room room;
}
