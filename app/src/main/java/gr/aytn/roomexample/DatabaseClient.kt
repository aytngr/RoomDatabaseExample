package gr.aytn.roomexample

import android.content.Context
import androidx.room.Room

class DatabaseClient() {
//    val appDatabase = Room.databaseBuilder(
//        context,
//        AppDatabase::class.java,
//        "My Database")
//        .build()

    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase{
        synchronized(this){
            var instance = INSTANCE
            if(instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }
}