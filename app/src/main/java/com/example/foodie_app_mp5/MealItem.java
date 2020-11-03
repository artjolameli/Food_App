package com.example.foodie_app_mp5;

public class MealItem {

    private String Item_title;
    private String Item_description;
    private String Item_ingredient;
    private String Item_calories;
    private String Item_link;
    private int Item_image;

    public MealItem (String title, String description, String ingredient, String calories, String link, int image){

       Item_title = title;
       Item_description = description;
       Item_ingredient = ingredient;
       Item_calories = calories;
       Item_link = link;
       Item_image = image;
    }

    public String getTitle(){
        return Item_title;
    }

    public String getDescription(){
        return Item_description;
    }

    public String getIngredient(){
        return Item_ingredient;
    }

    public String getCalories(){
        return Item_calories;
    }

    public String getLink(){
        return Item_link;
    }

    public int getImage(){
        return Item_image;
    }
}