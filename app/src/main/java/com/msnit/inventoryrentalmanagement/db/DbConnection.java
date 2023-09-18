package com.msnit.inventoryrentalmanagement.db;

import android.content.Context;

import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

public class DbConnection {
    private  final RentalDatabase db;

    public DbConnection(Context applicationContext) {
        db = Room.databaseBuilder(applicationContext,
                RentalDatabase.class,
                "rental_db"
        ).build();
    }

    public RentalDatabase getDb() {
        return db;
    }

    public static RentalDatabase getDb(Context context) {
        return Room.databaseBuilder(context,
                RentalDatabase.class,
                "rental_db"
        ).build();
    }

}