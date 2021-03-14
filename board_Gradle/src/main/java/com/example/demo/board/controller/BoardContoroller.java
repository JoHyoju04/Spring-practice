package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardContoroller {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
