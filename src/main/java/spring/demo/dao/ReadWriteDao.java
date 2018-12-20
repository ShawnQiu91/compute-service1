package spring.demo.dao;

public interface ReadWriteDao {
    void write(int id);
    Object read(int id);
}
