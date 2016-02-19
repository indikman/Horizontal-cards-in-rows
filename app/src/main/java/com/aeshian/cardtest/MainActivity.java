package com.aeshian.cardtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.aeshian.cardtest.components.FoodItem;
import com.aeshian.cardtest.components.FoodItemAdapter;
import com.aeshian.cardtest.components.FoodSet;
import com.aeshian.cardtest.components.FoodSetAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private LinearLayout layoutRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutRoot = (LinearLayout) findViewById(R.id.layoutRoot);
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            View listRow = getLayoutInflater().inflate(R.layout.listrow, layoutRoot, false);
            LinearLayout layoutRow = (LinearLayout) listRow.findViewById(R.id.layoutRow);
            for (int j = 0; j < (int)(Math.random() * 20); j++) {
                View view = getLayoutInflater().inflate(R.layout.card, layoutRow, false);
                ImageView imageView = (ImageView) view.findViewById(R.id.foodImage);
                imageView.setImageResource(R.drawable.moona);

                TextView foodName = (TextView)view.findViewById(R.id.FoodName);
                foodName.setText( "Food " + i + " - " + j);

                TextView foodPrice = (TextView)view.findViewById(R.id.FoodPrice);
                foodPrice.setText( "$" + (i*j) + ".00");

                layoutRow.addView(view);
            }
            layoutRoot.addView(listRow);
        }
    }

    public void onConfigurationChanges(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
