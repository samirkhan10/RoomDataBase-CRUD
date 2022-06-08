package com.dzo.roomdatabasetest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText id,fname,lname;
    TextView lbl;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=findViewById(R.id.t1);
        fname=findViewById(R.id.t2);
        lname=findViewById(R.id.lname);

        b1=findViewById(R.id.inserBtn);
        b2=findViewById(R.id.FetchBtn);
        lbl=findViewById(R.id.textForShow);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDataBaseClass db = Room.databaseBuilder(getApplicationContext(),
                        MyDataBaseClass.class, "room_db").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                Boolean check=userDao.is_exist(Integer.parseInt(id.getText().toString()));
                if(check==false) {
                    userDao.insertData(new user(Integer.parseInt(id.getText().toString()), fname.getText().toString(), lname.getText().toString()));
                    id.setText("");
                    fname.setText("");
                    lname.setText("");
                    lbl.setText("Inserted Successfully");
                }
                else
                {
                    id.setText("");
                    fname.setText("");
                    lname.setText("");
                    lbl.setText("Record is existing");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), fetchdata.class));
            }
        });
    }
}