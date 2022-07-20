package com.lhd.springboot_blog.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexMatches
{

    public static List<String> getTmgUrl(String str,String img_url){
        List<String> list=new ArrayList<>();
      // 按指定模式在字符串查找
      String pattern = img_url+".{8}-.{4}-.{4}-.{4}-.{13}jpg";

            // 创建 Pattern 对象
            Pattern r = Pattern.compile(pattern);

            // 现在创建 matcher 对象
            Matcher m = r.matcher(str);
            while (m.find( )) {

                list.add(m.group());
            }
return list;

        }


   }
