package com.example.sam.androidattendence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by sam on 18/7/16.
 */
public class View_Details_List extends Activity{
    ListView LV_Details;
    Button BT_Back_To_Main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_details_list);
        LV_Details = (ListView) findViewById(R.id.listView_view_details);
        BT_Back_To_Main = (Button) findViewById(R.id.button_back_to_main);
        Toast.makeText(getApplicationContext() , "View Details" , Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        String Adm_no = intent.getStringExtra("Admission_Number");
        String Name = intent.getStringExtra("Name");
        String Branch= intent.getStringExtra("Branch");
        String Mobile_no = intent.getStringExtra("Mobile_Number");
        String Hostel = intent.getStringExtra("Hostel");
        String Room_no = intent.getStringExtra("Room_Number");

        String str[] = {Adm_no , Name , Branch , Mobile_no  , Hostel , Room_no};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , R.layout.support_simple_spinner_dropdown_item , str);
        LV_Details.setAdapter(adapter);


        BT_Back_To_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Back_to_main = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(Back_to_main);
                finish();
            }
        });



    }
}
