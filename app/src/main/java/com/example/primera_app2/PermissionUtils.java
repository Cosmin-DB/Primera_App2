package com.example.primera_app2;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {
    public static void askForPermissions(Activity activity) {
        List<String> permissionsToAsk = new ArrayList<>();
        int requestResult = 0;

        if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            // Ask for permission
            permissionsToAsk.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            // Ask for permission
            permissionsToAsk.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (permissionsToAsk.size() > 0) {
            ActivityCompat.requestPermissions(activity, permissionsToAsk.toArray(new String[permissionsToAsk.size()]), requestResult);
        }
    }
}
