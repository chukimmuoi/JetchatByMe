package com.chukimmuoi.jetchatbyme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: JetchatByMe
 * Created by chukimmuoi on 16/11/24.
 */
/**
 * Được sử dụng để giao tiếp giữa các màn hình.
 * */
class MainViewModel : ViewModel() {

    private val _drawerShouldBeOpened = MutableStateFlow(false)
    var drawerShouldBeOpened = _drawerShouldBeOpened.asStateFlow()

    fun openDrawer() {
        _drawerShouldBeOpened.update { true }
    }

    fun resetOpenDrawerAction() {
        _drawerShouldBeOpened.update { false }
    }
}