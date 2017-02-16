package com.shixiang.io;

import java.sql.Timestamp;

public class Client {

    private int id = 1;
    private String name = "name";
    private Timestamp createdTime = new Timestamp(System.currentTimeMillis());
    
    public static void main(String[] args) {
/*        String str = null;
        test(str);*/

/*        Client client = new Client();
        client.toString();*/
        
        exceptionTest();
    }

    public static void test(String str){
        System.out.println(str.length());
        if(str != null){
            System.out.println(str);
        }
        System.out.println("failure");
    }
    
    public String toString() {
        return String.format("Domain[id=%d,name=%s,create_time=%d]",
            id, name, createdTime);
    }
    
    public static void exceptionTest(){
        try{
           int count = 1/0;
           System.out.println(count);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("error: ", e);
        }
    }
}
