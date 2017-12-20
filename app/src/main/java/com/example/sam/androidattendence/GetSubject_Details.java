package com.example.sam.androidattendence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sam on 23/7/16.
 */
public class GetSubject_Details extends Activity {
    EditText EDT_Subject1 , EDT_Subject2 , EDT_Subject3 , EDT_Subject4 , EDT_Subject5 , EDT_Subject6;
    Button BT_Submit_Subjects;
    String Subject1="" , Subject2="" , Subject3="" , Subject4="" , Subject5="" , Subject6="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_set_subjects);
        EDT_Subject1 = (EditText) findViewById(R.id.editText_subject1);
        EDT_Subject2 = (EditText) findViewById(R.id.editText_subject2);
        EDT_Subject3 = (EditText) findViewById(R.id.editText_subject3);
        EDT_Subject4 = (EditText) findViewById(R.id.editText_subject4);
        EDT_Subject5 = (EditText) findViewById(R.id.editText_subject5);
        EDT_Subject6 = (EditText) findViewById(R.id.editText_subject6);
        BT_Submit_Subjects = (Button) findViewById(R.id.button_submit_subjects);

        BT_Submit_Subjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Subject1 = EDT_Subject1.getText().toString();
                Subject2 = EDT_Subject2.getText().toString();
                Subject3 = EDT_Subject3.getText().toString();
                Subject4 = EDT_Subject4.getText().toString();
                Subject5 = EDT_Subject5.getText().toString();
                Subject6 = EDT_Subject6.getText().toString();

                UserListDbHelper2 uldh2;
                uldh2 = new UserListDbHelper2(getApplicationContext(),null,null,3);
                uldh2.createTable();
                uldh2.insertData(""+Subject1, ""+Subject2, ""+Subject3, ""+Subject4, ""+Subject5, ""+Subject6,"0","0","0","0","0","0");

                UserListDbHelper uldh;
                uldh = new UserListDbHelper(getApplicationContext(),null,null,3);
                if(uldh.isTableExists()){
                    Intent moveToMain = new Intent(getApplication() , MainActivity.class);
                    startActivity(moveToMain);
                    finish();
                }
                else{
                    Intent moveToRegister = new Intent(getApplication() , Register.class);
                    startActivity(moveToRegister);
                    finish();
                }
            }
        });

    }
}
