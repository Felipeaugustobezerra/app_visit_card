package br.com.dio.bussinesscard

import android.app.Application
import br.com.dio.bussinesscard.data.AppDataBase
import br.com.dio.bussinesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDataBase.getDatabase(this)}
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
    

}