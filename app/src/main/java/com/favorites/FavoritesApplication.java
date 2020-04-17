package com.favorites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

@SpringBootApplication
public class FavoritesApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FavoritesApplication.class);
    }

    public static void main(String[] args) {
//        SpringApplication.run(FavoritesApplication.class, args);
        Map a = new ConcurrentHashMap<>();
        Map b = new HashMap<String, String>();
        b.put("a", "1");
        b.put("b", "2");
        // 1. entrySet
        Iterator<Entry<String, String>> iterator = b.entrySet().iterator();
        while (iterator.hasNext()){
            Entry<String, String> next = iterator.next();
            next.getKey();
            next.getValue();
        }

        // 2.jdk1.8开始自带的遍历方法,内部使用entrySet实现
        b.forEach(new BiConsumer() {
            @Override
            public void accept(Object key, Object value) {
                System.out.println(key + ":" + value);
            }
        });
//        b.forEach((key, value) -> {
//            System.out.println(key + ":" + value);
//        });

        // 3. keySet(不推荐)
        for (Object key : b.keySet()) {
            String s = (String) key;
            System.out.println(s);
        }
    }
}