package com.example.sam.androidattendence;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by isam on 19/12/17.
 */

public class Register_Edit extends Activity{
    EditText EDT_AdmNo, EDT_Name, EDT_Branch, EDT_MobileNo, EDT_Hostel, EDT_RoomNo;
    Button BT_Submit;
    String Admission_Number, Name, Branch, Mobile_Number, Hostel, Room_Number;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        EDT_AdmNo = (EditText) findViewById(R.id.edt_admno);
        EDT_Name = (EditText) findViewById(R.id.edt_name);
        EDT_Branch = (EditText) findViewById(R.id.edt_branch);
        EDT_MobileNo = (EditText) findViewById(R.id.edt_mobileno);
        EDT_Hostel = (EditText) findViewById(R.id.edt_hostel);
        EDT_RoomNo = (EditText) findViewById(R.id.edt_roomno);
        BT_Submit = (Button) findViewById(R.id.button_submit);

        BT_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Admission_Number = EDT_AdmNo.getText().toString();
                Name = EDT_Name.getText().toString();
                Branch = EDT_Branch.getText().toString();
                Mobile_Number = EDT_MobileNo.getText().toString();
                Hostel  = EDT_Hostel.getText().toString();
                Room_Number = EDT_RoomNo.getText().toString();


                UserListDbHelper uldh;
                uldh = new UserListDbHelper(getApplicationContext(),null,null,3);
                uldh.createTable();
                uldh.insertData(""+Admission_Number, ""+Name, ""+Branch, ""+Mobile_Number, ""+Hostel, ""+Room_Number);
                Intent Back_to_main = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(Back_to_main);
                finish();
            }
        });
    }
}
