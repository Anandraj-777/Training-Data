package Employee;

import java.util.stream.IntStream;

public class ThreadDemo {

	public static void main(String[] args) {

//		Runnable runnable = () -> {
//			IntStream.range(1, 10)
////			 .forEach(System.out::println);
////		 };
////		 
////		 Thread thread = new Thread(runnable);
////		 thread.start();
////		 
////		 Thread.getAllStackTraces().forEach((k,v)-> {
////			 System.out.println(k);
////		 });
			
			Runnable runnable = () -> {
				IntStream.range(1, 10)
					.forEach((e) -> {
						try {
							Thread.sleep(1000);
							System.out.println(e + Thread.currentThread().getName()+ " (Priority:" + Thread.currentThread().getPriority()+ ")");
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}

					});
		};

//		   Thread thread = new Thread(runnable);
//		   thread.start();
//		   Thread thread2 = new Thread(runnable);
//		   thread2.start();
//		   Thread thread3 = new Thread(runnable);
//		   thread3.start();

//		Thread thread = new Thread(runnable);
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Thread thread2 = new Thread(runnable);
//		try {
//			thread2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		Thread thread3 = new Thread(runnable);
//		try {
//			thread3.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Thread thread = new Thread(runnable);
		thread.setPriority(Thread.MIN_PRIORITY);
		Thread thread2 = new Thread(runnable);
		thread2.setPriority(Thread.NORM_PRIORITY);
		Thread thread3 = new Thread(runnable);
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		thread.start();
		thread2.start();
		thread3.start();
	}
}
