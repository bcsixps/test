package com.panshuai.lock.finegrained;
import java.util.concurrent.CyclicBarrier;

public class StripedLockTest{

	static StripedVertix keyLockVertix = new StripedVertix();
	
	public static void main(String[] args) {
    CyclicBarrier barrier = new CyclicBarrier(20);
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
	
