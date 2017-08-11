package com.example.android.gscmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2;
    EditText et1,et2;
    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        et1=(EditText )findViewById( R.id.EditText1 );
        et2=(EditText )findViewById( R.id.EditText2 );
        bt1=(Button )findViewById( R.id.Button1 );
        bt2=(Button )findViewById( R.id.Button2 );
        ref=new Firebase( "https://gscmessaging.firebaseio.com/" );
        bt1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=et1.getText().toString();
                final String contact=  et2.getText().toString() ;
                ref.child( "gsc" ).child(name).child( "phone" ).setValue( contact );
            }
        } );
        bt2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent( MainActivity.this,MessagingActivity.class );
                startActivity( in );
            }
        } );
    }
 }

