package priv.lst.ehcache;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lishutao on 2019/2/23.
 *
 * @author lishutao
 * @date 2019/2/23
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6227376640818226890L;
    private String name;
    private String code;

    public User(String name, String code) {
        super();
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    /**
     * 不支持
     * @param name
     */
    @Deprecated
    public void setName(String name) {
        this.name = "lishutao";
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
