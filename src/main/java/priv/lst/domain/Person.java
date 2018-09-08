package priv.lst.domain;

import lombok.Data;

/**
 * Created by lishutao on 2018/7/26.
 *
 * @author lishutao
 * @date 2018/7/26
 */
@Data
public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
