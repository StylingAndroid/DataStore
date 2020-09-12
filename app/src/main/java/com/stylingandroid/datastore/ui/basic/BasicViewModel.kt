package com.stylingandroid.datastore.ui.basic

import androidx.datastore.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.stylingandroid.datastore.data.SimpleData
import com.stylingandroid.datastore.ui.TwoWayBinder
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BasicViewModel @Inject constructor(
    private val dataStore: DataStore<SimpleData>
) : ViewModel() {

    val text = dataStore.data
        .map { it.text }
        .asLiveData(viewModelScope.coroutineContext)

    val mutableText = TwoWayBinder(text) { newValue ->
        viewModelScope.launch {
            dataStore.updateData { simpleData ->
                simpleData.copy(
                    text = newValue
                )
            }
        }
    }
}
