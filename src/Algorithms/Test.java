package Algorithms;

import java.util.HashMap;


public class Test {
    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        String oldValue = sites.put(2, "Hello");
        System.out.println("HashMap: " + sites);
        System.out.println(oldValue);
    }
}
