package com.naufal.gostadzfix.data.resources.interfaces;

import com.naufal.gostadzfix.data.model.User;

public interface UserDataSource {
    public boolean checkHasUser();
    public void login(String email, String password, UserCallback callback);
    public void signup(String firstname, String lastname,String email,String provinsi, String kabupaten_kota, String kecamatan, String tanggallahir,String nophone, String password, UserCallback callback);
    public void getUserbyLogin(GetUserCallback callback);
    public void editDataUsers(User user, UserCallback callback);


    public interface UserCallback {
        public void success(boolean success);
        public void error(Throwable err);
    }
    public interface GetUserCallback {
        public void success(User user);
        public void error(Throwable err);
    }

}
