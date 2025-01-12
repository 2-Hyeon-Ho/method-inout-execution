package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodInoutExecutionApplication {

    private static final Logger logger = LoggerFactory.getLogger("MethodInoutExecutionApplication");


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext notLogginContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        SampleService sampleService = (SampleService) context.getBean("sampleService", SampleService.class);
        NotLoggingService notLoggingService = (NotLoggingService) notLogginContext.getBean("notLoggingService", NotLoggingService.class);

        sampleService.sayHello("John");
        sampleService.add(5, 10);
        logger.info("sampleservice.getClass + {}", sampleService.getClass());

        notLoggingService.paw("baechu");
        notLoggingService.multiple(5, 10);
        logger.info("notLoggingService.getClass + {}", notLoggingService.getClass());
    }
}
