package com.test.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
 
@Service
public class HelloService {
  Logger logger = LoggerFactory.getLogger(HelloService.class);
   
  public String doSlowWork() {
    logger.info("Start  slow work");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    logger.info("finish slow work");
//    return "forward:/another";  // forward to another url
    return "index";       // return view's name
  }
}
