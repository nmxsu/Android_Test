package com.example.hx.myapplication.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hx on 2016/7/24.
 */
public class Download {
    public String download(String urlStr){
        /**
         * StringBuffer 是final类，是线程安全的可变序列
         * 主要操作：是append和insert方法，
         * append方法始终将这些字符串添加到缓冲区末端；insert方法在指定的点添加字符
         *
         */

        StringBuffer sb=new StringBuffer();
        String line=null;
        BufferedReader buffer=null;

        try {
            URL url=new URL(urlStr);//创建URL对象
            HttpURLConnection urlConn=(HttpURLConnection) url.
                    openConnection();//创建Http连接
            //使用IO读取数据
            buffer=new BufferedReader(new InputStreamReader(urlConn.
                    getInputStream()));

            while ((line=buffer.readLine())!=null){
                sb.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
