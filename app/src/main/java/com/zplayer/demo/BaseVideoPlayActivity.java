/*
 * *********************************************************
 *   author   colin
 *   company  telchina
 *   email    wanglin2046@126.com
 *   date     18-1-9 下午2:12
 * ********************************************************
 */
package com.zplayer.demo;

import android.content.res.Configuration;
import android.os.Bundle;

import com.zplayer.library.ZPlayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 视频播放页面基类
 */
public abstract class BaseVideoPlayActivity extends AppCompatActivity {

    protected ZPlayer player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(getContentViewId());

        player = initPlayer();
    }

    //已经做了setContentView，如果客户端再次设置，不在操作
    @Override
    public void setContentView(int layoutResID) {
    }

    /**
     * 实现此函数后子类不要再进行setContentView（）操作
     */
    protected abstract int getContentViewId();

    /**
     * 初始化Player操作
     */
    protected abstract ZPlayer initPlayer();

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
