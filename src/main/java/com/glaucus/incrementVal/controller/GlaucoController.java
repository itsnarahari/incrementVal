package com.glaucus.incrementVal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GlaucoController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GlaucoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> helloWorld() {
        return new ResponseEntity<>(new HashMap<>().put("from","Server"), HttpStatus.OK);
    }

    // Even if the multiple threads are there it wont let it.
    AtomicInteger atomicInteger = new AtomicInteger(0);


    @GetMapping("/inc")
    public String incValue(){
        jdbcTemplate.execute("UPDATE inc SET inc = "+atomicInteger.getAndIncrement());

        // We can use these also
        //jdbcTemplate.execute("UPDATE inc SET inc = inc + 1");
        return "success";
    }
}
