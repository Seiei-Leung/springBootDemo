package top.seiei.service;

import org.springframework.stereotype.Service;
import top.seiei.bean.Student;
import top.seiei.dao.StudentMapper;

import javax.annotation.Resource;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public Student selectOne() {
        return studentMapper.selectByPrimaryKey(1);
    }
}
