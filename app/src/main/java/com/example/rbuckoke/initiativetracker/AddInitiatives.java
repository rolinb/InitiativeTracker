package com.example.rbuckoke.initiativetracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AddInitiatives extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_initiatives);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    createView();
  }

  public void createView(){
    TableLayout tl = findViewById(R.id.PlayerTable);
    Characters list = Characters.getInstance();

    for(final Character c: list.charList){
      TableRow row = new TableRow(this);
      TextView playerName = new TextView(this);
      playerName.setText(c.getName());
      EditText enterInitiative = new EditText(this);
      if(c.getRoll() != 0){
        enterInitiative.setText(c.getRoll());
      }
      enterInitiative.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            c.setRoll(Integer.parseInt(s.toString()));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });
      row.addView(playerName);
    }
  }

  public void saveInits(View v){
    TableLayout tl = findViewById(R.id.PlayerTable);
    Characters list = Characters.getInstance();

    for(Character c: list.charList){
      EditText enterInitiative = new EditText(this);
      if(c.getRoll() != 0){
        enterInitiative.setText(c.getRoll());
      }
  }

}
