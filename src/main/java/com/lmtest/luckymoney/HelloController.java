package com.lmtest.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Spring4以后出的注解相当于@ResponseBody+@Controller
@RestController
@RequestMapping({"/hello","/hi"})
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;
//    @Value("${limit.minMoney}")
//    private BigDecimal minMoney;

    @GetMapping("/say")
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        return "minMoney: " + limitConfig.getMinMoney() + ", 说明：" + limitConfig.getDescription();
//        return "index";
    }

    //  http://localhost:8081/luckymoney/hello/say2/100
    @GetMapping("/say2/{id}")
    public String say2(@PathVariable(value = "id", required = false) int id){
        return "id : " + id;
    }
    //  http://localhost:8081/luckymoney/hello/say3?id=100
//    @GetMapping("/say3")
    @PostMapping("/say3")
    public String say3(@RequestParam(value = "id", required = false, defaultValue = "0") int id){
        return "id : " + id;
    }
}
