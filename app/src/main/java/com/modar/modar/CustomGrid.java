package com.modar.modar;

/**
 * Created by Jonathan Simananda on 03/05/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final int[] init;
    private final String[] name;
    private final int[] notelp;

    public CustomGrid(Context c, int[] init, String[] name, int[] notelp) {
        mContext = c;
        this.init = init;
        this.name = name;
        this.notelp = notelp;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.txtGrid);
            Button btn = (Button) grid.findViewById(R.id.btnGrid);
            //add some listener here
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //Log.d("Modar", "PLEASE BISA DONK");
                    Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                    phoneIntent.setData(Uri.parse("tel:" + notelp[position]));
//                    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                        // TODO: Consider calling
//                        //    ActivityCompat#requestPermissions
//                        // here to request the missing permissions, and then overriding
//                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                        //                                          int[] grantResults)
//                        // to handle the case where the user grants the permission. See the documentation
//                        // for ActivityCompat#requestPermissions for more details.
//
//                        Log.d("Modar", "PLEASE BISA part 2");
//
//                        mContext.startActivity(phoneIntent);
//                    }
                    mContext.startActivity(phoneIntent);
                }
            });

            textView.setText(name[position]);
            btn.setBackgroundResource(init[position]);
            //btn.setText(init[position]);
            //imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }
//        grid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("test","testdata");
//            }
//        });

        return grid;
    }
}