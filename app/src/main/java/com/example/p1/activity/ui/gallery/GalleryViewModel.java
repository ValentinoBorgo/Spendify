package com.example.p1.activity.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> userInfo = new MutableLiveData<>();

    public LiveData<String> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String info) {
        userInfo.setValue(info);
    }

}
