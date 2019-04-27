package top.seiei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动 spring boot 主程序入口
 * 它会自动扫描本类所在的包下所有 spring 组件
 */
@SpringBootApplication
@EnableTransactionManagement // 支持回滚
@MapperScan("top.seiei.dao") // springboot 使用 mybatis 需要用到该注解，表示扫描 Dao 组件
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}
