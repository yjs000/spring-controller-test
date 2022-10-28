package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.VO.ParamVo;

@Controller
public class GetContoller {
    

    // param을 받는 annotation
    // @RequestBody : body에 있는 것들을 꺼내줌. Content-Type에 따라 알맞는 HttpMessageConverter가 선택됨
    // @RequestParam : query parameters, form data, and parts in multipart requests 에 있는 것들을 꺼내줌
    // servlet api가 query parameter와 form데이터를 합친다. parameter라는 하나의 map으로.  그래서 body의 데이터도 꺼낼 수 있다.
    // * spring webflux에서는 query parameter만 받을 수 있다.


    // return과 관련된 annotation
    // @ResponseBody return된 값을 http body에 담아준다. -> Accept Type이 ResponseBody의 타입과 같아야 한다.
    // @ResponseBody없이 return되면 현재 url에 return된 값을 붙여서 찾아진 페이지를 return 한다는 뜻. (redirect되진 않고 데이터만 받음) do nothing but add a main to the end of the existing URL and try to GET a web page which maps to this URL

    

    @PostMapping("/test1")
    public String test1(@RequestBody HashMap<String, String> param) {
        return "hello";
    }

    @PostMapping("/test2")
    @ResponseBody
    public HashMap<String, String> test2(@RequestBody HashMap<String, String> param) {
        return param;
    }

    @GetMapping("/test3")
    @ResponseBody
    public HashMap<String, String> test3 (@RequestParam HashMap<String, String> param){
        System.out.println(param);
        return param;
    }

    @GetMapping("/test5")
    @ResponseBody
    public String test5 (ParamVo param){
        System.out.println(param);
        return "param";
    }

    @GetMapping("/test4")
    @ResponseBody
    public String test4 (HashMap<String, String> param){
        System.out.println(param);
        return "param";
    }

    @GetMapping("/test6")
    public String test6 (@RequestParam String name){
        System.out.println(name);
        return name;
    }
}
