package com.balasasidhar.balasasidhark.smsverification;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText e0,e1,e2;
    Button generateButton;
    String msgBody;
    int codeReceived = 0;
    int codeReceivedArray[];

    int codeGenerated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e0 = (EditText)findViewById(R.id.digitOne);
        e1 = (EditText)findViewById(R.id.digitTwo);
        e2 = (EditText)findViewById(R.id.digitThree);

        generateButton = (Button)findViewById(R.id.button);

        MyApplication myApplication = (MyApplication) this.getApplicationContext();
        myApplication.mainActivity = this;

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(codeReceived !=0) {
                    codeGenerated = GenerateUniqueCode.generate(codeReceivedArray);
                    e0.setText(""+codeGenerated);
                    e1.setText(""+codeGenerated);
                    e2.setText(""+codeGenerated);
                }else{
                    Toast.makeText(getApplicationContext(), "You doesn't received any message yet." , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
