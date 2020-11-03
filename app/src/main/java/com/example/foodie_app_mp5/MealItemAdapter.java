package com.example.foodie_app_mp5;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {
    private ArrayList<MealItem> mData;
    private Context mContext;
    LayoutInflater inflater;
    EditText editTitle;
    EditText description;
    EditText ingredients;
    EditText calories;
    EditText link;
    private ViewGroup parent;
    private int viewType;
    private ViewHolder holder;
    private int position;
    MealItem foodItem;

    MealItemAdapter(Context context, ArrayList<MealItem> foodsArrayList) {
        this.mContext = context;
        this.mData = foodsArrayList;

    }

    void addContent(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        inflater = LayoutInflater.from(mContext);
        @SuppressLint("InflateParams")
        final View dialogView = inflater.inflate(R.layout.activity_dialog,null);
        dialogBuilder.setView(dialogView);

        editTitle = dialogView.findViewById(R.id.dialog_item_title);
        description = dialogView.findViewById(R.id.item_description);
        ingredients = dialogView.findViewById(R.id.item_ingredients);
        calories = dialogView.findViewById(R.id.item_calories);
        link = dialogView.findViewById(R.id.item_link);

        dialogBuilder.setPositiveButton ( "DONE", new DialogInterface.OnClickListener () {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = editTitle.getText ().toString ();
                String des = description.getText ().toString ();
                String ing = ingredients.getText ().toString ();
                String cal = calories.getText ().toString ();
                String lin = link.getText ().toString ();

                MealItem mealItem = new MealItem ( title, des, ing, cal, lin, 0 );
                if (0 < (title.length () + des.length () + ing.length () + cal.length ())) {
                    mData.add ( mData.size (), mealItem );

                    notifyItemInserted (mData.size () );

                }
            }
        } );

        dialogBuilder.setNegativeButton ( "CANCEL", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        } );

        dialogBuilder.create().show();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        this.viewType = viewType;

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        this.holder = holder;
        this.position = position;
        foodItem = mData.get(position);
        holder.bindItem(foodItem);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private TextView textTitle;
        private TextView textDescription;
        private ImageView imageViewFood;
        private MealItem currentFood;
        Bundle bundle;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.title);
            textDescription = itemView.findViewById(R.id.description);
            imageViewFood = itemView.findViewById(R.id.imageViewFood);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        void bindItem(MealItem currentFood){
            this.currentFood = currentFood;
            textTitle.setText(currentFood.getTitle());
            textDescription.setText(currentFood.getDescription());
            Glide.with(mContext).load(currentFood.getImage()).into(imageViewFood);
        }

        @Override
        public void onClick(View v) {

            foodItem = mData.get(getAdapterPosition());
            Intent intent = new Intent(mContext, DetailsActivity.class);

            // passing data to the item activity
            intent.putExtra("Title", foodItem.getTitle());
            intent.putExtra("Description", foodItem.getDescription());
            intent.putExtra("Ingredients", foodItem.getIngredient());
            intent.putExtra("Calories", foodItem.getCalories());
            intent.putExtra("Link", foodItem.getLink());

            bundle = new Bundle();
            bundle.putInt("image",foodItem.getImage());
            intent.putExtras(bundle);

            // start the activity
            mContext.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {
            currentFood = mData.get(getAdapterPosition());
            mData.remove(currentFood);
            notifyDataSetChanged();
            return true;
        }
    }

}