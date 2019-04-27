package top.seiei.bean;

public class Student {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private Integer testint;

    private Boolean testtinyint;

    public Student(Integer id, String name, Integer age, String sex, Integer testint, Boolean testtinyint) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.testint = testint;
        this.testtinyint = testtinyint;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getTestint() {
        return testint;
    }

    public void setTestint(Integer testint) {
        this.testint = testint;
    }

    public Boolean getTesttinyint() {
        return testtinyint;
    }

    public void setTesttinyint(Boolean testtinyint) {
        this.testtinyint = testtinyint;
    }
}