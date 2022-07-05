package ss07_abstract_inteface;

public class ChienBinhThongThai extends ChienBinh implements ILuyenPhepThuat {
    private int chiSoThongMinh;

    public ChienBinhThongThai(){

    }

    @Override
    public void chienDau() {
        System.out.println("chiến đầu bằng phép thuật");
    }

    public ChienBinhThongThai(String ten, int tuoi, float chieuCao, int canNang, String vuKhi, int chiSoThongMinh) {
        this.chiSoThongMinh = chiSoThongMinh;
    }

    @Override
    public String toString() {
        return "ChienBinhThongThai{" +
                super.toString()+
                "chiSoThongMinh=" + chiSoThongMinh +
                '}';
    }

    @Override
    public void hoMuaGoiGio() {
        System.out.println("chiên binh thông thai đa luyên phép thuật thành công");
    }
}
