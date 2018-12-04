package springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springDemo.config.Demo1Config;

public class Demo1 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new  AnnotationConfigApplicationContext(Demo1Config.class);
        String[] names = context.getBeanDefinitionNames();
        for(String name: names){
            System.out.println(name);
        }
        context.getBeanFactory().getBean("configBean");
        context.close();
    }
}
