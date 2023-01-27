package com.naufal.gostadzfix.data.resources.repository;

import android.util.Log;

import com.naufal.gostadzfix.data.model.User;
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
    public void signup(String firstname, String lastname,String email,String provinsi,String kabupaten_kota, String kecamatan, String tanggallahir,String nophone, String password, UserDataSource.UserCallback callback){
        this.userRemoteDataSource.signup(firstname, lastname, email,provinsi,kabupaten_kota,kecamatan, tanggallahir,nophone, password, new UserDataSource.UserCallback() {
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
    public void getUserbyLogin(UserDataSource.GetUserCallback callback){
        this.userRemoteDataSource.getUserbyLogin(new UserDataSource.GetUserCallback() {
            @Override
            public void success(User user) {
                callback.success(user);
            }

            @Override
            public void error(Throwable err) {
                callback.error(new Throwable("Perubahan gagal"));
            }
        });
    }
    public void editDataUsers(User user, UserDataSource.UserCallback callback){
        this.userRemoteDataSource.editDataUsers(user, new UserDataSource.UserCallback() {
            @Override
            public void success(boolean success) {
                callback.success(true);
            }

            @Override
            public void error(Throwable err) {
                callback.error(new Throwable("Perubahan gagal"));
            }
        });
    }
}

