package com.felipestore.artigos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/paginaPrincipal")
public class myController {
    
    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public String paginaPrincipal(){
        return "Principal";
    }

}
