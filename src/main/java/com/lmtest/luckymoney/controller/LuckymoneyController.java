package com.lmtest.luckymoney.controller;

import com.lmtest.luckymoney.bean.Luckymoney;
import com.lmtest.luckymoney.dao.LuckymoneyRepository;
import com.lmtest.luckymoney.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/luckymoney")
public class LuckymoneyController {

    @Autowired
    LuckymoneyRepository repository;
    @Autowired
    LuckymoneyService service;

    /**
     * http://localhost:8081/luckymoney/luckymoney/list
     * 获取红包列表
     * @return
     */
    @GetMapping("/list")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    /**
     * 发红包
     * @param producer
     * @param money
     * @return
     */
    @PostMapping("/create")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money) {
        return service.create(producer, money);
    }

    /**
     * 根据ID找红包
     * @param id
     * @return
     */
    @GetMapping("/put/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 领红包
     * @param id
     * @param consumer
     * @return
     */
    @PostMapping("/get/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {
        Optional<Luckymoney> optional = repository.findById(id);
        if (optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("love")
    public void createLove() {
        service.createLove();
    }
}
