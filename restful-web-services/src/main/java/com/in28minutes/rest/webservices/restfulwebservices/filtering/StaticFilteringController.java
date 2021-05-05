package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StaticFilteringController {

    @GetMapping("/static-filtering")
    public StaticSomeBean retrieveSomeBean(){
        return new StaticSomeBean("value1","value2","value3","value4");
    }

    @GetMapping("/static-filtering-list")
    public List<StaticSomeBean> retrieveListOfSomeBean(){
        return Arrays.asList(new StaticSomeBean("value1", "value2", "value3", "value4"),new StaticSomeBean("value12", "value22", "value23", "value34"));
    }
}
