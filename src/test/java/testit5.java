
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteStreamHandler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.lst.util.CommandLineUtils;

/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class testit5 {
    private static final Logger LOGGER = LoggerFactory.getLogger(testit5.class);

    private static final String LOCAL_TEMPLATE_PATH = "/Users/lishutao/kaola";
    @Test
    public void date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String dayKey = dateFormat.format(new Date());

        System.out.println(dayKey);
    }

    @Test
    public void cloneGit() {
        //获得ssh
        String gitSSH = "ssh://git@g.hz.netease.com:22222/lishutao/common-projtests-msrest.git";

        String localProjectPath = LOCAL_TEMPLATE_PATH ;

        List<String> list = new ArrayList<>();

        list.add("git clone " + gitSSH);
//        list.add("git remote add origin " + gitSSH);
//
//        list.add("git add .");
//        list.add("git pull origin master");
//        list.add("git commit -m \"Initial Commit\" ");
//        list.add("git push -u origin master");

        File path = new File(localProjectPath);
        for (String command : list) {
            LOGGER.info("execute command: {}, gitSshUrl", command, gitSSH);
            try {
                CommandLineUtils.doBlock(command, path);
            } catch (IOException e) {
                LOGGER.error("uploadGit failed, command: {}, gitSshUrl: {}", command, gitSSH);
                return;
            }
        }
        LOGGER.info("uploadGit success");
    }


}
