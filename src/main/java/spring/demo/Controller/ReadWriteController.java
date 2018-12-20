package spring.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.demo.service.ReadWriteDemoService;

import java.util.Random;
import java.util.UUID;

@Controller
public class ReadWriteController {
    @Autowired
    private ReadWriteDemoService readWriteDemoService;

    public void write(){
        readWriteDemoService.write(new Random().nextInt());
    }

    public void read(int id){
        System.out.println(readWriteDemoService.read(id));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
