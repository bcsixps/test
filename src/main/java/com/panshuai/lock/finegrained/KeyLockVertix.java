package com.panshuai.lock.finegrained;


public class KeyLockVertix {



    private final KeyLock<Integer> lock = new KeyLock<>();


    public void receive(Integer key) {
    	long startTime = System.currentTimeMillis();
       
        //加锁 demo
        lock.lock(key);
        try {
        	Thread.sleep(1000);
        	System.out.println(System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	lock.unlock(key);
        }

    }

   
}
