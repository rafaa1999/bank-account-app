package com.rafaa.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigTestController {
   @Value("${global.params.p1}")
   private int p1;
   @Value("${global.params.p2}")
   private int p2;
//   @Value("${global.params.x}")
//   private int x;
//   @Value("${global.params.y}")
//   private int y;
   @RequestMapping("/testConfig")
   public Map<String,Integer> configTest(){
       return Map.of("p1", p1, "p2", p2);
   }
}
