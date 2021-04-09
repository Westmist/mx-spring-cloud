package com.lcc.cloud.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cong-Cong Liao
 * @since 2021-04-09
 **/
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        System.out.println("端口为：" + port);
        return port;
    }
}
