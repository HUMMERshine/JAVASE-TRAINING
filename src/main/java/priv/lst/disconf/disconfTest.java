package priv.lst.disconf;

import com.baidu.disconf.client.config.DisconfClientConfig;
import com.baidu.disconf.client.service.ConfigService;
import com.baidu.disconf.client.service.factory.ConfigServiceFactory;
import com.netease.haitao.rdb.RdbClientConfig;
import com.netease.haitao.rdb.RdbPoolConfig;
import com.netease.haitao.rdb.impl.DisconfCallbackImpl;
import com.netease.haitao.rdb.impl.HessianImpl;
import com.netease.haitao.rdb.impl.IsolationImpl;
import com.netease.haitao.rdb.impl.RdbClientImpl;

/**
 * Created by lishutao on 2019/4/9.
 *
 * @author lishutao
 * @date 2019/4/9
 */
public class disconfTest {
    public static void main(String[] args) throws Exception {

        DisconfClientConfig disconfClientConfig = new DisconfClientConfig();
//        disconfClientConfig.setZkHost("10.194.68.207:2181,10.194.68.209:2181,10.194.68.205:2181,10.194.68.208:2181,10.194.68.206:2181");
        disconfClientConfig.setZkHost("10.194.68.207:2181,10.194.68.209:2181,10.194.68.205:2181,10.194.68.208:2181,10.194.68.206:2181");
        disconfClientConfig.setEnv("onlinejd");
//        DisClientConfig

        //disconf初始化
        ConfigServiceFactory configServiceFactory = new ConfigServiceFactory(disconfClientConfig);
        configServiceFactory.init();


        //disconf动态配置回调
        DisconfCallbackImpl soloConfigCallBack = new DisconfCallbackImpl();
        ConfigService configService = configServiceFactory.getInstance("solo_rdb", soloConfigCallBack);


        /**
         *  solo-rdb配置项
         */
        RdbPoolConfig rdbPoolConfig = new RdbPoolConfig();
        rdbPoolConfig.setMaxTotal(15);
        rdbPoolConfig.setMaxIdle(10);
        rdbPoolConfig.setMinIdle(5);
        rdbPoolConfig.setMaxWaitMillis(500);

        //采用默认序列化方式，如需自定义序列化方式要实现SerializeBase接口。
        HessianImpl hessian = new HessianImpl();

        RdbClientConfig rdbClientConfig = new RdbClientConfig();
        rdbClientConfig.setTimeout(500);
        rdbClientConfig.setConnectionTimeout(500);
        rdbClientConfig.setRdbPoolConfig(rdbPoolConfig);
        rdbClientConfig.setSerializeBase(hessian);
        rdbClientConfig.setKeySerializeBase(hessian);

        //测试环境要设置key的环境前缀，envname自己填写
        IsolationImpl isolation = new IsolationImpl();
        isolation.setEnvName("online");
        // isolation.setNeedIsolation(true);
        //  isolation.setIsTestEnv(true);
        //配置压测前缀，一般不需要
        //PerformanceIsolationFlagGeneratorImpl performanceIsolationFlagGenerator = new PerformanceIsolationFlagGeneratorImpl();
        //isolation.setPerformanceIsolationFlagGenerator(performanceIsolationFlagGenerator);

        //客户端初始化
        RdbClientImpl rdbClient = new RdbClientImpl();
        rdbClient.setDisconfCallback(soloConfigCallBack);
        rdbClient.setRdbClientConfig(rdbClientConfig);
        //此处填写申请时给定的clusterKey
        rdbClient.setClusterKey("common_fix_platform_level1");
        rdbClient.setIsolationImpl(isolation);
        rdbClient.setConfigService(configService);
        rdbClient.init();

        //rdb使用demo：
//        rdbClient.set("likeguo_key", 90);
//        rdbClient.get(soloKey);
    }
}
