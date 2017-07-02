package com.softserv.security.OAuth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jarki on 7/1/2017.
 */

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "Hello";
    }

    @RequestMapping(value = "/private", method = RequestMethod.GET)
    public String privateHome(){
        return "Private Hello";
    }

}
