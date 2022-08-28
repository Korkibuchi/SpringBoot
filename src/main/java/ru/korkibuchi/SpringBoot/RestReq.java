package ru.korkibuchi.SpringBoot;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.korkibuchi.SpringBoot.controllers.CatRequst;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class RestReq {
        private CatRequst catRequst;
        private RestTemplate restTemplate;// = new RestTemplate();
        private PageInfo response1;// = restTemplate.getForObject("https://reqres.in/api/users?page=2", PageInfo.class);

    public RestReq() {
        this.restTemplate = new RestTemplate();
        this.catRequst = restTemplate.getForObject("https://aws.random.cat/meow", CatRequst.class);
        this.response1 = restTemplate.getForObject("https://reqres.in/api/users?page=2", PageInfo.class);
    }



    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public CatRequst getCatRequst() {
        return catRequst;
    }

    public PageInfo getResponse1() {
        return response1;
    }


}

