package ru.korkibuchi.SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import ru.korkibuchi.SpringBoot.Person;
import ru.korkibuchi.SpringBoot.RestReq;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Controller
public class HelloController {

    private RestReq requests;
    @Autowired
    public HelloController(RestReq requests) {
        this.requests = requests;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Person hello(@PathVariable int id){
        Person[] people = requests.getResponse1().getData();
        CatRequst catRequst = requests.getCatRequst();
        catRequst.formatString();
        System.out.println(catRequst.getFile());
        return people[id];

    }
    @GetMapping("/cat")
    public String cat(Model model){
        RestTemplate restTemplate = new RestTemplate();
        CatRequst catRequst = restTemplate.getForObject("https://aws.random.cat/meow", CatRequst.class);
        catRequst.formatString();
        model.addAttribute("cat", catRequst.getFile());
        return "hello";
    }
}
