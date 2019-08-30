import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import priv.lst.arch.test.MillisecondClock;
import priv.lst.domain.Student;
import priv.lst.ehcache.User;
import priv.lst.util.NkvUtil;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class testit2 {

    @Data
    public static class LogStruct{
        public String parentDir = "/";

        public String logFile;

        public List<LogStruct> childDirList;

        public Boolean isDir = false;

        public String getPath() {
            if (StringUtils.isBlank(parentDir)) {
                return "/" + logFile;
            } else {
                return parentDir + "/" + logFile;
            }
        }

        @Override
        public String toString() {
            return childDirList == null ? logFile :  logFile + childDirList.toString();
        }
    }

    public static final String splitStr = "|--";
    public static final String endStr = "|--";

    public static final Map<Integer, List<LogStruct>> logLevelMap = Maps.newHashMap();
    public static final Map<Integer, LogStruct> curLogLevelMap = Maps.newHashMap();

    public static void main(String[] args) {

        final String endString1 = "|--";
        final String endString2 = "`--";
        final String endChar1 = "|";
        final String endChar2 = "`";
        Process process = null;
        List<String> processList = new ArrayList<String>();
        try {
//            process = Runtime.getRuntime().exec("ls -R /Users/lishutao/code");
            process = Runtime.getRuntime().exec("tree /Users/lishutao/code");
//            process = Runtime.getRuntime().exec("kubectl exec kaola-test-demo-docker-qatest-29-4-1799-6bccdb557-k2wm2 -- tree approot/logs/ -P *.log");
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                processList.add(line);
                System.out.println(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Boolean isException = false;
        List<String> stringList = Lists.newArrayList();
        for (String line : processList) {
            if(StringUtils.isBlank(line.trim())) {
                continue;
            }
            if (line.contains(endString1) || line.contains(endString2)
                || line.contains(endChar1) || line.contains(endChar2)) {
                Integer num = 0;
                num = StringUtils.countMatches(line, endString1) + StringUtils.countMatches(line, endString2);
                if (num > 1) {
                    isException = true;
                    break;
                } else {
                    stringList.add(line);
                }
            }
        }

        LogStruct curLogStruct = null;
        for (String line : stringList) {
//            line = StringUtils.trim(line);
            if (StringUtils.isBlank(line)) {
                continue;
            }

            Integer logLevel = 0;
            if (StringUtils.contains(line, endString2)) {
                Integer index = line.indexOf(endString2);
                logLevel = index / 4 + 1;
            } else if (StringUtils.contains(line, endString1)) {
                Integer index = line.lastIndexOf(endString1);
                logLevel = index / 4 + 1;
            }
            String logFile = "";
            if (StringUtils.contains(line, endChar2)) {
                logFile = line.substring(StringUtils.lastIndexOf(line, endChar2) + 4);
            } else {
                logFile = line.substring(StringUtils.lastIndexOf(line, endChar1) + 4);
            }

            List<LogStruct> logStructList = logLevelMap.get(logLevel);
            if (null == logStructList) {
                logStructList = Lists.newArrayList();
                logLevelMap.put(logLevel, logStructList);
            }

            LogStruct logStruct = new LogStruct();
            curLogStruct = logStruct;
            logStruct.setLogFile(logFile.trim());
            if (logLevel > 1) {
                LogStruct parentLog = curLogLevelMap.get(logLevel - 1);
                parentLog.setIsDir(true);
                List<LogStruct> childDirList = parentLog.getChildDirList();
                if (childDirList == null) {
                    childDirList = Lists.newArrayList();
                    parentLog.setChildDirList(childDirList);
                }
                childDirList.add(logStruct);
                logStruct.setParentDir(parentLog.getPath());
            }
            logStructList.add(logStruct);

            curLogLevelMap.put(logLevel, logStruct);
        }
        if (isException && curLogStruct != null) {
            curLogStruct.setIsDir(true);
        }

        System.out.println(logLevelMap.get(1));

    }

    @Test
    public void test1() {
        BigDecimal bigDecimal = BigDecimal.valueOf(10);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        System.out.println(bigDecimal.compareTo(BigDecimal.valueOf(10.000)));

        String strs = "{\"clusters\":[{\"master\":\"10.177.20.59:5198\",\"slave\":\"10.177.20.63:5198\",\"group\":\"group_1\",\"readWeight\":100,\"writeWeight\":1,\"oldNkv\":false,\"readSlave\":true}]}";
        String[] ids = strs.split(",");
        List<String> list = Lists.newArrayList();
        for (String id : ids) {
            System.out.println(Integer.valueOf(id));
        }

        Set<Integer> set = Sets.newHashSet(1, 209);
        Integer x = 209;
        Integer y = 209;
        System.out.println(set);
        System.out.println(set.contains(y));
        System.out.println(set.contains(x));
        System.out.println(x.hashCode() + " " + y.hashCode());
        System.out.println(x.equals(y));

        Student student = new Student(1, "xxx");
        System.out.println(student.getId());

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
    }

    @Test
    public void test3() throws InterruptedException, Exception {
        int count = 10;
        while (count-- > 0) {
            System.out.println(MillisecondClock.CLOCK.now());
            Thread.sleep(50);
        }
        System.out.println(MillisecondClock.CLOCK.now());
        MillisecondClock.CLOCK.t.interrupt();
        Thread.sleep(1000);
        System.out.println(MillisecondClock.CLOCK.now());
    }

    @Test
    public <T> void test4() {
        String group = "1001";
        System.out.println(group);
        System.out.println(group + "\0");
        char ch = '\0';
        System.out.println(ch);
        System.out.println("1");
        int chi = '1';
        int ch0 = '\0';
        System.out.println(chi);
        System.out.println(ch0);
        System.out.println('1' - '\0');

        String x = String.class.cast("123");
        System.out.println(x);

        int y = 1;
        System.out.printf("%x, %d\n", y, y);
        y = 0x22;
        System.out.printf("%x, %d\n", y, y);
    }

    @Test
    public <T> void test5() {
        List<Integer> person = JSONObject.parseObject("[\"0\",\"50\",\"80\",\"100\",\"200\",\"500\"]", new TypeReference<List<Integer>>() {
        });
        System.out.println(person);

        Long l = JSONObject.parseObject("100", new TypeReference<Long>() {
        });
        System.out.println(l);

        String s = JSONObject.parseObject("-1", new TypeReference<String>() {
        });
        System.out.println(s);

        System.out.println(TT.JAVAAPP.toString());

        JSONObject jsonObject = JSON.parseObject("{\n" +
            "    \"id\": 12294,\n" +
            "    \"namespace\": {\n" +
            "        \"id\": 5519,\n" +
            "        \"name\": \"solo\",\n" +
            "        \"path\": \"solo\",\n" +
            "        \"kind\": \"group\",\n" +
            "        \"full_path\": \"haitao-arch/solo\",\n" +
            "        \"parent_id\": 3780\n" +
            "    },\n" +
            "    \"permissions\": {\n" +
            "        \"project_access\": {\n" +
            "            \"access_level\": 40,\n" +
            "            \"notification_level\": 3\n" +
            "        },\n" +
            "        \"group_access\": null\n" +
            "    }\n" +
            "}");

        Object o = jsonObject.get("permission");
        System.out.println(o);
    }

    @Test
    public <T> void test6() {
        byte[] bytes = "".getBytes();
        System.out.println(bytes);
    }

    @Test
    public void test7() {
        Pattern pattern = Pattern.compile("(ssh://g.hz.netease.com/).*");
        System.out.println(pattern.matcher("ssh://g.hz.neteae.com/xxx").matches());
//        "hell".startsWith()

        User user = new User("xxx", "xxx");
        user.setName("hello");
        user.setCode("world");
        System.out.println(user);
    }

    @Test
    public void test8() throws IOException {

        System.out.println(Arrays.toString(ByteBuffer.allocate(4).putInt(10).array()));

        byte[] str = "hello world!, hello world!".getBytes();
        byte[] desStr = NkvUtil.decompress(str);

        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(desStr));

        str = new byte[9000];
        str[0] = 1;
        NkvUtil.CompressedValue compressedValue = NkvUtil.compress(str);
//         = new byte[compressedValue.getSize()];
        ByteArrayOutputStream bio = new ByteArrayOutputStream();
        bio.write(ByteBuffer.allocate(4).putInt(NkvUtil.FAST_COM_CODE).array());
        bio.write(ByteBuffer.allocate(4).putInt(compressedValue.getOlength()).array());
        bio.write(compressedValue.getValue());
        byte[] compresStr = bio.toByteArray();

        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(compresStr));

    }

    @Test
    public void test9() {
        Map<String, String> map1 = Maps.newHashMap();
        Map<String, String> map2 = Maps.newHashMap();

        map1.put("key1", "hello");
        map1.put("key2", "world");

        map2.put("key2", "world");
        map2.put("key1", "hello");

        String str1 = JSON.toJSONString(map1);
        String str2 = JSON.toJSONString(map2);

        JSONObject.parseObject(str2);

        System.out.println(StringUtils.equals(str1, str2));
    }

    @Test
    public void test10() {
        String[] strArray = "asdfasdfas/asfasfasd/asdfasfasd".split("/");

        System.out.println(Arrays.toString(strArray));

        System.out.println(TT.JAVAAPP.getName());
    }

    @Test
    public void stopWatch() {
        try {
            Stopwatch watch = Stopwatch.createStarted();
            System.out.println("xxx");
            long l = watch.stop().elapsed(TimeUnit.MILLISECONDS);
            System.out.println(l);
        } catch (Exception e) {
            System.out.println("l");
        }
    }

    @Test
    public void test11() {
        short x = Short.MAX_VALUE;
        int y = x;
        y = y + 1000;
        System.out.println(y);
        System.out.println((short) y);
        System.out.println();

        y = (short) y;
        System.out.println(y);

    }

    @Test
    public void test12() {
        System.out.println(90 * 24 * 60 * 60 * 1000);
        System.out.println(90L * 24 * 60 * 60 * 1000);

        String test = "adfb ";
        String test2 = StringUtils.trim(test);
        System.out.println(test2);
        System.out.println(test);
    }

    @Test
    public void test13() {
        JSONObject jsonObject =
            JSONObject.parseObject("{\"deploy\":{\"platcommon\":{\"httpPort\":{\"required\":true,\"value\":8080}},\"uncommon\":{\"xmx\":{\"value\":\"4096\"},\"maxPerm\":{\"value\":\"256\"},\"jvmExtra\":{\"value\":\"\"},\"xms\":{\"value\":\"4096\"}}},\"privateFileList\":[],\"request\":{\"check\":{\"retry\":5,\"sleep\":10,\"timeout\":20},\"healthPort\":\"\",\"offline\":{\"retry\":5,\"sleep\":10,\"timeout\":20},\"online\":{\"retry\":5,\"sleep\":10,\"timeout\":20},\"status\":{\"retry\":5,\"sleep\":10,\"timeout\":20},\"stop\":{\"retry\":5,\"sleep\":10,\"timeout\":20}},\"zelda\":{\"limit\":{\"cpu\":4.0,\"memory\":1,\"unit\":\"G\"},\"logPath\":\"/home/appops/tomcat/logs/\",\"request\":{\"cpu\":1.0,\"memory\":512,\"unit\":\"M\"}}}");
        System.out.println(jsonObject);
    }

    @Test
    public void test14() {

        Map<Integer, List<LogStruct>> logLevelMap = Maps.newHashMap();
        Map<Integer, LogStruct> curLogLevelMap = Maps.newHashMap();

        String str = ".\n" +
            "├── 12306\n" +
            "│   ├── Dockerfile\n" +
            "│   ├── README.md\n" +
            "│   ├── UnitTest\n" +
            "│   │   ├── TestAll.py\n" +
            "│   │   └── __init__.py\n" +
            "│   ├── Update.md\n" +
            "│   ├── __init__.py\n" +
            "│   ├── agency\n" +
            "│   │   ├── __init__.py\n" +
            "│   │   ├── agency_tools.py\n" +
            "│   │   ├── cdn_utils.py\n" +
            "│   │   └── proxy_list\n" +
            "│   ├── cdn_list\n" +
            "│   ├── config\n" +
            "│   │   ├── AutoSynchroTime.py\n" +
            "│   │   ├── TicketEnmu.py\n" +
            "│   │   ├── __init__.py\n" +
            "│   │   ├── __init__.pyc\n" +
            "│   │   ├── configCommon.py\n" +
            "│   │   ├── emailConf.py\n" +
            "│   │   ├── emailConf.pyc\n" +
            "│   │   ├── logger.py\n" +
            "│   │   ├── pushbearConf.py\n" +
            "│   │   ├── ticketConf.py\n" +
            "│   │   ├── ticketConf.pyc\n" +
            "│   │   ├── ticket_config.yaml\n" +
            "│   │   └── urlConf.py\n" +
            "│   ├── damatuCode\n" +
            "│   │   ├── __init__.py\n" +
            "│   │   ├── damatuWeb.py\n" +
            "│   │   └── ruokuai.py\n" +
            "│   ├── docker-compose.yml\n" +
            "│   ├── docker.sh\n" +
            "│   ├── init\n" +
            "│   │   ├── __init__.py\n" +
            "│   │   ├── __init__.pyc\n" +
            "│   │   ├── login.py\n" +
            "│   │   ├── select_ticket_info.py\n" +
            "│   │   └── select_ticket_info.pyc\n" +
            "│   ├── inter\n" +
            "│   │   ├── AutoSubmitOrderRequest.py\n" +
            "│   │   ├── CheckOrderInfo.py\n" +
            "│   │   ├── CheckRandCodeAnsyn.py\n" +
            "│   │   ├── CheckUser.py\n" +
            "│   │   ├── ConfirmSingleForQueue.py\n" +
            "│   │   ├── ConfirmSingleForQueueAsys.py\n" +
            "│   │   ├── GetPassCodeNewOrderAndLogin.py\n" +
            "│   │   ├── GetPassengerDTOs.py\n" +
            "│   │   ├── GetQueueCount.py\n" +
            "│   │   ├── GetQueueCountAsync.py\n" +
            "│   │   ├── GetRandCode.py\n" +
            "│   │   ├── GetRepeatSubmitToken.py\n" +
            "│   │   ├── LiftTicketInit.py\n" +
            "│   │   ├── Query.py\n" +
            "│   │   ├── QueryOrderWaitTime.py\n" +
            "│   │   ├── SubmitOrderRequest.py\n" +
            "│   │   └── __init__.py\n" +
            "│   ├── myException\n" +
            "│   │   ├── PassengerUserException.py\n" +
            "│   │   ├── UserPasswordException.py\n" +
            "│   │   ├── __init__.py\n" +
            "│   │   ├── balanceException.py\n" +
            "│   │   ├── ticketConfigException.py\n" +
            "│   │   ├── ticketIsExitsException.py\n" +
            "│   │   └── ticketNumOutException.py\n" +
            "│   ├── myUrllib\n" +
            "│   │   ├── MySocketUtils.py\n" +
            "│   │   ├── __init__.py\n" +
            "│   │   └── httpUtils.py\n" +
            "│   ├── requirements.txt\n" +
            "│   ├── run.py\n" +
            "│   ├── station_name.txt\n" +
            "│   ├── tkcode.png\n" +
            "│   ├── tmp\n" +
            "│   │   ├── __init__.py\n" +
            "│   │   └── log\n" +
            "│   │       └── __init__.py\n" +
            "│   ├── uml\n" +
            "│   │   ├── uml.png\n" +
            "│   │   ├── wx.jpeg\n" +
            "│   │   └── zfb.jpeg\n" +
            "│   └── utils\n" +
            "│       ├── __init__.py\n" +
            "│       └── timeUtil.py\n" +
            "├── a\n" +
            "├── data.txt\n" +
            "├── replace.py\n" +
            "└── rk\n" +
            "    └── aa\n" +
            "        └── a";
//        String str = "approot/logs\n├── catalina.2019-05-29.log\n├── catalina.2019-06-02.log\n├── catalina_2019-05-29.log\n├── catalina_2019-05-31.log\n├── catalina_2019-06-02.log\n├── disconf\n│   └── download\n│       ├── files\n│       └── tmp\n│           └── files\n├── disconf.log\n├── gc.log\n├── host-manager.2019-05-29.log\n├── host-manager.2019-06-02.log\n├── localhost.2019-05-29.log\n├── localhost.2019-06-02.log\n├── log\n│   ├── error.log\n│   ├── info.log\n│   └── pressure.log\n├── manager.2019-05-29.log\n├── manager.2019-06-02.log\n└── rpc\n    └── kaola-test-demo\n        ├── common-default.log\n        ├── common-error.log\n        ├── rpc-exception.log\n        ├── rpc-monitor.log\n        ├── rpc-operation.log\n        └── rpc-registry.log\n\n8 directories, 22 files";
        String [] strs = str.split("\n");
        for (String line : strs) {
            line = StringUtils.trim(line);
            if (StringUtils.isBlank(line)) {
                continue;
            }
            System.out.println(line);

//            Integer logLevel = StringUtils.countMatches(line, "├──") + StringUtils.countMatches(line, "└──")
//                + StringUtils.countMatches(line, "   ") + StringUtils.count;
            Integer logLevel = 0;

            if (StringUtils.contains(line, "└──")) {
                Integer index = line.indexOf("└──");
                logLevel = index / 4 + 1;
            } else if (StringUtils.contains(line, "├──")) {
                Integer index = line.lastIndexOf("├──");
                logLevel = index / 4 + 1;
            }
            String logFile = "";
            if (StringUtils.contains(line, "└")) {
                logFile = line.substring(StringUtils.lastIndexOf(line, "└") + 4);
            } else {
                logFile = line.substring(StringUtils.lastIndexOf(line, "├") + 4);
            }

            List<LogStruct> logStructList = logLevelMap.get(logLevel);
            if (null == logStructList) {
                logStructList = Lists.newArrayList();
                logLevelMap.put(logLevel, logStructList);
            }

            LogStruct logStruct = new LogStruct();
            logStruct.setLogFile(logFile);
            if (logLevel > 1) {
                LogStruct parentLog = curLogLevelMap.get(logLevel -  1);
                parentLog.setIsDir(true);
                List<LogStruct> childDirList = parentLog.getChildDirList();
                if (childDirList == null) {
                    childDirList = Lists.newArrayList();
                    parentLog.setChildDirList(childDirList);
                }
                childDirList.add(logStruct);
                logStruct.setParentDir(parentLog.getPath());
            }
            logStructList.add(logStruct);

            curLogLevelMap.put(logLevel, logStruct);
        }

        int level = 1;
        while (logLevelMap.get(level) != null) {
            List<LogStruct> logStructList = logLevelMap.get(level);
            for (LogStruct logStruct : logStructList) {
                System.out.print(logStruct);
                System.out.print(" ");
            }
            System.out.println();
            level++;
        }
    }

    enum TT {
        UNKNOWN(-1, "unknown"),
        JAVAAPP(1, "java app"),
        JAVAWEB(2, "java web"),
        STATIC_RESOURCE(3, "静态资源"),
        NODEJS(4, "nodeJs"),
        SELF_DEFINE(5, "自定义"),
        PHP(6, "PHP"),
        PYTHON(7, "python");


        @Getter
        Integer type;

        @Getter
        String name;

        TT(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }
}
