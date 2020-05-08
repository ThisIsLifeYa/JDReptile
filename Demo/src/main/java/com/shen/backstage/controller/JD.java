package com.shen.backstage.controller;

import com.shen.backstage.service.JdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/JD")
public class JD {
    @Autowired
    private JdService jdService;

    @RequestMapping("/insert")
    public String insert(@RequestParam String word, @RequestParam int first, @RequestParam int end, @RequestParam int number) {
        jdService.insert(word,first,end,number);
        return "index";
    }
}
