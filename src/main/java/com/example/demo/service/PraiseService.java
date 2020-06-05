package com.example.demo.service;

import com.example.demo.domain.Praise;

public interface PraiseService {
    void addPraise(Praise praise);
    void delPraiseById(Integer id);
    Praise getPraiseById(Integer id);
    void savePraise(Praise praise);
}
