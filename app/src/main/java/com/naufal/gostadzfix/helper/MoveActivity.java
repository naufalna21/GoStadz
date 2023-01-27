package com.naufal.gostadzfix.helper;

import android.content.Context;
import android.content.Intent;
import android.view.View;

//import com.naufal.gostadzfix.ui.BiodataScreen;
import com.naufal.gostadzfix.ui.BiodataScreen;
import com.naufal.gostadzfix.ui.HomeScreen;
import com.naufal.gostadzfix.ui.HomeScreenJamaah;
import com.naufal.gostadzfix.ui.HomeScreenUstadz;
import com.naufal.gostadzfix.ui.ListOrderUstadzScreen;
import com.naufal.gostadzfix.ui.LoginScreen;
import com.naufal.gostadzfix.ui.PlayVideoScreen;
import com.naufal.gostadzfix.ui.RegistrasiScreen;
import com.naufal.gostadzfix.ui.ScheduleOrderUstadzScreen;
import com.naufal.gostadzfix.ui.VideoScreen;

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
    public static void toVideoAndCeramahScreen (Context ctx){
        ctx.startActivity(new Intent(ctx, VideoScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public static void toHomeScreenUstadz (Context ctx){
        ctx.startActivity(new Intent(ctx, HomeScreenUstadz.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public static void toBiodataScreen(Context ctx){
        ctx.startActivity(new Intent(ctx, BiodataScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public static void toListUstadz(Context ctx){
        ctx.startActivity(new Intent(ctx, ListOrderUstadzScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public static void toPlayVideoScreen(Context ctx){
        ctx.startActivity(new Intent(ctx, PlayVideoScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public static void toScheduleOrderUstadzScreen(Context ctx){
        ctx.startActivity(new Intent(ctx, ScheduleOrderUstadzScreen.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
