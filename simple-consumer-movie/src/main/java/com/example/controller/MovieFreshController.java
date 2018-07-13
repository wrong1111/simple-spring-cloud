package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyong
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/13
 */
@RestController
@RequestMapping("/movieFresh")
@RefreshScope
public class MovieFreshController {
    @Value("${movie.name}")
    private String name;

    @Value("${movie.url}")
    private String url;

    @GetMapping("/test")
    public String val(){
        return name+"-"+url;
    }
}
