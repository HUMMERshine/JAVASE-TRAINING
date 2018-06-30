package priv.lst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lishutao on 2018/5/13.
 *
 * @author lishutao
 * @date 2018/5/13
 */
@RestController
public class TestController {

    @RequestMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }
}