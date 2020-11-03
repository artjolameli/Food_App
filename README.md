# Food_App
Android Application that allows the user to choose their favorite food and add/delete food that they do not want from their app.

Here is a video of the app:
https://youtu.be/VwwWNzs15CE

Specifications:
Create a Foodie App to display editable/removable MealItems in a RecyclerView with the opportunity to either click on an item and be brought to a new Activity that displays all the details for that MealItem, or long-click on an item to remove it from the list.

Classes :
1. MainActivity
2. AddItemActivity
3. MealItem
4. MealItemAdapter with Nested MealItemHolder class
Use of a RecyclerView with GridLayoutManager to display all MealItems in the MainActivity
In the XML, there is a CardView that contains Each MealItem with its Image, Title, Description
Each MealItem has an OnLongClickListener so that a MealItem can be removed by long clicking on it and confirming Removal
Each MealItem has an OnClickListener so that when a MealItem is clicked a new Activity  is started displaying all its details (Image, Title, Description, Ingredients, Calories, Link to online Recipe)
The MainActivity should also have a Floating Action Button so the user can ADD a new MealItem to the List via the AddItemActivity you will create. 
The Application should provide different layouts for different devices and screen sizes to make the best use of available real estate
The Application should provide a translated strings file for at least 1 additional language

