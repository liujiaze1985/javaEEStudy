package com.ljz.concurrency.chapter7;

/**
 * Copyright © 2019年12月05日 LiuJiaZe. All rights reserved.
 * @Project: java8
 * @Package: com.ljz.concurrency.chapter2
 * @Description: 模拟银行排队叫号 数据同步
 * @author: LiuJiaZe
 * @date: 2019年12月05日 15:55
 * @version: V1.0
 */
public class BankVersion3 {

    public static void main(String[] args) {
        //demonstration1();
        demonstration2();


    }


    private static void demonstration2() {
        //业务数据只创建了一次
        final SynchronizedRunnable1 ticketWindow = new SynchronizedRunnable1();

        Thread ticketWindow1 = new Thread(ticketWindow, "1号柜台");
        Thread ticketWindow2 = new Thread(ticketWindow, "2号柜台");
        Thread ticketWindow3 = new Thread(ticketWindow, "3号柜台");
        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }

    /**
     * 使用同步方法
     * 只有一个线程抢到锁在工作
     */
    private static void demonstration1() {
        //业务数据只创建了一次
        final SynchronizedRunnable ticketWindow = new SynchronizedRunnable();

        Thread ticketWindow1 = new Thread(ticketWindow, "1号柜台");
        Thread ticketWindow2 = new Thread(ticketWindow, "2号柜台");
        Thread ticketWindow3 = new Thread(ticketWindow, "3号柜台");
        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }

}
