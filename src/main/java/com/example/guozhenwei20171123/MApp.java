package com.example.guozhenwei20171123;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * author:Created by WangZhiQiang on 2017/11/23.
 */

public class MApp extends Application {
    File cachefile = new File(Environment.getExternalStorageDirectory() + "/" + "images");

    @Override
    public void onCreate() {
        super.onCreate();
        //全局配置
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .diskCache(new UnlimitedDiskCache(cachefile))//缓存到磁盘
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))//内存
                .build();
        //获取实例
        ImageLoader.getInstance().init(configuration);
    }
}
