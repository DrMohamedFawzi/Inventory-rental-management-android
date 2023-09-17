package com.msnit.inventoryrentalmanagement.db;

import android.content.Context;

import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

public class DbConnection {
    private final RentalDatabase db;

    public DbConnection(Context applicationContext) {
        db = Room.databaseBuilder(applicationContext,
                RentalDatabase.class,
                "rental_db"
        ).build();
    }

    public RentalDatabase getDb() {
        return db;
    }

    public static DbConnection getDb(Context context) {
        return new DbConnection(context.getApplicationContext());
    }

    @NotNull
    public Object itemDao() {
        return null;
    }
}