package com.modar.modar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        CustomGrid adapter = new CustomGrid(MainActivity.this, init, name);
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
}
