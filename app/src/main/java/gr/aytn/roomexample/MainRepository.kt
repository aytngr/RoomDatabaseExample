package gr.aytn.roomexample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.getAllUsers()

    fun addUser(user: User) {
        userDao.addUser(user)
    }
    fun insertAllUsers(users: User) {
        userDao.insertAllUsers(users)
    }
    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}