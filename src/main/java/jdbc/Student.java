package jdbc;

public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String department;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Student(int id, String name, String sex, int age, String department) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.department = department;
    }
    public Student() {
        super();
    }
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", department=" + department;
    }

}
