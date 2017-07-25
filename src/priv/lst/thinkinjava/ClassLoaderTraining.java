package priv.lst.thinkinjava;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * 
 * @author lst-bytedance
 * @link http://www.importnew.com/23742.html
 */

/*
 * ClassLoader源码分析：
public Class<?> loadClass(String name)throws ClassNotFoundException {
        return loadClass(name, false);
}
 
protected synchronized Class<?> loadClass(String name, boolean resolve)throws ClassNotFoundException {
        // 首先判断该类型是否已经被加载
        Class c = findLoadedClass(name);
        if (c == null) {
            //如果没有被加载，就委托给父类加载或者委派给启动类加载器加载
            try {
                if (parent != null) {
                     //如果存在父类加载器，就委派给父类加载器加载
                    c = parent.loadClass(name, false);
                } else {
                //如果不存在父类加载器，就检查是否是由启动类加载器加载的类，通过调用本地方法native Class findBootstrapClass(String name)
                    c = findBootstrapClass0(name);
                }
            } catch (ClassNotFoundException e) {
             // 如果父类加载器和启动类加载器都不能完成加载任务，才调用自身的加载功能
                c = findClass(name);
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        return c;
    }
 */
public class ClassLoaderTraining extends ClassLoader{
	public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        
        ClassLoaderTraining classLoader = new ClassLoaderTraining();
        classLoader.setRoot("/Users/lst-bytedance/code");
 
        Class<?> testClass = null;
        try {
            testClass = classLoader.loadClass("Hello");
            Object object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
	}
	
	private String root;
	 
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }
 
    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public String getRoot() {
        return root;
    }
 
    public void setRoot(String root) {
        this.root = root;
    }
}
