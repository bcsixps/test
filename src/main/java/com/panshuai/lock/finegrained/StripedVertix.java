package com.panshuai.lock.finegrained;

import java.util.concurrent.locks.Lock;

import com.google.common.util.concurrent.Striped;

public class StripedVertix {

    private static final Striped<Lock> striped = Striped.lazyWeakLock(1024*2);


    public void receive(Integer key) {
    	long startTime = System.currentTimeMillis();
    	
       
        //加锁 demo
    	Lock lock = striped.get(key);
    	lock.lock();
        try {
        	Thread.sleep(1000);
        	System.out.println("key="+key+"  " +(System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	lock.unlock();
        }

    }

   
}
