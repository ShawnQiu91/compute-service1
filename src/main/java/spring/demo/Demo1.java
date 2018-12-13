package spring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.Controller.ReadWriteController;
import spring.demo.config.Demo1Config;

public class Demo1 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo1Config.class);
       /* String[] names = context.getBeanDefinitionNames();
        System.out.println("***********************IOC BEAN************************");
        for (String name : names) {
            System.out.println(name);
            Object obj = context.getBeanFactory().getBean(name);
            System.out.println(obj);
        }*/

        Object controller = context.getBeanFactory().getBean("readWriteController");
        ((ReadWriteController) controller).write();

        System.out.println("***********************IOC END**********************");
        context.close();
    }
}
