package case_study.services.implement.promo_implement;

import case_study.models.promo.Promo;
import case_study.services.IService;
import case_study.services.implement.booking_implement.BookingServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PromotionServiceImpl{
    private static Set<Promo> promoList = new TreeSet<>();
    static BookingServiceImpl bookingService = new BookingServiceImpl();
    static List<String> customerPromoList = new ArrayList<>();

    static {
        Integer numberTicket = bookingService.countContractList();
        Integer numberTicket50 = numberTicket*30/100;
        Integer numberTicket20 = numberTicket*30/100;
        Integer numberTicket10 = numberTicket-numberTicket50-numberTicket20;
        for (int i = 0; i < numberTicket50 ; i++) {
            promoList.add(new Promo(50));
        }
        for (int i = 0; i < numberTicket20; i++) {
            promoList.add(new Promo(20));
        }
        for (int i = 0; i < numberTicket10; i++) {
            promoList.add(new Promo(10));
        }
    }

    public void displayCustomHaveContract (){
        bookingService.displayContract();
    }

    public void displayCustomHavePromo (){

    }


}
