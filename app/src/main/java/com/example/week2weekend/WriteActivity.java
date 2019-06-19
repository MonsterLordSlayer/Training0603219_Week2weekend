package com.example.week2weekend;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteActivity extends BaseActivity {
    EditText etWrite;
    Button btWrite;
    TextView tvRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        etWrite=findViewById(R.id.etWrite);
        btWrite=findViewById(R.id.btWrite);
        tvRead=findViewById(R.id.tvRead);


    }
    public void write(View v){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new
                    File(getFilesDir()+File.separator+"MyFile.txt")));
            bufferedWriter.write(etWrite.getText().toString());

            bufferedWriter.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void read(View v){

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new
                    File(getFilesDir()+File.separator+"MyFile.txt")));
            String read;
            StringBuilder builder = new StringBuilder("");

            while((read = bufferedReader.readLine()) != null){
                builder.append(read);
            }
            tvRead.setText(builder.toString());

            bufferedReader.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
