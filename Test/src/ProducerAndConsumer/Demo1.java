package ProducerAndConsumer;

/**
 * @Author: jiawen.chen
 * @Date: 2019/7/16 14:06
 */
public class Test1 {
    private static int cnt = 0;
    private static int FULL = 10;
    private static String LOCK = "lock";
   private Object o=new Object();
    public static void main(String[] args) {
        Test1 Test=new Test1();
        new Thread(Test.new Producer(),"生产者1").start();
        new Thread(Test.new Consumer(),"消费者1").start();
        new Thread(Test.new Producer(),"生产者2").start();
        new Thread(Test.new Consumer(),"消费者2").start();
        new Thread(Test.new Producer(),"生产者3").start();
        new Thread(Test.new Consumer(),"消费者3").start();
        new Thread(Test.new Producer(),"生产者4").start();
        new Thread(Test.new Consumer(),"消费者4").start();
        new Thread(Test.new Producer(),"生产者5").start();
        new Thread(Test.new Consumer(),"消费者5").start();
        new Thread(Test.new Producer(),"生产者6").start();
        new Thread(Test.new Consumer(),"消费者6").start();
    }


    /**
     * 生产者
     */
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);//模拟生产过程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (cnt == FULL) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    cnt++;
                    System.out.println(Thread.currentThread().getName() + "生产结束，当前可用资源为：" + cnt);
                    o.notifyAll();//通知消费者
                }
            }
        }
    }


    /**
     * 消费者
     */
    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);//模拟消费过程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (cnt == 0) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cnt--;
                        System.out.println(Thread.currentThread().getName()+"消费结束，当前可用资源为：" + cnt);
                        o.notifyAll();//通知生产者
                    }
                }
            }
        }
    }
}