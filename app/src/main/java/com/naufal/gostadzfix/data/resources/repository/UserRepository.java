package com.naufal.gostadzfix.data.resources.repository;

import android.util.Log;

import com.naufal.gostadzfix.data.resources.interfaces.UserDataSource;

public class UserRepository {
    private UserDataSource userRemoteDataSource;

    public boolean checkHasUser() {
        return this.userRemoteDataSource.checkHasUser();
    }
    public UserRepository(UserDataSource userRemoteDataSource) {
        this.userRemoteDataSource = userRemoteDataSource;
    }
    public void login(String email, String password, UserDataSource.UserCallback callback) {
        this.userRemoteDataSource.login(email, password, new UserDataSource.UserCallback() {
            @Override
            public void success(boolean success) {
                callback.success(true);
            }
            @Override
            public void error(Throwable err) {
                callback.error(err);
            }
        });
    }
    public void signup(String firstname, String lastname,String email, String tanggallahir, String password, UserDataSource.UserCallback callback){
        this.userRemoteDataSource.signup(firstname, lastname, email, tanggallahir, password, new UserDataSource.UserCallback() {
            @Override
            public void success(boolean success) {
                callback.success(true);
            }
            @Override
            public void error(Throwable err) {
                callback.error(err);
            }
        });
    }
}
