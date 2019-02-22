package com.example.dell.notmyapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtten, edtnam;
    Button btnThem, btnXoa, btnSua;
    Spinner spbh;

    ArrayList<Song> arrSong;
    SpinnerAdapter songAdapter = null;
    int viTriChon = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arrSong= new ArrayList<Song>();
        themCung(arrSong);


        songAdapter = new SpinnerAdapter(this,R.layout.spinner_song,arrSong);
        spbh.setAdapter(songAdapter);
        spbh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                viTriChon = i;
                Song s = arrSong.get(i);
                edtten.setText(s.getName());
                edtnam.setText(s.getYear());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    void anhxa(){
        edtten = findViewById(R.id.edt_ten);
        edtnam = findViewById(R.id.edt_nam);
        btnThem= findViewById(R.id.btn_Them);
        btnXoa = findViewById(R.id.btn_Xoa);
        btnSua = findViewById(R.id.btn_Sua);
        spbh = findViewById(R.id.sp_Song);
    }
    void themCung(ArrayList<Song>arr) {
        Song s1 = new Song("Fortunate Son", "1969");
        Song s2 = new Song("The Letter", "1967");
        Song s3 = new Song("I Fought the Law", "1977");
        Song s4 = new Song("Somebody to Love", "1976");

        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);


    }

    public void Add(View view) {
        Song s = new Song();
        s.setName(edtten.getText().toString());
        s.setYear(edtnam.getText().toString());
        arrSong.add(s);
        songAdapter.notifyDataSetChanged();

        edtten.setText("");
        edtnam.setText("");
        edtten.requestFocus();
    }

    public void Delete(View view) {
        if (viTriChon < 0){
            Toast.makeText(this,"Chon de xoa",Toast.LENGTH_SHORT).show();
        }
        else {
            arrSong.remove(viTriChon);
        }
    }

    public void Modify(View view) {
        Song mods = arrSong.get(viTriChon);
        mods.setName(edtten.getText().toString());
        mods.setYear(edtnam.getText().toString());
        songAdapter.notifyDataSetChanged();
    }
}
