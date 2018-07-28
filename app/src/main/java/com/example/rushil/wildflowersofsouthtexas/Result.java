package com.example.rushil.wildflowersofsouthtexas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
//import android.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;


/**
 * Created by Rushil on 10-Feb-17.
 */
public class Result extends AppCompatActivity implements SearchView.OnQueryTextListener
{
    String[] c_name={"Blue Curls","Drummond's Phlox","Globe Mallow",
            "Indian Blanket","Lantana","Meado Pink",
            "Nipple Cactus","Prinkly Popy","Spider Wort"};

    int[] c_flags={R.drawable.blue_curls,R.drawable.drummonds_phlox,R.drawable.globemallow,
                R.drawable.indianblanket,R.drawable.lantana,R.drawable.meadowpink,
                R.drawable.nipple_cactus,R.drawable.prickly_poppy,R.drawable.spiderwort};

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Country> arrayList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        int count=0;
        for(String Name : c_name)
        {
            arrayList.add(new Country(Name,c_flags[count]));
            count++;
        }

        adapter = new RecyclerAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem= menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText=newText.toLowerCase();
        ArrayList<Country>newList = new ArrayList<>();
        for(Country country : arrayList)
        {
            String name=  country.getName().toLowerCase();
            if(name.contains(newText))
            {
                newList.add(country);
            }

        }

        adapter.setFilter(newList);
        return true;

    }


}
