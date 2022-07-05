package ss07_abstract_inteface;

public  class ChienBinhDepTrai extends ChienBinh{
    private int doDepTrai;

    public ChienBinhDepTrai() {
    }

    @Override
    public void chienDau() {
        System.out.println("Chiến đẹp trai chiến đầu bằng nhan sắc");
    }

    public ChienBinhDepTrai(String ten, int tuoi, float chieuCao, int canNang, String vuKhi, int doDepTrai) {

        this.doDepTrai = doDepTrai;
    }

    @Override
    public String toString() {
        return "ChienBinhDepTrai{" +
                super.toString()+
                "doDepTrai=" + doDepTrai +
                '}';
    }

}
