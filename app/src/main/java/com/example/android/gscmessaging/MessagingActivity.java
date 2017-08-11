package com.example.android.gscmessaging;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class MessagingActivity extends AppCompatActivity {
    Firebase ref=new Firebase( "https://gscmessaging.firebaseio.com/" );
    ImageButton bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_messaging );
        bt3=(ImageButton)findViewById( R.id.imageButton );
        bt3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        } );
    }
    public void getData(){
        FirebaseDatabase.getInstance().getReference().child( "gsc" );
        ref.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                collectPhoneNumbers((Map<String,Object> ) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        } );
    }
    private void collectPhoneNumbers(Map<String,Object> users) {

        ArrayList<Long> phoneNumbers = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            phoneNumbers.add(( Long ) singleUser.get("phone"));
        }
         System.out.println(phoneNumbers.toString());
    }
}
