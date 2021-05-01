package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	//GET
	//URI - /hello-world
	//Method - "Hello World"
	/*
	 * @RequestMapping(method=RequestMethod.GET, path = "/hello-world") 
	 * public String helloWorld() { return "Hello World"; }
	 */


	//Shorter Version of Above (@GetMapping --> @RequestMapping(method=RequestMethod.GET)
	@GetMapping(path = "/hello-world") 
	public String helloWorld() { return "Hello World"; }
	
	//Return BEAN
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	
	//hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	//Internationalization
	/*@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
		return messageSource.getMessage("good.morning.message", null, locale);
	}*/

	//Avoid Adding @RequestHeader as parameter to every method then
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
