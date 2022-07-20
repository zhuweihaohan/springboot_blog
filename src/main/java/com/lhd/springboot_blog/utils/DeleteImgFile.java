package com.lhd.springboot_blog.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/19 11:33
 * @company bonc
 * @project springboot_blog
 */
@Slf4j
public class DeleteImgFile implements Runnable {
    private String path;

    public DeleteImgFile(String path){
        this.path=path;

    };

    @Override
    public void run()  {

        File file = new File(path);
       file.delete();
       log.info("删除图片："+path);

    }


}
