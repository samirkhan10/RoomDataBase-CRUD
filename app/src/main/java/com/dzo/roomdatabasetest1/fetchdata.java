package com.dzo.roomdatabasetest1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class fetchdata extends AppCompatActivity {

    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        getroomdata();
    }

    public void getroomdata()
    {
        MyDataBaseClass db = Room.databaseBuilder(getApplicationContext(),
                MyDataBaseClass.class, "room_db").allowMainThreadQueries().build();
        UserDao userDao = db.userDao();

        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<user> users=userDao.getallusers();

        myadapter adapter=new myadapter(users);
        recview.setAdapter(adapter);
    }
}