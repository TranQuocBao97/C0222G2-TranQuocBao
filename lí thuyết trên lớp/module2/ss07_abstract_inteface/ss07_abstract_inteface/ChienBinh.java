package ss07_abstract_inteface;

public abstract class ChienBinh extends ConNguoi {
    private String vuKhi;

    public ChienBinh() {
    }

    public ChienBinh(String ten, int tuoi, float chieuCao, int canNang, String vuKhi) {
        super(ten,tuoi,chieuCao,canNang);
        this.vuKhi = vuKhi;
    }

    @Override
    public void diChuyen() {
        System.out.println("chiến binh di chuyển bằng ngựa");
    }
    // method thường
    public void lamNhiemVu(String tenNhiemVu){
        System.out.println(this.getTen()+ " đi làm nhiệm vụ" +tenNhiemVu);
    }
    // phương thức abstract
    public abstract void chienDau();
    @Override
    public String toString() {
        return   super.toString()+
                "vuKhi='" + vuKhi + '\'' +
                '}';
    }
}
