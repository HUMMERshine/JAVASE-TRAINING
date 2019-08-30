import com.baidu.disconf.client.service.ConfigService;
import com.baidu.disconf.client.service.factory.ConfigServiceFactory;
import com.google.common.collect.Lists;
import com.netease.haitao.solo.impl.DefaultDisconfCallback;
import com.netease.haitao.solo.impl.DefaultNamespaceConfig;
import com.netease.haitao.solo.impl.MultiSoloManagerImpl;
import com.netease.haitao.solo.monitor.SentrySoloMonitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class testit3 {
    public static void main(String[] args) throws Exception {

        ConfigServiceFactory configServiceFactory = new ConfigServiceFactory();
        configServiceFactory.init();

        DefaultDisconfCallback soloConfigCallBack = new DefaultDisconfCallback();
        ConfigService soloClusterService = configServiceFactory.getInstance("solo_cluster", soloConfigCallBack);

        DefaultNamespaceConfig defaultNamespaceConfig = new DefaultNamespaceConfig();
        defaultNamespaceConfig.setNamespace(100); //namespace（必填）使用申请时给定的ns
        defaultNamespaceConfig.setExpireSeconds(60 * 60 * 24);
        defaultNamespaceConfig.setIsTestEnvironment(true);//test环境为true
        defaultNamespaceConfig.setEnvironmentName("test_env_name");
        defaultNamespaceConfig.setUseIsolation(true);//test环境下为true时会添加前缀， 是否需要环境隔离（参考**环境隔离**）

        SentrySoloMonitor soloMonitor = new SentrySoloMonitor();
        MultiSoloManagerImpl soloService = new MultiSoloManagerImpl();
        soloService.setClusterKey("");//申请时给定的clusterKey
        soloService.setSoloConfigServer(soloClusterService);
        soloService.setDisconfCallback(soloConfigCallBack);
        soloService.setUseCompress(true);
        List<DefaultNamespaceConfig> list = Lists.newArrayList();
        list.add(defaultNamespaceConfig);
        soloService.setNamespaceConfigs(list);
//        soloService.setSoloMonitor(soloMonitor);
        soloService.init();
    }


}
