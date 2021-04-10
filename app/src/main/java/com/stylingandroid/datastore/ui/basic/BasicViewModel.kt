package com.stylingandroid.datastore.ui.basic

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.stylingandroid.datastore.data.ComplexData
import com.stylingandroid.datastore.data.External
import com.stylingandroid.datastore.data.SimpleData
import com.stylingandroid.datastore.ui.TwoWayBinder
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BasicViewModel @Inject constructor(
    private val complexDataStore: DataStore<ComplexData>
) : ViewModel() {

    val text = complexDataStore.data
        .map { it.text }
        .asLiveData(viewModelScope.coroutineContext)

    val mutableText = TwoWayBinder(text) { newValue ->
        viewModelScope.launch {
            complexDataStore.updateData { complexData ->
                complexData.copy(
                    text = newValue,
                    simpleData = SimpleData(text = newValue),
                    internalEnum = ComplexData.Internal.ONE,
                    externalEnum = External.TWO,
                    oneofString = "The meaning of life, the universe, and everything"
                )
            }
        }
    }
}
