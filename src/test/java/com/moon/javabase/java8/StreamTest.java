package com.moon.javabase.java8;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    /**
     * 现在有一个List<User> 的集合，如何把这个list转换成Map<Integer, User> 其中，
     * key是user id，value是User对象
     */
    @Test
    public void List2MapTest(){
        List<User> users = Arrays.asList(new User(6, "Tomcat"),
                new User(2, "Apache"),
                new User(3, "Nginx"));
        Map<Integer,User> userMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        Map<Integer,User> userMap1 = users.stream().collect(Collectors.toMap(obj-> obj.getId(),obj-> obj));
        Map<Integer,User> userMap2 = users.stream().collect(Collectors.toMap(User::getId,obj->obj));
        Assert.assertTrue(userMap.get(1).equals(users.get(0)));

    }

    /**
     * 把url的请求参数（如：type=1&from=APP&source=homePage）转换成Map<String, String>
     */
    @Test
    public void str2MapTest(){
        String queryString = "type=1&from=APP&source=homePage";
        Map<String,String> map = Stream.of(queryString.split("&")).map(x-> x.split("=")).collect(Collectors.toMap(enity -> enity[0],enity -> enity[1]));
        Assert.assertTrue(map.size() ==3 && "1".equals(map.get("type")));
    }

    /**
     * 排序
     */
    @Test
    public void sortTest(){
        List<User> users = Arrays.asList(new User(6, "Tomcat"),
                new User(2, "Apache"),
                new User(3, "Nginx"));
        users.stream().sorted((t1,t2)-> Integer.compare(t1.getId(),t2.getId())).forEach(System.out::println);
    }



    public class User {

        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String toString() {
            return "User [id=" + id + ", name=" + name + "]";
        }

    }
}
