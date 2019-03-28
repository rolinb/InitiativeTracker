package com.example.rbuckoke.initiativetracker;

import android.content.Intent;
import android.nfc.FormatException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.Random;


public class AddEnemies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_enemies);


    }

    public void SaveEnemyAction(View v){
        EditText enemyNameTV = findViewById(R.id.enemyName);
        String name = enemyNameTV.getText().toString();
        EditText tmpTV = findViewById(R.id.Number);

        try {
            Characters list = Characters.getInstance();
            int number = Integer.parseInt(tmpTV.getText().toString());
            Random ran = new Random();
            for(int i = 0; i < number; i++) {
                Character tmp;
                if(number > 1) {
                    tmp = new Character(name + " " + (i + 1), 0, true);
                }
                else {
                    tmp = new Character(name, 0, true);
                }
                tmp.setRoll(ran.nextInt(10) + 1);
                list.addCharacter(tmp);
            }

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        catch (NumberFormatException nfe) {
            tmpTV.setError("Please Enter a Valid Number");
        }
    }

}
