package com.santoo.homedatabaseproject.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.santoo.homedatabaseproject.dao.student_dao
import com.santoo.homedatabaseproject.dao.user_dao
import com.santoo.homedatabaseproject.entity.Student
import com.santoo.homedatabaseproject.entity.User

@Database(
    entities = [(User::class), (Student::class)],
    version = 1,
    exportSchema = false
)
abstract class userDB : RoomDatabase() {

    abstract fun getStudentDAO() : student_dao
//    abstract fun getStudentDAO(): StudentDAO
    abstract fun getUserDAO(): user_dao    //abstract fun getuserdao le user_dao return garcha. user_dao ko instance getuserDao lai deko
    //kina bhane pach multiple query huncha hamile kunai euta use garna lai testo gareko
    companion object {
        @Volatile   //sabai thread lai instance dina cha bhane volatile lagaucha
        private var instance: userDB? = null  //userDB ko instance banako
        fun getInstance(context: Context): userDB {     //yesle userDB ko instance farkaucha
            if (instance == null) {
                synchronized(userDB::class) { //pakh malai object banauna de bhancha
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, //fragment bata access garna lai applicationcontect gareko
                userDB::class.java,   //userdb ko object banayo
                "userDB"
            ).build()
    }
}