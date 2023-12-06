package org.example;

public class Singleton {

   // private static Singleton instance;
    //private static volatile Singleton instance; //메모리 미스매치 나올 때 사용 volatile 더블 체크할 경우 문제 나올떄 해결
    // volatile 캐쉬 메모리 값 사용하지 않고 메인메모리 값을 상요하여 미스매치를 막음.

    private Singleton() {}

    /*public static synchronized Singleton getInstance(){ //멀티쓰레드 느리지만 해결 가능 기다리게함. 한번에 한놈만 들어와서 진행
        if(instance == null)
           instance = new Singleton();

        return instance;
    }*/

    /*public static Singleton getInstance(){ // 더블 체크로 빠르게함. null 일때만 진행 되게 하기 위해서
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }*/
    // 3번째 방법 클래스를 만듬
    private static class SingletonHolder { //사용하는 시점에 실행됨. 클래스 경로 올라오게됨.
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }

}
