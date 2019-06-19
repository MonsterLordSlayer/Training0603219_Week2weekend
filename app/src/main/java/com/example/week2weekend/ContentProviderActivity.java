package com.example.week2weekend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.week2weekend.DatabaseContract.FIELD_DOB;
import static com.example.week2weekend.DatabaseContract.FIELD_FAV;
import static com.example.week2weekend.DatabaseContract.FIELD_NAME;

public class ContentProviderActivity extends BaseActivity {
    DatabaseHelper databaseHelper;
    RecyclerView rvCelebRecyclerView;
    ArrayList<Celebrity> celebritylistfromProvider=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        databaseHelper=new DatabaseHelper(this);
        getMusicUsingContentProvider();
        initializeRecyclerView();

    }
    private void initializeRecyclerView(){
        rvCelebRecyclerView=findViewById(R.id.rvCelebrityProvider);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        CelebrityRecyclerViewAdapterforProvider celebRecyclerViewAdapter=new CelebrityRecyclerViewAdapterforProvider(celebritylistfromProvider);

        rvCelebRecyclerView.setLayoutManager(layoutManager);
        rvCelebRecyclerView.setAdapter(celebRecyclerViewAdapter);

    }
    public void getMusicUsingContentProvider() {
        Uri uri = CelebrityProviderContract.CelebrityEntry.CONTENT_URI;
        Cursor cursor = this.getContentResolver().query(uri,null,null,null,null);
        if (cursor.moveToFirst()){

            do{
                Toast.makeText(this,

                        cursor.getString(cursor.getColumnIndex(FIELD_NAME)) +
                                ", " +  cursor.getString(cursor.getColumnIndex( FIELD_DOB)) +
                                ", " + cursor.getString(cursor.getColumnIndex( FIELD_FAV)),
                        Toast.LENGTH_SHORT).show();
                Log.d("AngelKiller", cursor.getString(cursor.getColumnIndex(FIELD_NAME)) +
                        ", " +  cursor.getString(cursor.getColumnIndex( FIELD_DOB)) +
                        ", " + cursor.getString(cursor.getColumnIndex( FIELD_FAV)));
                String name=cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String dob=cursor.getString(cursor.getColumnIndex(FIELD_DOB));
                String fav=cursor.getString(cursor.getColumnIndex(FIELD_FAV));
                celebritylistfromProvider.add(new Celebrity(name,dob,fav));



            } while (cursor.moveToNext());
        }
        else{
            Log.d("MLS", "getMusicUsingContentProvider: ");
        }
//
//        //Delete
////        this.getContentResolver().delete(uri,
////                ContentProviderContract.MovieEntry.COLUMN_NAME + "=?",
////                new String[]{"Gone in 60 seconds"});
//
//        ContentValues values = new ContentValues();
//
//        values.clear();
//        values.put(ContentProviderContract.MovieEntry.COLUMN_NAME, "BLA");
//        //...
//        getApplicationContext().getContentResolver().insert(uri,values);
    }
}
