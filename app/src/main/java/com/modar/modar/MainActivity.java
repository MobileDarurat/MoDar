package com.modar.modar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Identifier for the permission request
    private static final int CALL_PHONE_PERMISSIONS_REQUEST = 1;

    String[] name = {
            "Ambulance",
            "Derek",
            "Pemadam Kebakaran",
            "PAM",
            "PLN",
            "Polisi"
    } ;

    int[] init = {
            R.mipmap.ic_1,
            R.mipmap.ic_2,
            R.mipmap.ic_3,
            R.mipmap.ic_4,
            R.mipmap.ic_5,
            R.mipmap.ic_6
    } ;

    int[] notelp = {
            R.string.no_1,
            R.string.no_2,
            R.string.no_3,
            R.string.no_4,
            R.string.no_5,
            R.string.no_6
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //ask for permission if your phone is marshmallow
        if(Build.VERSION.SDK_INT == 23) {
            getPermissionDialPhone();
        }
        else {
            //do something here
        }


        CustomGrid adapter = new CustomGrid(MainActivity.this, init, name, notelp);
        GridView gridViewModar = (GridView)findViewById(R.id.gridModar);

        gridViewModar.setAdapter(adapter);

//        gridViewModar.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("Modar", "HAYO LOH KELUAR!");
//                Toast.makeText(MainActivity.this, "You Clicked at " + init[position], Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_aboutUs:
                Intent intent = new Intent(this, AboutActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void getPermissionDialPhone() {
        // 1) Use the support library version ContextCompat.checkSelfPermission(...) to avoid
        // checking the build version since Context.checkSelfPermission(...) is only available
        // in Marshmallow
        // 2) Always check for permission (even if permission has already been granted)
        // since the user can revoke permissions at any time through Settings
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            // The permission is NOT already granted.
            // Check if the user has been asked about this permission already and denied
            // it. If so, we want to give more explanation about why the permission is needed.
            if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                // Show our own UI to explain to the user why we need to read the contacts
                // before actually requesting the permission and showing the default UI
            }

            // Fire off an async request to actually get the permission
            // This will show the standard permission request dialog UI
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_PHONE_PERMISSIONS_REQUEST);
        }
    }

    // Callback with the request from calling requestPermissions(...)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == CALL_PHONE_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Dial Phone permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Dial Phone permission denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
