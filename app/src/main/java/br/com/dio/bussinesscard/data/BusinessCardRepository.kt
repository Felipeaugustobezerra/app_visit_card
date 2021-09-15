package br.com.dio.bussinesscard.data

import br.com.dio.bussinescard.data.BusinessCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val dao: BusinessCardDao) {
    fun insert(businessCard: BusinessCard) = runBlocking {
        launch (Dispatchers.IO){
            dao.insert(businessCard)
        }
    }

    fun getAll() = dao.getAll()
}