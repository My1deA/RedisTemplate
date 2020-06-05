package com.example.demo.service.Impl;

import com.example.demo.domain.Praise;
import com.example.demo.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private PraiseService praiseService;

    @Override
    public void addPraise(Praise praise) {
        praiseService.addPraise(praise);
    }

    @Override
    public void delPraiseById(Integer id) {
        praiseService.delPraiseById(id);
    }

    @Override
    public Praise getPraiseById(Integer id) {
        return praiseService.getPraiseById(id);
    }

    @Override
    public void savePraise(Praise praise) {
        praiseService.savePraise(praise);
    }
}
