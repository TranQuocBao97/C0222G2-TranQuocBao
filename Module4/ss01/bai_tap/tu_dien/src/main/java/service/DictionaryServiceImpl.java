package service;

import org.springframework.stereotype.Service;
import service.interface_service.IDictionaryService;

import java.util.HashMap;
import java.util.Map;


@Service
public class DictionaryServiceImpl implements IDictionaryService {
    static Map<String,String> mapList = new HashMap<>();

    static {
        mapList.put("apple","Táo");
        mapList.put("pig","Heo");
        mapList.put("fan","Quạt");
        mapList.put("computer","Máy tính");
        mapList.put("ball","bóng");
        mapList.put("fix","Sữa");
    }
    @Override
    public String findEnglishWord(String english) {
        if(mapList.containsKey(english)){
            return mapList.get(english);
        }
        return "Không tìm thấy kết quả!!!";
    }
}
