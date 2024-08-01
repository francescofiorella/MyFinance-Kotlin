package com.frafio.myfinance.data.repositories

import androidx.lifecycle.LiveData
import com.frafio.myfinance.MyFinanceApplication
import com.frafio.myfinance.data.models.Income
import com.frafio.myfinance.data.storages.MyFinanceDatabase

class LocalIncomeRepository {
    private val incomeDao =
        MyFinanceDatabase.getDatabase(MyFinanceApplication.instance).incomeDao()

    fun getAll(): LiveData<List<Income>> = incomeDao.getAll()

    fun insertIncome(income: Income) = incomeDao.insertIncome(income)

    fun updateIncome(income: Income) = incomeDao.updateIncome(income)

    fun deleteAll() = incomeDao.deleteAll()

    fun deleteIncome(income: Income) = incomeDao.deleteIncome(income)

    fun updateTable(incomes: List<Income>) = incomeDao.updateTable(*incomes.toTypedArray())
}