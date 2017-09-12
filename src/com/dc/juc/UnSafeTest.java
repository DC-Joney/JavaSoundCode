package com.dc.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/9/12.
 */
public class UnSafeTest {
    public static void main(String[] args) {
        try {
            User user = new User();
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe = (Unsafe) theUnsafe.get(null);
            System.out.println(unsafe);
            Field filed = user.getClass().getDeclaredField("age");
            long ageOffset = unsafe.objectFieldOffset(filed);
            unsafe.putInt(user, ageOffset, 10);
            unsafe.compareAndSwapInt(user,ageOffset,10,11);
            System.out.println(user.getAge());
            System.out.println(unsafe);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class User{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}
