package com.lhd.springboot_blog.utils.guavaCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaTest {
    
    private LoadingCache<Integer, String> inventoryCacheByCondition = CacheBuilder.newBuilder().
            // 设置过期时间
                    expireAfterWrite(5L, TimeUnit.SECONDS).
            // 初始容量，扩容非常消耗资源这个一定规划好合适大小
                    initialCapacity(256).
            // 最大容量
                    maximumSize(1024L).
                    build(new CacheLoader<Integer, String>() {
                        /*
                         * 如果出现缓存没命中到场景会调用到load
                         * 实际场景这里处理不好极有可能oom要注意
                         * 这里暂时实现一个兜底逻辑
                         */
                        @Override
                        public String load(Integer key) throws Exception {
                            System.out.println("调用load重新加载缓存");
                            reflushInventoryType(inventoryCacheByCondition, 0);
                            boolean result = inventoryCacheByCondition.asMap().containsKey(key);
                        if(!result){
                            return "未知leixing";
                        }
                            return inventoryCacheByCondition.get(key);
                        }
                    });
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        GuavaTest test = new GuavaTest();
        System.out.println("=====================================第一次查缓存");
        System.out.println(test.inventoryCacheByCondition.get(6));
        System.out.println("=====================================缓存持续时间内查询");
        System.out.println(test.inventoryCacheByCondition.get(6));
        TimeUnit.SECONDS.sleep( 5 );
        System.out.println("=====================================我睡了5s，缓存过期啦");
        System.out.println(test.inventoryCacheByCondition.get(6));
        test.reflushInventoryType(test.inventoryCacheByCondition, 0);
        System.out.println("=====================================遍历map");
        test.fun(test);

    }

    public void fun(GuavaTest test){
        test.inventoryCacheByCondition.asMap().forEach((key,value)->{
            System.out.println(key + value);
        });
    }

    private void reflushInventoryType(LoadingCache<Integer, String> inventoryCacheByCondition
            ,Integer queryType){
        inventoryCacheByCondition.put(1,"value1");
        inventoryCacheByCondition.put(2,"value2");
        inventoryCacheByCondition.put(3,"value3");
        inventoryCacheByCondition.put(4,"value4");
        inventoryCacheByCondition.put(5,"value5");
        inventoryCacheByCondition.put(6,"value6");
    }
}
