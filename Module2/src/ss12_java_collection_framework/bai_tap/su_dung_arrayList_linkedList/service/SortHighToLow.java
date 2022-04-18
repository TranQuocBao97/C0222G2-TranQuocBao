package ss12_java_collection_framework.bai_tap.su_dung_arrayList_linkedList.service;

import ss12_java_collection_framework.bai_tap.su_dung_arrayList_linkedList.model.ProductSs12;

import java.util.Comparator;

public class SortHighToLow implements Comparator<ProductSs12> {

    @Override
    public int compare(ProductSs12 o1, ProductSs12 o2) {
        return o2.getPrice()-o1.getPrice();
    }
}
