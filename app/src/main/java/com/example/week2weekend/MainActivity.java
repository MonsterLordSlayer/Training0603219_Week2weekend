package com.example.week2weekend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends BaseActivity {
    EditText edTypeName;
    EditText edTypeDOB;
    Toolbar toolbar;
    DatabaseHelper databaseHelper;
    RecyclerView rvCelebRecyclerView;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTypeName=findViewById(R.id.edTypeName);
        edTypeDOB=findViewById(R.id.edTypeDOB);
        databaseHelper = new DatabaseHelper(this);

        initializeRecyclerView();



    }
    public void OnClick(View v){

        String name=edTypeName.getText().toString();
        String dob=edTypeDOB.getText().toString();
        if (!name.isEmpty()){
            databaseHelper.insertCelebrity(new Celebrity(name,dob,"no"));
        }
        for (Celebrity celebrity:databaseHelper.queryForAllCelebrityRecords()){
            Log.d("TAG", String.format(Locale.US,"%s %s %s",celebrity.getName(),celebrity.getDob(),celebrity.getFav()));
        }
        ((CelebrityRecyclerViewAdapter)rvCelebRecyclerView.getAdapter()).addCelebrity(new Celebrity(name,dob,"no"));



    }

    private void initializeRecyclerView(){
        rvCelebRecyclerView=findViewById(R.id.rvCelebrity);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        CelebrityRecyclerViewAdapter celebRecyclerViewAdapter=new CelebrityRecyclerViewAdapter(databaseHelper.queryForAllCelebrityRecords());

        rvCelebRecyclerView.setLayoutManager(layoutManager);
        rvCelebRecyclerView.setAdapter(celebRecyclerViewAdapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
