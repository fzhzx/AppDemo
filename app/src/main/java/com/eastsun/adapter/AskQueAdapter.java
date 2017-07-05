package com.eastsun.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.eastsun.activity.appdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hman on 2017/7/3.
 * 视频音频的回答问题等
 */
public class AskQueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = "AskQueAdapter";
    private View view;
    private List<Map<String,List>> lists;
    private Context context;

    public AskQueAdapter(Context context, List<Map<String,List>> lists){
        this.context = context;
        this.lists = lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.activity_ask_question, parent, false);
        return new AskQueHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AskQueHolder)holder).setData(position);
    }

    @Override
    public int getItemCount() {
        return lists != null ? lists.size() : 0;
    }

    public class AskQueHolder extends RecyclerView.ViewHolder{

        public boolean flag = false;
        public TextView titleTv, chooseAnswer;
        public Button askBt;
        public ListView chooseLv;
        public StringBuffer answerSB = new StringBuffer();


        public AskQueHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.ask_que_title);
            chooseAnswer = (TextView) itemView.findViewById(R.id.ask_que_choose_que);
            askBt = (Button) itemView.findViewById(R.id.ask_que_answer_commit);
            chooseLv = (ListView) itemView.findViewById(R.id.ask_que_choose_lv);
//            int currentHeight = 0;
//            int list_child_item_height = chooseLv.getMeasuredHeight()+ chooseLv.getDividerHeight();
//            for (int i = 0; i < lists.size(); i++) {
//                currentHeight += 30;
//            }
//            Log.e(TAG, String.valueOf(currentHeight) + ";" + lists.size()*30);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    R.dimen.list_height);
            chooseLv.setLayoutParams(param);

        }

        public void setData(int position) {
            Map map = lists.get(position);
            String title = map.keySet().toString();
            SimpleAdapter sAdapter;
            /* 题目 */
            titleTv.setText(((Map)lists.get(position)).keySet().toString());

            final List list = lists.get(position).get(title.substring(1,title.length()-1));
            Log.e(TAG,title.substring(1,title.length()-1) + ";" + String.valueOf(flag));
//            List<Map<String,Object>> list = new ArrayList(map.values());
//            List list = setData(Arrays.asList(map.values()));
//            List list = Arrays.asList(map.values());
//            List list = setDatas();
//            SimpleAdapter sAdapter = new SimpleAdapter(context, list,R.layout.activity_ask_answer,new String[]{"choose","icon"},
//                    new int[]{R.id.answer_choose_que,R.id.answer_choose_icon});
//            chooseLv.setAdapter(sAdapter);
            if (flag) {
                sAdapter = new SimpleAdapter(context, list,R.layout.activity_ask_answer,new String[]{"choose","icon"},
                        new int[]{R.id.answer_choose_que,R.id.answer_choose_icon});
                chooseLv.setAdapter(sAdapter);
                askBt.setText(R.string.ask_question_commit);
                flag = true;
            } else {
                sAdapter = new SimpleAdapter(context, list,R.layout.activity_ask_to_answer,new String[]{"choose"},
                        new int[]{R.id.answer_choose_que});
                chooseLv.setAdapter(sAdapter);
                askBt.setText(R.string.ask_the_answer);
                flag = false;
            }

            chooseLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (flag) {
                        TextView answerTv = (TextView) view.findViewById(R.id.answer_choose_que);
                        ImageView iconIv = (ImageView) view.findViewById(R.id.answer_choose_icon);

                        String answer = answerTv.getText().toString();
                        String abc = answer.substring(0,1);
                        if (!answerSB.toString().contains(abc)) {
                            answerSB = answerSB.append(abc);
                            chooseAnswer.setText(answerSB.toString());
//                            iconIv.setBackground(view.getResources().getDrawable(R.drawable.choose,null));
                            iconIv.setBackground(null);
//                            iconIv.setBackgroundResource(R.drawable.choose);
                            iconIv.setImageResource(R.drawable.choose);
                        } else {
                            answerSB = answerSB.deleteCharAt(answerSB.indexOf(abc));
                            chooseAnswer.setText(answerSB.toString());
                            iconIv.setBackground(null);
//                            iconIv.setBackgroundResource(R.drawable.no_choose);
                            iconIv.setImageResource(R.drawable.no_choose);
                        }
                    }
                }
            });

            /* 点击"回答"*/
            askBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SimpleAdapter sAdapter;
                    if (!flag) {
                        sAdapter = new SimpleAdapter(context, list,R.layout.activity_ask_answer,new String[]{"choose","icon"},
                                new int[]{R.id.answer_choose_que,R.id.answer_choose_icon});
                        chooseLv.setAdapter(sAdapter);
                        askBt.setText(R.string.ask_question_commit);
                        flag = true;
                    } else {
                        sAdapter = new SimpleAdapter(context, list,R.layout.activity_ask_to_answer,new String[]{"choose"},
                                new int[]{R.id.answer_choose_que});
                        chooseLv.setAdapter(sAdapter);
                        askBt.setText(R.string.ask_the_answer);
                        flag = false;
                    }
                }
            });
        }

        private List setData(List values) {
            List<Map<String,Object>> list = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();

            for (int i = 0; i < values.size(); i++) {
                map = new HashMap<>();
                map.put("choose",((HashMap)values.get(i)).get("choose"));
                map.put("icon",((HashMap)values.get(i)).get("icon"));
                list.add(map);
            }
            return list;
        }

//        public List<?> setData()

        public List<?> setDatas() {
        List list = new ArrayList();
            Map<String, List> map11 = new HashMap<>();
        /* 第一道题 */
            List list1 = new ArrayList();
            map11.put("1,天窗设计的技术要求是什么？", list1);

            Map map1 = new HashMap();
            map1.put("choose", "A,我都不知道");
            map1.put("icon", R.drawable.choose);
            list1.add(map1);

            Map map2 = new HashMap();
            map2.put("choose", "B,谁问谁知道");
            map2.put("icon", R.drawable.no_choose);
            list1.add(map2);
            Map map3 = new HashMap();
            map3.put("choose","C,反正我不知道");
            map3.put("icon",R.drawable.no_choose);
            list1.add(map3);

            Map map4 = new HashMap();
            map4.put("choose","D,知道也不告诉你");
            map4.put("icon",R.drawable.no_choose);
            list1.add(map4);
//            list.add(map11);
            return list1;
        }
    }

}
