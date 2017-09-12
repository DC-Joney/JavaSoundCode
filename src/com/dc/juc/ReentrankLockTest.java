package com.dc.juc;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/9/12.
 */
@SuppressWarnings("unchecked")
public class ReentrankLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add(1);
    }

}
