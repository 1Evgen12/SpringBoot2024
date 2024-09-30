package ru.shilov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@RestController
public class HelloController {
    List<String> list;
    int l = 0;
    HashMap<Integer, String> map;
    int m = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "name", defaultValue = "default") String name){
        if (l == 0){
            list = new ArrayList<>();
            list.add(name);
        }
        else
            list.add(name);
        l++;
    }
    @GetMapping("/show-array")
    public List showArrayList(){
        return list;
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "key", defaultValue = "0") Integer key,
            @RequestParam(value = "name", defaultValue = "default") String name){
        if (m == 0){
            map = new HashMap<>();
            map.put(key, name);
        }
        else
            map.put(key, name);
        m++;
    }
    @GetMapping("/show-map")
    public HashMap showHashMap(){
        return map;
    }
    @GetMapping("/show-all-lenght")
    public String showAllLenght (){
        String text = "ArrayList: " + String.valueOf(list.size())+" , HashMap: " + String.valueOf(map.size());
        return text;
    }
}
