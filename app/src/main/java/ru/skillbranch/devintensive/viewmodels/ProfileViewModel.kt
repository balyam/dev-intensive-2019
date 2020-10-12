package ru.skillbranch.devintensive.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.devintensive.models.Profile
import ru.skillbranch.devintensive.repositories.PreferencesRepository

class ProfileViewModel: ViewModel (){

    private val repository: PreferencesRepository = PreferencesRepository
    private val profileData = MutableLiveData<Profile>()

    init {
        Log.d("M_ProfileViewModel", "init ViewModel")
        profileData.value = repository.getProfile()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("M_ProfileViewModel", "ViewModel was cleared")
    }

    fun getProfileData(): LiveData<Profile> = profileData

    fun setProfileData(profile: Profile){
        repository.setProfile(profile)
        profileData.value = profile
    }


}