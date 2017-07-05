package com.eastsun.activity.appdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eastsun.adapter.AskQueAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hman
 * @date 2017/6/30
 * 音乐播放器
 * */
public class VoicePlayActivity extends BaseActivity {

    private static final String TAG = "VoicePlayActivity";
    public List<Map<String,List>> lists = new ArrayList<>();
    public SwipeRefreshLayout refreshLayout;
    public RecyclerView recycler;
    public AskQueAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_play);
        setHeaderTitle(R.string.src_voice);
        setDatas();
        initView();
    }

    private void initView() {
        mAdapter = new AskQueAdapter(this,lists);

        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.my_question_swipe);
        recycler = (RecyclerView) findViewById(R.id.my_question_recycler);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(mAdapter);

    }


    public List<?> setDatas() {
//        List list = new ArrayList();
        Map<String,List> map11 = new HashMap<>();
        /* 第一道题 */
        List list1 = new ArrayList();
        map11.put("1,天窗设计的技术要求是什么？",list1);

        Map map1 = new HashMap();
        map1.put("choose","A,我都不知道");
        map1.put("icon",R.drawable.choose);
        list1.add(map1);

        Map map2 = new HashMap();
        map2.put("choose","B,谁问谁知道");
        map2.put("icon",R.drawable.no_choose);
        list1.add(map2);

        Map map3 = new HashMap();
        map3.put("choose","C,反正我不知道");
        map3.put("icon",R.drawable.no_choose);
        list1.add(map3);

        Map map4 = new HashMap();
        map4.put("choose","D,知道也不告诉你");
        map4.put("icon",R.drawable.no_choose);
        list1.add(map4);

        Map map41 = new HashMap();
        map41.put("choose","E,不知道怎么告诉你");
        map41.put("icon",R.drawable.no_choose);
        list1.add(map41);

        Map map42 = new HashMap();
        map42.put("choose","F,你管我知道不知道，反正就是不告诉你");
        map42.put("icon",R.drawable.no_choose);
        list1.add(map42);
        lists.add(map11);

        /* 第二道题 */
        Map<String,List> map22 = new HashMap<>();
        List list2 = new ArrayList();
        map22.put("2,世纪之战谁是英雄？", list2);

        Map map5 = new HashMap();
        map5.put("choose","A,Hman");
        map5.put("icon",R.drawable.choose);
        list2.add(map5);

        Map map6 = new HashMap();
        map6.put("choose","B,毛泽东");
        map6.put("icon",R.drawable.no_choose);
        list2.add(map6);

        Map map7 = new HashMap();
        map7.put("choose","C,金三胖");
        map7.put("icon",R.drawable.no_choose);
        list2.add(map7);

        Map map8 = new HashMap();
        map8.put("choose","D,特朗普");
        map8.put("icon",R.drawable.no_choose);
        list2.add(map8);

        lists.add(map22);
        /* 第三道题 */
        Map<String,List> map33 = new HashMap<>();
        List list3 = new ArrayList();

        Map map9 = new HashMap();
        map9.put("choose","西湖十景");
        map9.put("icon",R.drawable.no_choose);
        list3.add(map9);

        Map map10 = new HashMap();
        map10.put("choose","滕王阁");
        map10.put("icon",R.drawable.choose);
        list3.add(map10);

        map33.put("下列哪项不是杭州地方",list3);
        lists.add(map33);

        /* 第四道题 */
        Map<String,List> map44 = new HashMap<>();
        List list4 = new ArrayList();

        Map map12 = new HashMap();
        map12.put("choose","王者荣耀影响小学生学习？");
        map12.put("icon",R.drawable.choose);
        list4.add(map12);

        Map map13 = new HashMap();
        map13.put("choose","我们应该打上日本，摧毁日本，从精神和身体上去侵略他们");
        map13.put("icon",R.drawable.choose);
        list4.add(map13);

        Map map14 = new HashMap();
        map14.put("choose","世界并不合平");
        map14.put("icon",R.drawable.choose);
        list4.add(map14);

        Map map15 = new HashMap();
        map15.put("choose","老美很崇拜中国");
        map15.put("icon",R.drawable.no_choose);
        list4.add(map15);

        Map map16 = new HashMap();
        map16.put("choose","法西斯让世界卷入了战争");
        map16.put("icon",R.drawable.choose);
        list4.add(map16);

        Map map17 = new HashMap();
        map17.put("choose","法西斯让世界卷入了战争");
        map17.put("icon",R.drawable.choose);
        list4.add(map17);

        Map map18 = new HashMap();
        map18.put("choose","法西斯让世界卷入了战争");
        map18.put("icon",R.drawable.choose);
        list4.add(map18);

        Map map160 = new HashMap();
        map160.put("choose","法西斯让世界卷入了战争");
        map160.put("icon",R.drawable.choose);
        list4.add(map160);

        map44.put("判断下面对错",list4);
        lists.add(map44);
        return lists;
    }
}
