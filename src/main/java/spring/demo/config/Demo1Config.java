package spring.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Collections;

@ComponentScan({"spring.demo"})
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableCaching
public class Demo1Config {
    @Bean
    public Demo1Config configBean() {
        return new Demo1Config();
    }

    /**
     * 数据源
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8");
        return dataSource;
    }

    /**
     * 简化增删改查的操作模板
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }

    /**
     * 事务管理器
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 缓存管理器
     *
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("user")));
        return cacheManager;
    }
}
