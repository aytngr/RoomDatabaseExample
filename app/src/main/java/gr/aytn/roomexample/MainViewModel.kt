package gr.aytn.roomexample

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private var mutableLiveData = MutableLiveData<List<User>>()
    val readAllData: LiveData<List<User>>
    private val repository: MainRepository

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository = MainRepository(userDao)
        readAllData = repository.readAllData
    }

    fun getUsers(): LiveData<List<User>> {
            return readAllData
    }
    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
    fun insertAllUsers(users: User){
        viewModelScope.launch(Dispatchers.IO) {
        repository.insertAllUsers(users)
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

}