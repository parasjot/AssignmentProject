package com.example.naviassignmentproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naviassignmentproject.model.ClosedPrModel
import com.example.naviassignmentproject.model.ClosedPrModelItem
import com.example.naviassignmentproject.network.ClosedPrNetworkManager
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class ClosedPrViewModel : ViewModel() {
    var closedPrList = MutableLiveData<List<ClosedPrModelItem>?>()

    fun getClosedPrList() {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("CoroutineExceptionHandler got $exception")
        }        //get api list
        viewModelScope.launch(handler) {
            val result = ClosedPrNetworkManager.getClosedPrList()
            closedPrList.value = result
        }
    }
}