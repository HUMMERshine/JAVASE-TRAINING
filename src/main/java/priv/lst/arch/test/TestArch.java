package priv.lst.arch.test;

import com.baidu.disconf.client.service.ConfigService;
import com.baidu.disconf.client.service.factory.ConfigServiceFactory;
import com.netease.haitao.rdb.RdbClientConfig;
import com.netease.haitao.rdb.RdbPoolConfig;
import com.netease.haitao.rdb.SoloKey;
import com.netease.haitao.rdb.SoloValue;
import com.netease.haitao.rdb.impl.DisconfCallbackImpl;
import com.netease.haitao.rdb.impl.HessianImpl;
import com.netease.haitao.rdb.impl.IsolationImpl;
import com.netease.haitao.rdb.impl.RdbClientImpl;

import java.util.UUID;

/**
 * Created by lishutao on 2018/5/13.
 *
 * @author lishutao
 * @date 2018/5/13
 */
public class TestArch {
    public static void main(String[] args) throws Exception {
        //配置disconf
        ConfigServiceFactory configServiceFactory = new ConfigServiceFactory();

        configServiceFactory.init();
        DisconfCallbackImpl soloConfigCallBack = new DisconfCallbackImpl();
        ConfigService configService = configServiceFactory.getInstance("solo_rdb",soloConfigCallBack);

        //solo-rdb
        HessianImpl hessian = new HessianImpl();
        RdbPoolConfig rdbPoolConfig = new RdbPoolConfig();
        rdbPoolConfig.setMaxTotal(15);
        rdbPoolConfig.setMaxIdle(10);
        rdbPoolConfig.setMinIdle(5);
        rdbPoolConfig.setMaxWaitMillis(500);

        RdbClientConfig rdbClientConfig = new RdbClientConfig();
        rdbClientConfig.setClientName("test");
        rdbClientConfig.setTimeout(500);
        rdbClientConfig.setConnectionTimeout(500);
        rdbClientConfig.setRdbPoolConfig(rdbPoolConfig);
        rdbClientConfig.setSerializeBase(hessian);
        rdbClientConfig.setKeySerializeBase(hessian);

//        PerformanceIsolationFlagGeneratorImpl performanceIsolationFlagGenerator = new PerformanceIsolationFlagGeneratorImpl();

        IsolationImpl isolation = new IsolationImpl();
//        isolation.setAppName("kaola");
        isolation.setEnvName("test");
        isolation.setNeedIsolation(true);
        isolation.setIsTestEnv(true);
//        isolation.setPerformanceIsolationFlagGenerator(performanceIsolationFlagGenerator);

        RdbClientImpl rdbClient = new RdbClientImpl();
        rdbClient.setDisconfCallback(soloConfigCallBack);
        rdbClient.setRdbClientConfig(rdbClientConfig);
        rdbClient.setClusterKey("self_test_level1");
        rdbClient.setIsolationImpl(isolation);
        rdbClient.setConfigService(configService);
        rdbClient.init();

        //test
        SoloKey soloKey = getKey(SoloKey.ValueTypeEnum.STRING);
        SoloValue soloValue = getValue(SoloKey.ValueTypeEnum.STRING);
        System.out.println(soloValue.getString());
        rdbClient.set(soloKey, soloValue);
        String value = rdbClient.get(soloKey);
        System.out.println(value);
    }

    public static SoloKey getKey(SoloKey.ValueTypeEnum valueTypeEnum) {
        SoloKey key;
        if (valueTypeEnum.equals(SoloKey.ValueTypeEnum.STRING)) {
            key = SoloKey.build(UUID.randomUUID().toString(), valueTypeEnum, false);
        } else if (valueTypeEnum.equals(SoloKey.ValueTypeEnum.OBJECT)) {
            key = SoloKey.build(UUID.randomUUID(), valueTypeEnum, true);
        } else {
            key = SoloKey.build(UUID.randomUUID().toString().getBytes(), valueTypeEnum);
        }

        return key;
    }

    public static SoloValue getValue(SoloKey.ValueTypeEnum valueTypeEnum) {
        SoloValue value;
        if (valueTypeEnum.equals(SoloKey.ValueTypeEnum.STRING)) {
            value = SoloValue.build(UUID.randomUUID().toString(), false);
        } else if (valueTypeEnum.equals(SoloKey.ValueTypeEnum.OBJECT)) {
            value = SoloValue.build(UUID.randomUUID(), true);
        } else {
            value = SoloValue.build(UUID.randomUUID().toString().getBytes());
        }
        return value;
    }
}
