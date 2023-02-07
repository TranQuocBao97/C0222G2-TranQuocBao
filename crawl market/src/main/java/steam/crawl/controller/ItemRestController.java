package steam.crawl.controller;

import lombok.AllArgsConstructor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import steam.crawl.model.ItemCsgo;
import steam.crawl.model.ItemDota2;
import steam.crawl.repository.ItemCsgoRepository;
import steam.crawl.repository.ItemDota2Repository;
import steam.crawl.service.Scraping;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemRestController {
    private final ChromeDriver driver;
    @Autowired
    private ItemDota2Repository itemDota2Repository;

    @Autowired
    private ItemCsgoRepository itemCsgoRepository;

    @Autowired
    private Scraping scraping;

    @GetMapping("/dota2")
    public ResponseEntity<Void> getHighOrderPriceDOTA2() {
        Integer number = 0;
        List<ItemDota2> listItem = itemDota2Repository.itemDota2List();
        while (number < listItem.size()){
            try{
                String nameItem = listItem.get(number).getName();
                nameItem = nameItem.replace("?","%3F");
                nameItem = nameItem.replace(":","%3A");
                System.out.println(nameItem);
                listItem.get(number).setHighestBuyOrder(scraping.scrapingPriceDOTA(nameItem));
                System.out.println(listItem.get(number).getId());
                System.out.println(listItem.get(number).getName());
                System.out.println(listItem.get(number).getHighestBuyOrder());
                itemDota2Repository.save(listItem.get(number));
                number +=1;
//                for (Item item : iItemRepository.testList()) {
//                    item.setHighestBuyOrder(scraping.scrapingPriceCSGO(item.getName()));
//                    iItemRepository.save(item);
//                }
            }catch (Exception e){
                System.out.println("DOTA2 ITEM ERROR - PAUSE 20S");
                System.out.println(e.getMessage());
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        System.out.println("done");
//        driver.quit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/save-list-item-dota2")
    public ResponseEntity<Void> saveListItemDota2(@RequestBody List<ItemDota2> listItemDota2) {
        itemDota2Repository.saveAll(listItemDota2);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/csgo")
    public ResponseEntity<Void> getHighOrderPriceCSGO() {
        Integer number = 0;
        List<ItemCsgo> listItem = itemCsgoRepository.itemCsgoList();
        while (number < listItem.size()){
            try{
                String nameItem = listItem.get(number).getName();
                nameItem = nameItem.replace("?","%3F");
                nameItem = nameItem.replace(":","%3A");
                System.out.println(nameItem);
                listItem.get(number).setHighestBuyOrder(scraping.scrapingPriceCSGO(nameItem));
                System.out.println(listItem.get(number).getId());
                System.out.println(listItem.get(number).getName());
                System.out.println(listItem.get(number).getHighestBuyOrder());
                itemCsgoRepository.save(listItem.get(number));
                number +=1;
            }catch (Exception e){
                System.out.println("CSGO ITEM ERROR");
                System.out.println(e.getMessage());
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        System.out.println("done");
//        driver.quit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/save-list-item-csgo")
    public ResponseEntity<Void> saveListItemCsgo(@RequestBody List<ItemCsgo> listItemCsgo) {
        itemCsgoRepository.saveAll(listItemCsgo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
