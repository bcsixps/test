package com.panshuai.lock.finegrained;
import java.util.concurrent.CyclicBarrier;

public class KeyLockTest{

	static KeyLockVertix keyLockVertix = new KeyLockVertix();
	
	public static void main(String[] args) {
    CyclicBarrier barrier = new CyclicBarrier(10);
		for(int i=0;i<10;i++){
			System.out.println(i);
			new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						barrier.await();
						
						keyLockVertix.receive(0);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		for(int i=0;i<10;i++){
			System.out.println(i);
			new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						barrier.await();
						
						keyLockVertix.receive(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}
}
	
