package com.aeshian.cardtest.components;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aeshian.cardtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Indika on 2/16/2016.
 */
public class FoodSetAdapter extends ArrayAdapter<FoodSet> {

    private List<FoodSet> list;
    private Activity context;

    public FoodSetAdapter(Activity context,int resource, List<FoodSet> list) {
        super(context, resource, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = null;

        LayoutInflater inflater = context.getLayoutInflater();
        view = inflater.inflate(R.layout.foodset, null);

        final ViewHolder viewHolder = new ViewHolder();
        viewHolder.title = (TextView)view.findViewById(R.id.FoodTypeTitle);

        ViewHolder holder = (ViewHolder)view.getTag();
        holder.title.setText(list.get(position).FoodName);

        holder.recList = (RecyclerView)view.findViewById(R.id.cardlist);
        holder.recList.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.recList.setLayoutManager(llm);

        List<FoodItem> foodList = new ArrayList<>();
        for (int i=0; i< (int)(Math.random() * 20); i++){
            FoodItem item = new FoodItem();
            item.foodImageURL= Environment.getExternalStorageDirectory().getAbsolutePath() + "/food/Image.jpg";
            Log.d("Image URL : ", item.foodImageURL);
            item.foodName = "Food " + i;
            item.foodPrice = "$ " + i*2 + ".00";

            foodList.add(item);
        }

        holder.recList.setAdapter(new FoodItemAdapter(foodList));

        return view;
    }

    public static class ViewHolder{
        protected TextView title;
        protected FoodSet foodset;
        protected RecyclerView recList;
    }
}
