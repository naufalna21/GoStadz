package com.naufal.gostadzfix.data.resources.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.naufal.gostadzfix.data.resources.interfaces.UserDataSource;

import java.util.HashMap;
import java.util.Map;

//        db.collection("users").document(currentUser.getUid())

public class UserRemoteDataSource implements UserDataSource {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public boolean checkHasUser() {
        FirebaseUser currentUser = this.mAuth.getCurrentUser();
        if (currentUser != null) {
            return true;
        }
        return false;
    }

    public void login(String email, String password, UserDataSource.UserCallback callback) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    if (task.getResult().getUser() != null) {
                        callback.success(true);
                        return;
                    }
                }
                callback.error(new Throwable("Login gagal"));
            }
        });
    }

    public void signup(String firstname, String lastname, String email, String tanggallahir, String password, UserDataSource.UserCallback callback) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    if (task.getResult().getUser() != null) {
                        Map<String, Object> user = new HashMap<String, Object>();
                        user.put("firstname", firstname);
                        user.put("lastname", lastname);
                        user.put("email", email);
                        user.put("tanggalLahir", tanggallahir);
                        db.collection("users").document(task.getResult().getUser().getUid()).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                callback.success(true);
                                return;
                            }
                        });
                        return;
                    }
                }
                callback.error(new Throwable("Signup gagal"));
            }
        });
    }
}
