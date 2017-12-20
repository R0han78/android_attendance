package com.example.sam.androidattendence;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;
import javax.security.auth.Subject;

/**
 * Created by sam on 24/7/16.
 */
public class View_Attendance extends Activity{
    TextView TV_disp_Subject , TV_disp_Attendance , TV_disp_attendance_percentage;
    Button BT_Calculate;
    EditText EDT_Attendance;
    UserListDbHelper uldh;
    UserListDbHelper2 uldh2;
    Integer spinner_subject_pos;
    String cal_att;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_attendance);
        TV_disp_Subject = (TextView) findViewById(R.id.textView_disp_subject);
        TV_disp_Attendance = (TextView) findViewById(R.id.textView_disp_attendance);
        EDT_Attendance = (EditText) findViewById(R.id.TotalClass);
        TV_disp_attendance_percentage = (TextView) findViewById(R.id.textView_disp_attendance_percentage);
        BT_Calculate = (Button) findViewById(R.id.button_calculate_attendance);

        Bundle p = getIntent().getExtras();
        String Spinner_pos = p.getString("SpinnerPos");

        if (Spinner_pos.equals("0"))
            spinner_subject_pos = 0;
        else if (Spinner_pos.equals("1"))
            spinner_subject_pos = 1;
        else if (Spinner_pos.equals("2"))
            spinner_subject_pos = 2;
        else if (Spinner_pos.equals("3"))
            spinner_subject_pos = 3;
        else if (Spinner_pos.equals("4"))
            spinner_subject_pos = 4;
        else if (Spinner_pos.equals("5"))
            spinner_subject_pos = 5;


        uldh2 = new UserListDbHelper2(getApplicationContext(), null, null, 3);
        Cursor check = uldh2.Checkdata();
        if (check != null) {
            check.moveToFirst();

            String Subject , att;
            Subject = check.getString(spinner_subject_pos);

            String attendance;
            attendance = check.getString(spinner_subject_pos+6);
            att = ""+attendance;
            cal_att = attendance;
            TV_disp_Subject.setText(Subject);
            TV_disp_Attendance.setText(att);
            EDT_Attendance.setText(attendance);
            Toast.makeText(getApplicationContext(),""+attendance,Toast.LENGTH_SHORT).show();
        }

        BT_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate_attendance_percentage(cal_att);
            }
        });


    }


    private void calculate_attendance_percentage(String att) {
        String classes_held = EDT_Attendance.getText().toString();
        int classes_held_integer=Integer.parseInt(classes_held);
        //Toast.makeText(getApplicationContext(),""+classes_held_integer , Toast.LENGTH_SHORT).show();

        int att_integer=Integer.parseInt(att);
        Toast.makeText(getApplicationContext(),att , Toast.LENGTH_SHORT).show();

        double percentage = (double)att_integer/classes_held_integer *100;
        float k = (float) Math.round(percentage * 100) / 100;
        TV_disp_attendance_percentage.setText(""+k );

    }
}
