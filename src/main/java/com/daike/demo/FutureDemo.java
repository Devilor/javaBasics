package com.daike.demo;

import java.util.concurrent.*;

/**
 * 一个关于 Java 中 Future 并发的小例子
 *
 * @author Ernesto
 * @date 2019/12/26
 */
public class FutureDemo {
    public static void main(String[] args) {
        MyFuture future = new MyFuture();
        Integer result = 0;
        //Future<Integer> calculateFuture = future.calculateSome(23, 12);
        Future<String> getMessage01 = future.getMessageByHttp("12123");
        Future<String> getMessage02 = future.getMessageByFtp("12123");
        /*while (!calculateFuture.isDone()) {
            //在异步任务还没完成的时候，可以提高交互感受，告诉调用者一些友好提示或者是做一些其它工作
            //如果下面这个输出优先于 Future 方法中的输出，就可以说明确实是主线程启动了那个异步之后
            //继续往下搞事情了
            System.out.println("主线程：事情还没有完成，别催，我正在加班加点搞...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        while (!(getMessage01.isDone() && getMessage02.isDone())) {
            try {
                System.out.println(String.format("getMessage01 is [%s] and getMessage02 is [%s].",
                    getMessage01.isDone() ? "Finished." : "Working", getMessage02.isDone() ? "Finished." : "Working"));
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            //result = calculateFuture.get();
            //System.out.println("主线程：...异步搞事情完成，结果为：[Result] = " + result);

            System.out.println("Main Threan Execute....");
            System.out.println(
                String.format("Http Message: [%s]\nFTP Message: [%s]", getMessage01.get(), getMessage02.get()));
            future.shutdownThread();
            future.shutdownThreadPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class MyFuture {
    /**
     * 获取一个执行器 Excutor
     * 这是一个单线程 Example
     */
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * 获取一个执行器 Excutor
     * 这是一个线程池里面放有 2 个线程
     */
    private ExecutorService executorServices = Executors.newFixedThreadPool(2);

    /**
     * 使用 Lambda 表达式直接行为参数化（首选方式）
     * 假如这是一个复杂的计算任务,即：值得使用并发出来的计算过程或者是请求过程
     *
     * @param numX
     * @param numY
     * @return
     */
    // public Future<Integer> calculateSome(int numX, int numY) {
    //     return executorService.submit(() -> {
    //         System.out.println(">>>正在干一些奇奇怪怪的事情，别催，我没死机...");
    //         Thread.sleep(1000);
    //         return numX * numY;
    //     });
    // }

    /**
     * 使用匿名类传递进行行为参数化
     *
     * @param numX
     * @param numY
     *
     * @return
     */
    public Future<Integer> calculateSome(int numX, int numY) {
        return executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(">>>另一个线程：正在干一些奇奇怪怪的事情，别催，我没死机...");
                Thread.sleep(1000);
                return numX * numY;
            }
        });
    }

    public Future<String> getMessageByHttp(String port) {
        return executorServices.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Thread - 1001 Execute...");
                return "[Thread 1] : Hello Main Thread.";
            }
        });
    }

    public Future<String> getMessageByFtp(String port) {
        return executorServices.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Thread - 1002 Execute...");
                return "[Thread 2] : Hello Main Thread.";
            }
        });
    }

    /**
     * 关闭 执行器 - 多线程
     */
    public void shutdownThreadPool() {
        if (!this.executorServices.isShutdown()) {
            this.executorServices.shutdown();
        }
    }

    /**
     * 关闭 执行器-单线程
     */
    public void shutdownThread() {
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
