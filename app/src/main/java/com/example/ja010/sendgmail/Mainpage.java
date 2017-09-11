package com.example.ja010.sendgmail;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Mainpage extends AppCompatActivity {
    private GMailSender m;
    TextView textmain1,textmain2,textmain3,textmain4;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        textmain1 = (TextView)findViewById(R.id.text1);
        textmain2 = (TextView)findViewById(R.id.text2);
        textmain3 = (TextView)findViewById(R.id.text3);
        textmain4 = (TextView)findViewById(R.id.text4);
        Button btn_send = (Button) this.findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                GMailSender sender = new GMailSender("teamhanmail@gmail.com", "hanyang123"); // SUBSTITUTE

                if (android.os.Build.VERSION.SDK_INT > 9)
                {

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();

                    StrictMode.setThreadPolicy(policy);

                }
                // HERE
                try
                {
                    sender.sendMail("컨설팅 참가 확인 메일", // subject.getText().toString(),
                            "컨설팅 참석에 감사드립니다. ", // body.getText().toString(),
                            "teamhanmail@gmail.com", // from.getText().toString(),
                            "teamhanmail@gmail.com" // to.getText().toString()
                    );

                    toast();
                } catch (Exception e)
                {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain1.setText("욕실은");
            }
        },1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain2.setText("가장 아름다운 방");
            }
        },2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain3.setText("이어야 합니다. ");
            }
        },2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain4.setText("Bathroom should be the most beautiful room.");
            }
        },4000);
    }

    public void toast()
    {
        Toast.makeText(this, "전송되었습니다.", Toast.LENGTH_SHORT).show();
        
    }


}
