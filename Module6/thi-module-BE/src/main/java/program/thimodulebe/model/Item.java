package program.thimodulebe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Integer id;

    private String name;

    private Double lowestPrice;

    private Double medianPrice;

    @Column(name = "highest_buy_order")
    private String highestBuyOrder;

}
