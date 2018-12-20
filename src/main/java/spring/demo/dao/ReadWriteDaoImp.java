package spring.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReadWriteDaoImp implements ReadWriteDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void write(int id){
        String sql = "insert into user(user_id, user_name, password, phone) values(?,?,?,?)";
        jdbcTemplate.update(sql,id,"qiu","123456","18801544066");
    }

    public Object read(int id){
        String sql = "select * from user where user_id = ?";
        return jdbcTemplate.queryForList(sql,id);
    }
}
