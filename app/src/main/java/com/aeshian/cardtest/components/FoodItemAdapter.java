package com.aeshian.cardtest.components;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aeshian.cardtest.R;

import java.io.File;
import java.util.List;

/**
 * Created by Indika on 2/16/2016.
 */
public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemHolder> {

    private List<FoodItem> foodItems;


    public FoodItemAdapter(List<FoodItem> foodList){
        this.foodItems = foodList;
    }

    @Override
    public FoodItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card, parent, false);
        return new FoodItemHolder(itemView);

    }

    @Override
    public void onBindViewHolder(FoodItemHolder holder, int position) {
        //Generating the cards
        FoodItem item = foodItems.get(position);

        //get the file name and place the image
        File image = new File(item.foodImageURL);

        if(image.exists()){

            Bitmap foodImage = BitmapFactory.decodeFile(image.getAbsolutePath());
            holder.vFoodImage.setImageBitmap(foodImage);
        }else{
            Log.d("Image URL : ", "No image!");
        }

        holder.vFoodName.setText(item.foodName);
        holder.vFoodPrice.setText(item.foodPrice);
    }

    @Override
    public int getItemCount() {
        return  foodItems.size();
    }


    public static class FoodItemHolder extends RecyclerView.ViewHolder{
        protected ImageView vFoodImage;
        protected TextView vFoodName;
        protected TextView vFoodPrice;

            public FoodItemHolder(View v){
            super(v);
            vFoodImage = (ImageView)v.findViewById(R.id.foodImage);
            vFoodName = (TextView)v.findViewById(R.id.FoodName);
            vFoodPrice = (TextView)v.findViewById(R.id.FoodPrice);
        }
    }
}
