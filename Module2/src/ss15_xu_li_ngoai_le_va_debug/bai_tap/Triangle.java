package ss15_xu_li_ngoai_le_va_debug.bai_tap;

public class Triangle {
    private Double edge1;
    private Double edge2;
    private Double edge3;

    public Triangle(Double edge1, Double edge2, Double edge3) throws Exception{
        if(edge1 <=0 || edge2 <=0 || edge3<=0){
            throw new TriangleException("3 cạnh không được nhỏ hơn hoặc bằng 0");

        }else if(edge1+edge2<edge3 || edge1+edge3<edge2 || edge2+edge3<edge1){
            throw new TriangleException("tổng 2 cạnh của 1 tam giác phải lớn hơn cạnh còn lại");
        }
        System.out.println("Tam giác đã được tạo");
    }
}
