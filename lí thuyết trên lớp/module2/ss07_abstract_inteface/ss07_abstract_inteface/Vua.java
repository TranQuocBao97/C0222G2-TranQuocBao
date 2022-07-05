package ss07_abstract_inteface;

public class Vua extends ConNguoi {
    boolean minhQuan;

    @Override
    public void diChuyen() {
        System.out.println("Vua đi lại bằng kiệu");
    }

    public Vua() {
    }

    public Vua(String ten, int tuoi, float chieuCao, int canNang, boolean minhQuan) {

        this.minhQuan = minhQuan;
    }

    public void raLenh(String tenLenh){
        System.out.println("Vua ra lệnh: " +tenLenh);
    }

    @Override
    public String toString() {
        return "Vua{" +
                super.toString()+
                "minhQuan=" + minhQuan +
                '}';
    }
}
