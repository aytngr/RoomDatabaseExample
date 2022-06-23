package gr.aytn.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val repo = MainRepository(this)
//        repo.getUsers().observe(this, Observer {
//            Log.i("TAG","$it")
//        })

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.addUser(User(1, "aytn","gr"))
        mainViewModel.getUsers().observe(this, Observer {
            Log.i("TAG","$it")
        })



    }
}