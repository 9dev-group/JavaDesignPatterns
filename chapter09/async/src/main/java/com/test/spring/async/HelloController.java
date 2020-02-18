package com.test.spring.async;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
 
@Controller
public class HelloController {
  Logger logger = LoggerFactory.getLogger(HelloController.class);
 
  @Autowired
  HelloService helloService;
 
  @RequestMapping("/helloAsync")
  public Callable<String> sayHelloAsync() {
    logger.info("Entering controller");
 
    Callable<String> asyncTask = new Callable<String>() {
 
      @Override
      public String call() throws Exception {
        return helloService.doSlowWork();
      }
    };
     
    logger.info("Leaving  controller");
    return asyncTask;
  }
}
