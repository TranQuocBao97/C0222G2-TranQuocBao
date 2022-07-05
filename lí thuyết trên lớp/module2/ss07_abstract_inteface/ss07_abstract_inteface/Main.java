package ss07_abstract_inteface;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      dietRong();
    }

    public static void dietRong() {
        // bị rồng xấm chiếm đất nước
        Vua vua = new Vua();
        ChienBinhDepTrai chienBinhDepTrai = new ChienBinhDepTrai("hoàn",18,1.8f,70,"Son",10);
        ChienBinhThongThai chienBinhThongThai =new ChienBinhThongThai("Bảo",20,1.7f,60,"Quat",7);
        ChienBinhAnhDung chienBinhAnhDung = new ChienBinhAnhDung("Tài", 20,1.8f,80,"kiếm",100);
        vua.raLenh("họp chiều định");
        vua.raLenh("Chiến binh đẹp trai đi diệt rông");
        chienBinhDepTrai.lamNhiemVu("diệt rộng");
        chienBinhDepTrai.chienDau();
        // không mê trai đẹp =>
        chienBinhDepTrai.lamNhiemVu("đi chơi công chúa");
        vua.raLenh("chiến binh thông thái");
        // chiến bình thông thải phải đi luyện phép thuật
        chienBinhThongThai.hoMuaGoiGio();
        chienBinhThongThai.chienDau();
        // không diện được rồng
        vua.raLenh("chiến binh anh dung diệt rông");
        chienBinhAnhDung.lamNhiemVu("Đi diệt rông");
        chienBinhAnhDung.hoMuaGoiGio();
        chienBinhAnhDung.luyenCong();
        chienBinhAnhDung.chienDau();
        // rồng đã bị diệt




    }
}
