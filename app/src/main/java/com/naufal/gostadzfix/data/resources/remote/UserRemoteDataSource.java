package com.naufal.gostadzfix.data.resources.remote;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.naufal.gostadzfix.data.model.User;
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

    public void signup(String firstname, String lastname, String email, String provinsi, String kabupaten_kota, String kecamatan, String tanggallahir, String nophone, String password, UserDataSource.UserCallback callback) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    if (task.getResult().getUser() != null) {
                        Map<String, Object> user = new HashMap<String, Object>();
                        user.put("firstname", firstname);
                        user.put("lastname", lastname);
                        user.put("email", email);
                        user.put("provinsi", provinsi);
                        user.put("kabupaten_kota", kabupaten_kota);
                        user.put("kecamatan", kecamatan);
                        user.put("tanggalLahir", tanggallahir);
                        user.put("nophone", nophone);
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

    public void getUserbyLogin(GetUserCallback callback) {
        db.collection("users").document(mAuth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult() != null) {
                    DocumentSnapshot result = task.getResult();

                    User user = new User(result.get("firstname").toString(), result.get("lastname").toString(), result.get("tanggalLahir").toString(), result.get("provinsi").toString(), result.get("kabupaten_kota").toString(), result.get("kecamatan").toString(), result.get("nophone").toString());
                    callback.success(user);
                }
            }
        });
    }

    @Override
    public void editDataUsers(User user, UserCallback callback) {
        Map<String, Object> update_user = new HashMap<String, Object>();
        update_user.put("firstname", user.getFirstname());
        update_user.put("lastname", user.getLastname());
        update_user.put("tanggalLahir", user.getTanggallahir());
        update_user.put("nophone", user.getNophone());
        update_user.put("kabupaten_kota", user.getKabupaten_kota());
        update_user.put("provinsi", user.getProvinsi());
        update_user.put("kecamatan", user.getKecamatan());

        db.collection("users").document(mAuth.getUid()).update(update_user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                callback.success(true);
                return;
            }
        });
        return;
    }
}

