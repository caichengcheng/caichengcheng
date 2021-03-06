package collection;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;
import org.junit.Test;

import javax.xml.transform.Source;
import java.lang.ref.WeakReference;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by caichengcheng
 * date:2019-03-19
 */
public  class MyMap {
    @Test
    public void test1(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();

//        MyMap a = null ;
//        MyMap b = null ;
//        System.out.println(a == b);

        ReentrantLock lock = new ReentrantLock(false);
        for(int i=0;i<3;i++){
            Thread t = new Thread(()->{
                lock.lock();
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }catch (Exception e){
                    e.printStackTrace();
                }
                lock.unlock();

            });
            t.setName("thread i="+i);
            t.start();
//            AtomicInteger
        }

    }

    @Test
    public void test2(){
        //测试weakhashmap
        WeakHashMap<String, Object> weakHashMap = new WeakHashMap<>();
        WeakReference weakReference = new WeakReference(new Object());
        System.out.println("weak ref before gc："+ weakReference.get());
        weakHashMap.put(new String(),new Object());
        System.out.println(weakHashMap.size());
        System.gc();
        System.out.println("weak ref after gc："+ weakReference.get());
        System.out.println(weakHashMap.size());
    }

    public static void main(String[] args) {
        HashMap<Object, Object> m1 = new HashMap<>(13);
        System.out.println(m1.size());
        m1.put(1,1);
        System.out.println(m1.size());
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();
        s.add("a");
        integers.add(1);
        System.out.println(integers.get(0).getClass());
        System.out.println(integers.getClass());
        System.out.println(s.getClass());


    }



}
