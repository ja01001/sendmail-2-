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
import android.widget.Toast;

public class Mainpage extends AppCompatActivity {
    private GMailSender m;

    EditText et_content;
    EditText et_title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        Button btn_send = (Button) this.findViewById(R.id.btn_send);
        et_content = (EditText) findViewById(R.id.et_content);
        et_title = (EditText) findViewById(R.id.et_title);

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
                    sender.sendMail(et_title.getText().toString(), // subject.getText().toString(),
                            et_content.getText().toString(), // body.getText().toString(),
                            "teamhanmail@gmail.com", // from.getText().toString(),
                            "teamhanmail@gmail.com" // to.getText().toString()
                    );
                    toast();
                    toast();
                } catch (Exception e)
                {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
    }

    public void toast()
    {
        Toast.makeText(this, "전송되었습니다.", Toast.LENGTH_SHORT).show();

    }


}
