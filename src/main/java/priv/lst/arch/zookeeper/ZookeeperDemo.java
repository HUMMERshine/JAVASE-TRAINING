package priv.lst.arch.zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * Created by lishutao on 2019-09-17.
 *
 * @author lishutao
 * @date 2019-09-17
 */
public class ZookeeperDemo {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ConnectionWatcher connectionWatcher = new ConnectionWatcher();
        connectionWatcher.connect("127.0.0.1:2182");

        connectionWatcher.createNode("lishutao", "lishutao");
//        connectionWatcher.deleteNode("lishutao");
        connectionWatcher.createNode("lishutao/test", "lishutao");
    }
}
