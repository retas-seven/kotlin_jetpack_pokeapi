package com.example.app.presentation.mytest

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.common.StateNotice
import com.example.app.data.room.dao.UserDao
import com.example.app.data.room.entity.User
import com.example.app.use_case.SpeciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * テスト用ViewModel
 */
@HiltViewModel
class MyTestViewModel @Inject constructor (
    private val savedStateHandle: SavedStateHandle,
    private val userDao: UserDao,
): ViewModel() {
    fun seveUser(users: User) {
        viewModelScope.launch {
            userDao.insertAll(users)
        }
    }
}
