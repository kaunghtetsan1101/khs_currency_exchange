package com.khs.caregiver.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.khs.exchange.utils.Event
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class NavigationDispatcher @Inject constructor() {
    private val navigationEmitter = MutableLiveData<Event<NavigationCommand>>()
    val navigationCommands: LiveData<Event<NavigationCommand>> = navigationEmitter

    fun emit(navigationCommand: NavigationCommand) {
        navigationEmitter.value = Event(navigationCommand)
    }
}

typealias NavigationCommand = (NavController) -> Unit