package spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.demo.dao.ReadWriteDao;

@Service
@Transactional
public class ReadWriteDemoServiceImp implements ReadWriteDemoService {
    @Autowired
    private ReadWriteDao readWriteDao;

    @Override
    @CachePut(value = "user", key = "#id")
    public Boolean write(int id) {
        System.out.println("------service write to DB----");
        readWriteDao.write(id);
        return true;
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public Object read(int id) {
        System.out.println("------service read from DB----");
        return readWriteDao.read(id);
    }
}
