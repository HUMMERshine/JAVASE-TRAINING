package priv.lst.arch.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lishutao on 2019-09-17.
 *
 * @author lishutao
 * @date 2019-09-17
 */
public class ConnectionWatcher implements Watcher {
    private CountDownLatch connectedSignal = new CountDownLatch(1);

    private static final int SESSION_TIMEOUT = 5000;

    ZooKeeper zk;

    public void connect(String hosts) throws InterruptedException, IOException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        connectedSignal.await();
        System.out.println("connect!");
    }

    @Override
    public void process(WatchedEvent event) {
        if(event.getState() == Event.KeeperState.SyncConnected) {
            connectedSignal.countDown();
        }
    }

    public void createNode(String nodeName, String nodeValue)
        throws KeeperException, InterruptedException {

        String path = "/" + nodeName;

        String createPath = zk.create(path, nodeValue.getBytes(),
            ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println("Created znode:"+createPath);
    }

    public void createChildNode(String parentNode, String childNode, String nodeValue)
        throws KeeperException, InterruptedException {

        String path = "/" + parentNode;

        String createPath = zk.create(path, nodeValue.getBytes(),
            ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println("Created znode:"+createPath);
    }

    public void deleteNode(String nodeName)
        throws KeeperException, InterruptedException {

        String path = "/" + nodeName;

//        Stat stat = new Stat();
//        zk.getData(path, false, stat);

        zk.delete(path, -1);

        System.out.println("delete znode:"+ path);
    }

    public void getValue(String nodeName) throws KeeperException, InterruptedException {

        String path = "/" + nodeName;

        byte[] value = zk.getData(path, false, null);

        System.out.printf("[%s,%s]", path, new String(value));
    }

    public void close() throws InterruptedException {
        zk.close();
    }
}
