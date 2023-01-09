package com.naufal.gostadzfix.data.resources.interfaces;

public interface UserDataSource {
    public boolean checkHasUser();
    public void login(String email, String password, UserCallback callback);
    public void signup(String firstname, String lastname,String email, String tanggallahir, String password, UserCallback callback);

    public interface UserCallback {
        public void success(boolean success);
        public void error(Throwable err);
    }
}
