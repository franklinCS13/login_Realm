package com.example.goodapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.goodapp.Models.DbRealm;
import com.example.goodapp.R;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    Realm realm;

    EditText edname, edlastname, edaddress;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm.getDefaultConfiguration();

        edname = findViewById(R.id.EdName);
        edlastname = findViewById(R.id.EdLastName);
        edaddress = findViewById(R.id.EdAddress);
        btnsave = findViewById(R.id.btnSave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void saveData(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {

                Number dbId = bgRealm.where(DbRealm.class).max("personId");

                int newKey = (dbId == null) ? 1 : dbId.intValue()+1;

                DbRealm dbRealm = bgRealm.createObject(DbRealm.class, newKey);
                dbRealm.setName(edname.getText().toString());
                dbRealm.setLastname(edlastname.getText().toString());
                dbRealm.setAddress(edaddress.getText().toString());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this,"Success", Toast.LENGTH_LONG).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
            }
        });
    }
}
