package program.ung_dung_muon_sach.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountView {
    @Id
    private String name;
    private Double view;

    public CountView() {
    }

    public CountView(String name, Double view) {
        this.name = name;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getView() {
        return view;
    }

    public void setView(Double view) {
        this.view = view;
    }
}
