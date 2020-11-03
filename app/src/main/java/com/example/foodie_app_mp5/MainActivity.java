package com.example.foodie_app_mp5;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.example.foodie_app_mp5.R.array.item_calories;
import static com.example.foodie_app_mp5.R.array.item_descriptions;
import static com.example.foodie_app_mp5.R.array.item_images;
import static com.example.foodie_app_mp5.R.array.item_ingredients;
import static com.example.foodie_app_mp5.R.array.item_links;
import static com.example.foodie_app_mp5.R.array.item_titles;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MealItem> mData;
    private MealItemAdapter foodAdapter;
    private int gridColumnCount;
    MealItem currentFood;
    String[] itemTitle;
    String[] itemDescription;
    String[] itemIngredient;
    String[] itemCalories;
    String[] itemLink;
    TypedArray itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.food_toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        setSupportActionBar(toolbar);

        gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        mData = new ArrayList<>();
        foodAdapter = new MealItemAdapter(this, mData);

        recyclerView.setAdapter(foodAdapter);

        loadFoodsData();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                foodAdapter.addContent();
            }
        });
    }

    private void loadFoodsData() {

        mData.clear();
        itemImage = getResources().obtainTypedArray( item_images);
        itemTitle = getResources().getStringArray( item_titles);
        itemDescription = getResources().getStringArray( item_descriptions);
        itemIngredient = getResources().getStringArray( item_ingredients);
        itemCalories = getResources().getStringArray( item_calories);
        itemLink = getResources().getStringArray( item_links);

        for(int i=0; i<itemTitle.length; i++){

            currentFood = new MealItem(itemTitle[i],itemDescription[i], itemIngredient[i],itemCalories[i],itemLink[i], itemImage.getResourceId(i,0));
            mData.add(currentFood);
        }

        foodAdapter.notifyDataSetChanged();
        itemImage.recycle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}