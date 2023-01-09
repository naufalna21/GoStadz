package com.naufal.gostadzfix.helper;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.naufal.gostadzfix.ui.HomeScreen;
import com.naufal.gostadzfix.ui.HomeScreenJamaah;
import com.naufal.gostadzfix.ui.LoginScreen;
import com.naufal.gostadzfix.ui.RegistrasiScreen;

public class MoveActivity {
    public static void toLoginScreen (Context ctx){
        ctx.startActivity(new Intent(ctx, LoginScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public static void toRegistrasiScreen(Context ctx) {
        ctx.startActivity(new Intent(ctx, RegistrasiScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public static void toHomeScreen(Context ctx) {
        ctx.startActivity(new Intent(ctx, HomeScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public static void toHomeScreenJamaah(Context ctx){
        ctx.startActivity(new Intent(ctx, HomeScreenJamaah.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
