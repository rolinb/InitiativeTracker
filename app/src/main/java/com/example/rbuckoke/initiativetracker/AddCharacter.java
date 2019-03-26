package com.example.rbuckoke.initiativetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCharacter extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_character);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


  }

  public void SaveCharacterAction(View v){
      EditText charNameTV = findViewById(R.id.CharName);
      String name = charNameTV.getText().toString();
      EditText tmpTV = findViewById(R.id.Reaction);

      int reaction = Integer.parseInt(tmpTV.getText().toString());
      Character tmp = new Character(name, reaction, false);

      Characters list = Characters.getInstance();
      list.addCharacter(tmp);

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

}
