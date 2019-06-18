package com.example.enesha.cuisine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipesActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Model> data;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<>();

        data.add(
                new Model(
                        1,
                        "Pilaf with lamb",
                        "Ingredients: meat, rice, carrots, onions, vegetable oil, salt",
                        R.drawable.food));

        data.add(
                new Model(
                        2,
                        "Pork kebab marinated in vinegar",
                        "Ingredients: pork, onion, vinegar, barbecue seasoning, salt",
                        R.drawable.food));
        data.add(
                new Model(
                        3,
                        "Dumplings",
                        "Ingredients: meat, milk, salt, vegetable oil, flour...",
                        R.drawable.food));

        data.add(
                new Model(
                        4,
                        "Chicken with a secret",
                        "Ingredients: chicken, champignons, cheese, onion, garlic, greens, mayonnaise, salt",
                        R.drawable.food));
        data.add(
                new Model(
                        5,
                        "Мясо в томатном соусе",
                        "Ingredients:",
                        R.drawable.food));

        data.add(
                new Model(
                        6,
                        "Мясо в кляре",
                        "Ingredients:chicken, champignons, cheese, onion, garlic, greens, mayonnaise, salt",
                        R.drawable.food));



        adapter=new CustomAdapter(this, data);
        recyclerView.setAdapter(adapter);

        //data = new ArrayList<RecipeModel>();
        //for (int i = 0; i < 8; i++) {
        //data.add(new RecipeModel(
        //"aa"+i,
        // i+"",
        //  i,
        //i
        //));
        // }

//        removedItems = new ArrayList<Integer>();
//
//        adapter = new CustomAdapter(data, new ArrayList<Model>() {
////            @Override
////            public void onItemClicked(RecipeModel recipeModel) {
////                openRecipe(recipeModel);
////            }
////        });
//        recyclerView.setAdapter(adapter);
    }

//    private void openRecipe(RecipeModel recipeModel){
//        Intent intent = new Intent(this, RecipeActivity.class);
//        intent.putExtra(RecipeActivity.KEY_OBJECT, recipeModel);
//        startActivity(intent);
//    }


}
