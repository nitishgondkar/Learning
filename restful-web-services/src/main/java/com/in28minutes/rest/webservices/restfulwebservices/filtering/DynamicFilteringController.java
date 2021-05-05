package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DynamicFilteringController {

    //field1, field2
    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveSomeBean(){
        DynamicSomeBean dynamicSomeBean = new DynamicSomeBean("value1","value2","value3","value4");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        MappingJacksonValue mapping = new MappingJacksonValue(dynamicSomeBean);
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicSomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }

    //field3, field4
    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){
        List<DynamicSomeBean> list = Arrays.asList(new DynamicSomeBean("value1", "value2", "value3", "value4"), new DynamicSomeBean("value12", "value22", "value23", "value34"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3", "field4");
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicSomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }
}
