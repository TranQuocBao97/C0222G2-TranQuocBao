package ss07_abstract_inteface;

public class ChienBinhAnhDung extends ChienBinh implements ILuyenCong,ILuyenPhepThuat{
    private int sucManh;
    public ChienBinhAnhDung() {
    }

    @Override
    public void chienDau() {
        System.out.println("chiến đầu bằng phép thu và sức mạng");
    }

    public ChienBinhAnhDung(String ten, int tuoi, float chieuCao, int canNang, String vuKhi, int sucManh) {
        this.sucManh = sucManh;
    }

    @Override
    public void luyenCong() {
        System.out.println("chiên binh anh dung đi luyện công");
    }

    @Override
    public void hoMuaGoiGio() {
        System.out.println("chiến bình anh dung đi học hô mưa gọi gió");
    }
}
