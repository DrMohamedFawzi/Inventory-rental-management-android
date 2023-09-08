package com.msnit.inventoryrentalmanagement.db;

import android.content.Context;

import androidx.room.Room;

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

}
