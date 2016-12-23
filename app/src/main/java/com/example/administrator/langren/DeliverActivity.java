package com.example.administrator.langren;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeliverActivity extends Activity {


    TextView playerNum;
    int playerNumber;
    int seerNum;
    int witchNum;
    int hunterNum;
    int idiotNum;
    int werewolfNum;
    int villagerNum;
    public List<Integer> list;
    public int currentPlayerNumber = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);

        playerNumber = getIntent().getIntExtra("total",0);
        seerNum = getIntent().getIntExtra("seer",0);
        witchNum = getIntent().getIntExtra("witch",0);
        hunterNum = getIntent().getIntExtra("hunter",0);
        idiotNum = getIntent().getIntExtra("idiot",0);
        werewolfNum = getIntent().getIntExtra("werewolf",0);
        villagerNum = getIntent().getIntExtra("villager",0);

        list = new ArrayList<Integer>(playerNumber);
        while (seerNum > 0){
            list.add(1);
            seerNum--;
        }
        while (witchNum > 0){
            list.add(2);
            witchNum--;
        }
        while (hunterNum > 0){
            list.add(3);
            hunterNum--;
        }
        while (idiotNum> 0){
            list.add(4);
            idiotNum--;
        }
        while (werewolfNum > 0){
            list.add(5);
            werewolfNum--;
        }
        while (villagerNum > 0){
            list.add(6);
            villagerNum--;
        }

        //disorder
        Collections.shuffle(list);

        playerNum = (TextView)findViewById(R.id.textView);
        playerNum.setText("玩家"+currentPlayerNumber+"：");
    }

    public void onclick1(View view) //这个方法是弹出一个对话框
    {
        String character = "";
        int temp = list.get(currentPlayerNumber - 1);
        //1：预言家，2：女巫，3：猎人，4：白痴，5：狼人，6：普通村民
        boolean characterOK = false;
        while (!characterOK){
            if (temp ==1){
                character = "预言家";
                characterOK = true;
            }else if(temp ==2){
                character = "女巫";
                characterOK = true;
            }else if(temp ==3){
                character = "猎人";
                characterOK = true;
            }else if(temp ==4){
                character = "白痴";
                characterOK = true;
            }else if(temp ==5){
                character = "狼人";
                characterOK = true;
            }else if(temp ==6){
                character = "普通村民";
                characterOK = true;
            }
        }


        AlertDialog.Builder builder=new Builder(this);
        //builder.setIcon(R.drawable.ic_launcher);//设置图标
        builder.setTitle("请确认你的身份");//设置对话框的标题
        builder.setMessage("你的身份是："+character+"\n你确认自己身份了吗？");//设置对话框的内容
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  //这个是设置确定按钮

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(DeliverActivity.this, "确认完毕", Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog b=builder.create();
        b.show();  //必须show一下才能看到对话框，跟Toast一样的道理
    }

    public void onclick2(View view) //这个方法是弹出一个对话框
    {

        if (currentPlayerNumber >= playerNumber){
            System.out.println("最后一位玩家！");
            Intent intent = new Intent(DeliverActivity.this, DeliverActivity.class);
            intent.putExtra("total", playerNumber);
            for (int m = 0; m <playerNumber; m++){
                String p = "player" + (m + 1);
                intent.putExtra(p,list.get(m));
            }

            startActivity(intent);
        }else {
            currentPlayerNumber++;
            if (currentPlayerNumber == playerNumber){
                Button btn = (Button)findViewById(R.id.buttonN);
                btn.setText("开始游戏！");
            }
            playerNum.setText("玩家"+currentPlayerNumber+"：");
        }
    }
}
