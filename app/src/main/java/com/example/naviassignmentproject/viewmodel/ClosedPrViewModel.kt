package com.example.naviassignmentproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviassignmentproject.model.ClosedPrModelItem
import com.example.naviassignmentproject.network.ClosedPrNetworkManager
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ClosedPrViewModel : ViewModel() {
    var closedPrList = MutableLiveData<List<ClosedPrModelItem>?>()

    fun getClosedPrList() {
        val handler = CoroutineExceptionHandler { _, exception ->
            if (exception is SocketException || exception is SocketTimeoutException || exception is UnknownHostException)
                closedPrList.value = null
        }
        //get api list
        viewModelScope.launch(handler) {
            val result = ClosedPrNetworkManager.getClosedPrList()
            closedPrList.value = result
        }
    }
}