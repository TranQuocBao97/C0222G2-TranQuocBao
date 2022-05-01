package case_study_2.services.class_implement.Promo;

import case_study_2.models.Promo;
import case_study_2.services.class_implement.booking_implement.BookingServiceImpl;
import case_study_2.utils.current_time.CurrentTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PromotionServiceImpl {
    static List<String> listCustomerInMonth = new Stack<>();
    static List<Promo> listCustomerGotPromo = new ArrayList<>();

    public void displayCustomerCurrentMonth(){
        String currentDate = CurrentTime.getCurrentTime();
        String[] currentDateArray = currentDate.split("/");
        listCustomerInMonth = BookingServiceImpl.getListUserForPromo(currentDateArray[1]);
        int count = 0;
        for(String customer : listCustomerInMonth){
            System.out.println(customer);
            count++;
        }
        Stack<String> listCustomerForPromo = (Stack<String>) listCustomerInMonth;
        System.out.println("["+count+" Customer booking in this month]");
        System.out.println("voucher 10% give 50% customers");
        Integer voucher10 = Integer.parseInt(String.valueOf((count/2)));
        System.out.println("10%: "+voucher10);
        System.out.println("voucher 20% give 40% customers");
        Integer voucher20 = Integer.parseInt(String.valueOf(count*4/10));
        System.out.println("20%: "+voucher20);
        System.out.println("voucher 50% give total - voucher10%and20%");
        Integer voucher50 = count-voucher20-voucher10;
        System.out.println("50%: "+voucher50);
        List<String> listVoucher = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if(i<voucher10){
                listVoucher.add("10%");
            }else if(i<voucher10+voucher20){
                listVoucher.add("20%");
            }else {
                listVoucher.add("50%");
            }
        }

        for (int i = 0; i < count; i++) {
            listCustomerGotPromo.add(new Promo(listCustomerForPromo.pop(), listVoucher.get(i)));
        }
    }

    public void displayCustomerGetVoucher(){
        for(Promo promo : listCustomerGotPromo){
            System.out.println(promo);
        }
    }

}
