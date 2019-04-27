package top.seiei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.seiei.bean.Student;
import top.seiei.property.SeieiProperty;
import top.seiei.service.StudentService;

import javax.annotation.Resource;

/**
 * 使用了 @RestController 注解，即相当于批量使用 @ReponseBody 注解，默认使用 JSON 数据返回
 */
@RestController
public class HelloWorldController {

    // 导入配置类
    @Autowired
    private SeieiProperty seieiProperty;

    @Resource
    private StudentService studentService;

    @RequestMapping("/hello")
    public String index() {
        return seieiProperty.getTxt();
    }

    @RequestMapping("/getstudent")
    public Student getStudent() {
        return studentService.selectOne();
    }
}