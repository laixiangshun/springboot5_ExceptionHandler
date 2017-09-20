package com.lai.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * Created by lailai on 2017/9/19.
 */
@Repository
public class userDaoImpl implements userDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        Random r=new Random();
        int num=r.nextInt(101);
        jdbcTemplate.update("INSERT INTO user(name,age) VALUES(?,?)","小明"+num,num);
    }
}
