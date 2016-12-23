package com.example.administrator.langren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class RoomActivity extends Activity {
    private TextView textViewTitle;
    private TextView textViewTotal;
    private TextView textView4;
    private TextView textView6;
    private TextView textView8;
    private TextView textView10;
    private TextView textView12;
    private TextView textView14;
    private Button btnStart;
    private SeekBar sb;
    private int num = 7;
    private int[][] jobs = {{1,1,0,0,2,3},
            {1,1,0,0,2,4},
            {1,1,1,0,3,3},
            {1,1,1,0,3,4},
            {1,1,1,0,3,5},
            {1,1,1,1,4,4}};
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        rl = (RelativeLayout) findViewById(R.id.activity_room);
        rl.getBackground().setAlpha(50);
        textViewTitle = (TextView)findViewById(R.id.textView);
        textViewTitle.setText("请选择游戏人数：");
        sb = (SeekBar)findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(sbListener);
        btnStart = (Button)findViewById(R.id.button3);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomActivity.this, DeliverActivity.class);
                intent.putExtra("total", num);
                intent.putExtra("seer", jobs[num-7][0]);
                intent.putExtra("witch", jobs[num-7][1]);
                intent.putExtra("hunter", jobs[num-7][2]);
                intent.putExtra("idiot", jobs[num-7][3]);
                intent.putExtra("werewolf", jobs[num-7][4]);
                intent.putExtra("villager", jobs[num-7][5]);

                startActivity(intent);
            }
        });

        textViewTotal = (TextView)findViewById(R.id.textView2);
        textViewTotal.setText("共有" +7+ "名玩家");

        textView4 = (TextView)findViewById(R.id.textView4);
        textView6 = (TextView)findViewById(R.id.textView6);
        textView8 = (TextView)findViewById(R.id.textView8);
        textView10 = (TextView)findViewById(R.id.textView10);
        textView12 = (TextView)findViewById(R.id.textView12);
        textView14 = (TextView)findViewById(R.id.textView14);
    }
    private SeekBar.OnSeekBarChangeListener sbListener = new SeekBar.OnSeekBarChangeListener(){
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            num = progress + 7;
            textView4.setText(jobs[progress][0]+"");
            textView6.setText(jobs[progress][1]+"");
            textView8.setText(jobs[progress][2]+"");
            textView10.setText(jobs[progress][3]+"");
            textView12.setText(jobs[progress][4]+"");
            textView14.setText(jobs[progress][5]+"");
            textViewTotal.setText("共有" +num+ "名玩家");
        }
        @Override
        //开始拖动的时候调用
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        //停止拖动的时候调用
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

}
