package ss07_abstract_inteface;

public interface ILuyenCong {
    // thuộc tính nếu => mặc định là hằng số
    int NUM =1;
    void luyenCong();
    // từ jdk 8 cho phép định pt default => tự tìm hiểu thêm
    default void method1(){
        System.out.println("đây là method default");
    }
    // từ jdk 8 cho phép định pt static => tự tìm hiểu thêm
    static  void method2(){
        System.out.println("đây là mehthod static");
    }
}
