package com.stylingandroid.datastore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

class TwoWayBinder<T>(
    private val liveData: LiveData<T>,
    private val updateListener: (T) -> Unit = {}
) : MutableLiveData<T>() {

    override fun onActive() {
        super.onActive()
        Timber.d("onActive()")
        liveData.observeForever(::setValue)
    }

    override fun setValue(newValue: T) {
        val changed = value != newValue
        Timber.d("setValue($newValue): $changed")
        super.setValue(newValue)
        if (changed) {
            updateListener(newValue)
        }
    }

    override fun onInactive() {
        Timber.d("onInactive()")
        liveData.removeObserver(::setValue)
        super.onInactive()
    }
}
