package spring.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.demo.service.ReadWriteDemoService;

@Controller
public class ReadWriteController {
    @Autowired
    private ReadWriteDemoService readWriteDemoService;

    public void write(){
        readWriteDemoService.write();
        System.out.println(readWriteDemoService);
    }
}
