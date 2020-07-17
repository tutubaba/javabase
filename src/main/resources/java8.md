### java8 新特性

#### lambada 表达式
```
       Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    System.out.println("run");
                }
            };
                
        Runnable runnable2 = () -> System.out.println("aa");
```