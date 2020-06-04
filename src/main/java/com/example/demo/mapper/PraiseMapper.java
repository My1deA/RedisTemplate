package com.example.demo.mapper;


import com.example.demo.domain.Praise;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PraiseMapper {

    void addPraise(Praise praise);
    void delPraiseById(Integer id);
    Praise findPraiseById(Integer id);
    void savePraise(Praise praise);
}
