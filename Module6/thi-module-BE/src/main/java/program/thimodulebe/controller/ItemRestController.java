package program.thimodulebe.controller;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.thimodulebe.model.Item;
import program.thimodulebe.model.ItemCsgo;
import program.thimodulebe.model.ItemDota2;
import program.thimodulebe.repository.IItemRepository;
import program.thimodulebe.repository.ItemCsgoRepository;
import program.thimodulebe.repository.ItemDota2Repository;
import program.thimodulebe.service.Scraping;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemRestController {

    private final ChromeDriver driver;
    @Autowired
    private IItemRepository iItemRepository;

    @Autowired
    private ItemDota2Repository itemDota2Repository;

    @Autowired
    private ItemCsgoRepository itemCsgoRepository;

    @Autowired
    private Scraping scraping;

    public ItemRestController(ChromeDriver driver) {
        this.driver = driver;
    }

    @PostMapping
    public ResponseEntity<Void> saveItem(@RequestBody List<Item> listItem) {
        iItemRepository.saveAll(listItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Void> updatePrice(@RequestBody List<Item> listItem) {
        iItemRepository.saveAll(listItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update-one")
    public ResponseEntity<Void> updateOne(@RequestBody Item item) {
        iItemRepository.save(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getListItem() {
        Integer number = 0;
        List<Item> listItem = iItemRepository.testList();
        while (number <= listItem.size()){
            try{
                listItem.get(number).setHighestBuyOrder(scraping.scrapingPriceCSGO(listItem.get(number).getName()));
                System.out.println(listItem.get(number).getId());
                System.out.println(listItem.get(number).getName());
                System.out.println(listItem.get(number).getHighestBuyOrder());
                iItemRepository.save(listItem.get(number));
                number +=1;
//                for (Item item : iItemRepository.testList()) {
//                    item.setHighestBuyOrder(scraping.scrapingPriceCSGO(item.getName()));
//                    iItemRepository.save(item);
//                }
            }catch (Exception e){
                System.out.println("ERROR CMNR CHAY LAI THOI");
            }
        }
        return new ResponseEntity<>(iItemRepository.testList(), HttpStatus.OK);
    }

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
        driver.quit();
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
        driver.quit();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/save-list-item-csgo")
    public ResponseEntity<Void> saveListItemCsgo(@RequestBody List<ItemCsgo> listItemCsgo) {
        itemCsgoRepository.saveAll(listItemCsgo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
