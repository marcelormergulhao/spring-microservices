package com.springmicroservices.boards.proxies;

import com.springmicroservices.boards.models.Card;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="cards-service")
@RibbonClient(name="cards-service")
public interface CardProxy {

    @GetMapping("/cards/{id}")
    Card getCard(@PathVariable Integer id);

}
