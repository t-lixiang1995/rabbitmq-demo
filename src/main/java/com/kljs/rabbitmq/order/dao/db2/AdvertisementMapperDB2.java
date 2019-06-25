package com.kljs.rabbitmq.order.dao.db2;


import com.kljs.rabbitmq.order.model.Advertisement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Mapper
@Component(value = "advertisementMapperDB2")
public interface AdvertisementMapperDB2 {

    @Select("SELECT * FROM `t_advertisement` WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM `t_advertisement`)))  ORDER BY id LIMIT 1")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "shopId", column = "shop_id"),
            @Result(property = "name", column = "name"),
    })
    Advertisement getRankOne();


}