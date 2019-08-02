package com.asmtest.asm;

import java.util.Date;
import java.util.function.Supplier;

/**
 * <pre>
 * <b>Description</b>
 * </pre>
 * <pre>
 * 创建时间 2019-08-02 19:54
 * 所属工程： asm101  </pre>
 *
 * @author sheldon yhid: 80752866
 */
@AnnoMe
@AnnoMe2
public class Klazz extends Me{
    @AnnoFie
    public static int i = 4;
    protected Date d;
    private final static Runnable r = () -> {

    };
    public static final Supplier<Klazz> s = null;
    private static Long l = 3L;

    public void v() {
        new Thread(() -> {

        }).start();
    }
    public int i() { return 1;}

    class A {

    }

    static class C {

    }

    private static class D {}
}
//
//class B {
//
//}
