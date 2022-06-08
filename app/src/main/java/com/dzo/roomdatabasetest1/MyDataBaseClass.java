package com.dzo.roomdatabasetest1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {user.class}, version = 1)
public abstract class MyDataBaseClass extends RoomDatabase {
    public abstract UserDao userDao();
}
