package com.lmtest.luckymoney.dao;

import com.lmtest.luckymoney.bean.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyRepository extends JpaRepository<Luckymoney, Integer> {
}
