package spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.demo.dao.ReadWriteDao;

@Service
@Transactional
public class ReadWriteDemoServiceImp implements ReadWriteDemoService{
    @Autowired
    private ReadWriteDao readWriteDao;
    public Boolean write(){
        System.out.println("------service write demo----");
        readWriteDao.write();
        return true;
    }
}
