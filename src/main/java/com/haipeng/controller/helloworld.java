package com.haipeng.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class helloworld {
    @RequestMapping("/hello")
    public String hello(){

        return "helloworld333";
    }

    @GetMapping("/findOne/{id}")
    public String findOne(@PathVariable("id")String id){
        System.out.println("id"+id);
        return "find";
    }
    @PostMapping("/findOne1/{id}")
    public String find3(@PathVariable("id")String id){
        System.out.println("id"+id);
        return "find";
    }
    @PutMapping("/findOne2/{id}")
    public String find1(@PathVariable("id")String id){
        System.out.println("id"+id);
        return "find";
    }
    @DeleteMapping("/findOne3/{id}")
    public String find2(@PathVariable("id")String id){
        System.out.println("id"+id);
        return "find";
    }
}
