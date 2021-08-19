package com.frafio.myfinance.ui.home.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.frafio.myfinance.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class MenuViewModelFactory() : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MenuViewModel() as T
    }
}