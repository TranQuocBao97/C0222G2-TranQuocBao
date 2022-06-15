package modal;

public class TheMuonSach {
    private String id;
    private Boolean status;
    private String dateStart;
    private String dateEnd;
    private String hocSinhId;
    private String sachId;

    public TheMuonSach() {
    }

    public TheMuonSach(String id, String dateStart, String dateEnd, String hocSinhId, String sachId) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.hocSinhId = hocSinhId;
        this.sachId = sachId;
    }

    public TheMuonSach(String id, Boolean status, String dateStart, String dateEnd, String hocSinhId, String sachId) {
        this.id = id;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.hocSinhId = hocSinhId;
        this.sachId = sachId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getHocSinhId() {
        return hocSinhId;
    }

    public void setHocSinhId(String hocSinhId) {
        this.hocSinhId = hocSinhId;
    }

    public String getSachId() {
        return sachId;
    }

    public void setSachId(String sachId) {
        this.sachId = sachId;
    }
}
