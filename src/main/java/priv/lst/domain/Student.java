package priv.lst.domain;

/**
 * Created by lishutao on 2018/10/24.
 *
 * @author lishutao
 * @date 2018/10/24
 */
public class Student extends Person {
    private Integer stuNo;

    public Student(Integer id, String name) {
        super(id, name);
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }
}
