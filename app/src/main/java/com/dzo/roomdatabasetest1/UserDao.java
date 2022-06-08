package com.dzo.roomdatabasetest1;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insertData(user user);
    @Query("SELECT EXISTS(SELECT * FROM User WHERE uid = :userId)")
    Boolean is_exist(int userId);


    @Query("SELECT * FROM User")
    List<user> getallusers();

    @Query("DELETE FROM User WHERE uid = :id")
    void deleteById(int id);

    @Query("UPDATE User SET first_name = :fname, last_name=:lname WHERE uid = :id")
    void updateById(int id, String fname, String lname);

}
