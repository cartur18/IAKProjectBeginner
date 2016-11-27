package com.asus46.martabakshop;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends Activity {

    EditText mtextnama;
    Button mbuttonorder, mbuttonplus, mbuttonmin, mbuttonreset;
    TextView mtextharga, mtextqty;
    RadioGroup mRadioGroup;
    RadioButton mRadioItem1, mRadioItem2;
    Context mContext;
    Spinner mspinnermenu;

    List<String> mListMenu = new ArrayList<>();
    int harga = 0;
    int qty = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mtextnama = (EditText) findViewById(R.id.mtxtnama);
        mtextharga = (TextView) findViewById(R.id.mtextharga);
        mtextqty = (TextView) findViewById(R.id.mtextqty);
        mbuttonorder = (Button) findViewById(R.id.mbuttonorder);
        mbuttonplus = (Button) findViewById(R.id.mbuttonplus);
        mbuttonmin = (Button) findViewById(R.id.mbuttonmin);
        mbuttonreset = (Button) findViewById(R.id.mbuttonreset);
        mContext = getApplicationContext();
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mRadioItem1 = (RadioButton) findViewById(R.id.mRadioItem1);
        mRadioItem2 = (RadioButton) findViewById(R.id.mRadioItem2);

        mRadioItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Item 1 diklik", Toast.LENGTH_SHORT).show();
            }
        });
        mRadioItem2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(mContext, "Item 2 diklik", Toast.LENGTH_SHORT).show();
            }
        });

        mspinnermenu = (Spinner) findViewById(R.id.mspinnermenu);
        mListMenu.add("---------");
        mListMenu.add("Martabak");
        mListMenu.add("Piscok Bakar");
        mListMenu.add("Ice Cream Sandwich");
        mListMenu.add("Lumpia Basah");
        mListMenu.add("Mie Goreng");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListMenu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinnermenu.setAdapter(dataAdapter);


//        mbuttonorder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Hi, nama saya "+mtextnama.getText(),Toast.LENGTH_LONG).show();
//                mtextnama.setText(mtextnama.getText());
//            }
//        });
    }
    public void onClickOrder(View view){
//        Toast.makeText(getApplicationContext(),"Hi, nama saya "+mtextnama.getText(),Toast.LENGTH_LONG).show();
//                mtextnama.setText(mtextnama.getText());
    }
    public void onClickPlus(View v){
        harga = harga + 5;
        qty = qty + 1;
        mtextqty.setText(""+qty);
        mtextharga.setText("$" + harga);

    }
    public void onClickMin(View v){

        if(qty<=0) {
            harga = 0;
            qty = 0;
            mtextqty.setText(""+qty);
            mtextharga.setText("$"+harga);
        }else {
            harga = 0;
            harga = harga - 5;
            qty = qty - 1;

            mtextqty.setText(""+qty);
            mtextharga.setText("$"+harga);
        }
    }
    public void onClickReset(View v){
        qty = 0;
        harga = 0;
        mtextqty.setText(""+qty);
        mtextharga.setText("$"+harga);
    }
}

