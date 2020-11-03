package com.example.foodie_app_mp5;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    TextView mealTitle;
    TextView mealDescription;
    TextView mealIngredient;
    TextView mealCalories;
    TextView mealLink;
    Bundle bundle;
    ImageView image;
    int image_view;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mealTitle = findViewById(R.id.mealTitle);
        mealDescription = findViewById(R.id.mealDescription);
        mealIngredient = findViewById(R.id.mealIngredients);
        mealCalories = findViewById(R.id.mealCalories);
        mealLink = findViewById(R.id.mealLink);

        mealTitle.setText(getIntent().getStringExtra("Title"));
        mealDescription.setText(getIntent().getStringExtra("Description"));
        mealIngredient.setText(getIntent().getStringExtra("Ingredients"));
        mealCalories.setText(getIntent().getStringExtra("Calories"));
        mealLink.setText(getIntent().getStringExtra("Link"));

        bundle = this.getIntent().getExtras();
        image_view = bundle.getInt("image");
        image = findViewById(R.id.mealImage);
        image.setImageResource(image_view);



    }
}