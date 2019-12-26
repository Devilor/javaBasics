package com.ernesto.demo;

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
        Future<Integer> calculateFuture = future.calculateSome(23, 12);
        while (!calculateFuture.isDone()) {
            //在异步任务还没完成的时候，可以提高交互感受，告诉调用者一些友好提示或者是做一些其它工作
            //如果下面这个输出优先于 Future 方法中的输出，就可以说明确实是主线程启动了那个异步之后
            //继续往下搞事情了
            System.out.println("主线程：事情还没有完成，别催，我正在加班加点搞...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            result = calculateFuture.get();
            System.out.println("主线程：...异步搞事情完成，结果为：[Result] = " + result);
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
     */
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * 使用 Lambda 表达式直接行为参数化
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
}