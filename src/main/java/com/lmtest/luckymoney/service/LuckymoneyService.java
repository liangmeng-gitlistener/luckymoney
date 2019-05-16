package com.lmtest.luckymoney.service;

import com.lmtest.luckymoney.bean.Luckymoney;
import com.lmtest.luckymoney.dao.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    LuckymoneyRepository luckymoneyRepository;

    @Transactional
    public void createLove() {
        create("九月叶子", new BigDecimal(520));
        create("九月叶子", new BigDecimal(1314));
    }

    public Luckymoney create(String producer, BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setMoney(money);
        luckymoney.setProducer(producer);
        return luckymoneyRepository.save(luckymoney);
    }
}
