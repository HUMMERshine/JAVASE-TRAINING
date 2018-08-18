package priv.lst.arch.redis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.alibaba.fastjson.JSONArray;
import org.junit.Before;
import org.junit.Test;

import net.mindview.util.Pair;
import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisDemo {
    private Jedis jedis;
    JedisPool pool;
    
    @Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);
        pool = new JedisPool(new JedisPoolConfig(), "localhost");
        jedis = pool.getResource();
//        pool.close();
        //权限认证
        //jedis.auth("admin");  
    }
    
    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        //-----添加数据----------  
        jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
        System.out.println(jedis.get("name"));//执行结果：xinxin  
        
        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name")); 
        
        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","liuling","age","23","qq","476777XXX");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
        
    }
    
    /**
     * redis操作Map
     */
    @Test
    public void testMap() {
        //-----添加数据----------  
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user",map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List  
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数  
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);  
  
        //删除map中的某个键值  
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null  
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2 
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true  
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value 
  
        Iterator<String> iter=jedis.hkeys("user").iterator();  
        while (iter.hasNext()){  
            String key = iter.next();  
            System.out.println(key+":"+jedis.hmget("user",key));  
        }  
    }
    
    /** 
     * jedis操作List 
     */  
    @Test  
    public void testList(){  
        //开始前，先移除所有的内容  
        jedis.del("java framework");  
        System.out.println(jedis.lrange("java framework",0,-1));  
        //先向key java framework中存放三条数据  
        jedis.lpush("java framework","spring");  
        jedis.lpush("java framework","struts");  
        jedis.lpush("java framework","hibernate");  
        //再取出所有数据jedis.lrange是按范围取出，  
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有  
        System.out.println(jedis.lrange("java framework",0,-1));  
        
        jedis.del("java framework");
        jedis.rpush("java framework","spring");  
        jedis.rpush("java framework","struts");  
        jedis.rpush("java framework","hibernate"); 
        System.out.println(jedis.lrange("java framework",0,-1));
    }  
    
    /** 
     * jedis操作Set 
     */  
    @Test  
    public void testSet(){  
        //添加  
        jedis.sadd("user","liuling");  
        jedis.sadd("user","xinxin");  
        jedis.sadd("user","ling");  
        jedis.sadd("user","zhangxinxin");
        jedis.sadd("user","who");  
        //移除noname  
        jedis.srem("user","who");  
        System.out.println(jedis.smembers("user"));//获取所有加入的value  
        System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素  
        System.out.println(jedis.srandmember("user"));  
        System.out.println(jedis.scard("user"));//返回集合的元素个数  
    }  
  
    @Test  
    public void test() throws InterruptedException {  
        //jedis 排序  
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）  
        jedis.del("a");//先清除数据，再加入数据进行测试  
        jedis.rpush("a", "1");  
        jedis.lpush("a","6");  
        jedis.lpush("a","3");  
        jedis.lpush("a","9");  
        System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]  
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果  
        System.out.println(jedis.lrange("a",0,-1));  
    }  
    
    @Test
    public void testRedisPool() {
        jedis.set("newname", "中文测试");
        System.out.println(jedis.get("newname"));
        
        Map<String, Pair<String, String>> map = new HashMap<>();
        map.put("name", new Pair("hello","world"));
        map.put("age", new Pair("hello2","world2"));
        map.put("qq", new Pair("hello3","world3"));
        //jedis.hmset("user",map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List  
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数  
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);  
    }
    
    @Test
	public void testObject() {
		List<TestUser> lists = new ArrayList<>();
		lists.add(new TestUser("hello",3));
		lists.add(new TestUser("hello1",4));
		lists.add(new TestUser("hello2",5));
		
		TestUser userA = lists.get(0);
		
		ObjectsTranscoder<TestUser> objTranscoder =  new ObjectsTranscoder<>();
		
		byte[] result1 = objTranscoder.serialize(userA);
		jedis.set("userA".getBytes(), result1);
		jedis.set("userB".getBytes(), result1);
		jedis.set("userC".getBytes(), result1);
		Set<String> set = jedis.keys("*");
		for(String s : set){
			System.out.println(s);
			jedis.del(s);
		}
		jedis.del("userA".getBytes());
		byte[] bytes = jedis.get("userA".getBytes());
		if(bytes == null){
			System.out.println("********");
			return;
		}
		System.out.println(bytes.length);
		System.out.println(Arrays.toString(bytes));
		TestUser userAa = objTranscoder.deserialize(bytes);
		
		System.out.println(userAa.getName() + "\t" + userAa.getAge());
	}
    
    @Test
	public void testObjectList() {
    	List<TestUser> lists = new ArrayList<>();
		lists.add(new TestUser("hello",3));
		lists.add(new TestUser("hello1",4));
		lists.add(new TestUser("hello2",5));		

		ListTranscoder<TestUser> listTranscoder = new ListTranscoder<>();
		
		byte[] result1 = listTranscoder.serialize(lists);
		
		jedis.set("list".getBytes(), result1);
		byte [] bytes = jedis.get("list".getBytes());
		if(bytes == null){
			System.out.println("**********");
		}
		System.out.println(bytes.length + Arrays.toString(bytes));
		List<TestUser> results = listTranscoder.deserialize(bytes);
	
		for (TestUser user : results) {
			System.out.println(user.getName() + "\t" + user.getAge());
		}

        String jsonList = JSONObject.toJSONString(lists);
		jedis.set("jsonList", jsonList);
		String jsonGetList = jedis.get("jsonList");
//		List<TestUser> resultList = JSONObject.parseObject(jsonGetList, List.class);
        List<TestUser> resultList = JSONArray.parseArray(jsonGetList, TestUser.class);
        for (TestUser user : resultList) {
            System.out.println(user.getName() + "\t" + user.getAge());
        }
	}

    @Test
    public void incrTest2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            jedis.incr("incrNum");
        }
        System.out.println(jedis.get("incrNum"));

    }

    @Test
    public void incrTest() throws InterruptedException {
        /**
         * 测试线程安全
         */
        jedis.del("incrNum");
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        //final CountDownLatch countDownLatch = new CountDownLatch(10);
        Lock lock=new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0 ; i < 10 ; i ++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    //每个线程增加1000次，每次加1
                    for(int j = 0 ; j < 1000 ; j ++){
//                        atomicInteger.incrementAndGet();
                        lock.lock();
                        jedis.incr("incrNum");
                        lock.unlock();
                    }

                    System.out.println(jedis.get("incrNum"));
                   // countDownLatch.countDown();

                }
            });
        }
        Thread.sleep(5 * 1000);
       // countDownLatch.await();
        System.out.println(jedis.get("incrNum"));
        System.out.println(atomicInteger);
        //pool.close();
    }

}
