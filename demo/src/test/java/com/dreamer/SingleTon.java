package com.dreamer;

/**
 * @author dreamer
 * @creater 2022/8/16 0016 21:35
 */
//单例模式（懒加载）
public class SingleTon {
    private static SingleTon singleTon = null;
    private SingleTon(){
    }
    public static SingleTon getInstance(){
        if(singleTon==null){
            synchronized (SingleTon.class) {
                singleTon = new SingleTon();
            }
        }
        return singleTon;
    }
}
