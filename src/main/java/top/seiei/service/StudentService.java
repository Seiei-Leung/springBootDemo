package top.seiei.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.seiei.bean.Student;
import top.seiei.dao.StudentMapper;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public Student selectOne() {
        return studentMapper.selectByPrimaryKey(1);
    }

    /**
     * 测试回滚
     */
    @Transactional(rollbackFor = Exception.class)
    public void testForTransactional() throws SQLException {
        Student student = new Student();
        student.setAge(17);
        student.setName("Tran");
        student.setSex("boy");
        studentMapper.insertSelective(student);
        throw new SQLException("发生异常了..");
    }
}
