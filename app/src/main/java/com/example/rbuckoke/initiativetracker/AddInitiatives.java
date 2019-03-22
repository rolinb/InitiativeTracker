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
      final EditText enterInitiative = new EditText(this);
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
      row.addView(enterInitiative);
      tl.addView(row);
    }
    if(MainActivity.enemy != null) {
      for (int i = 0; i < MainActivity.enemy.length; i++) {
        TableRow tr = new TableRow(this);
        TextView enemyNumber = new TextView(this);
        EditText enemyInit = new EditText(this);
        enemyNumber.setText("Enemy " + (i + 1) + ": ");
        enemyInit.setText(" " + MainActivity.enemy[i]);
        tr.addView(enemyNumber);
        tr.addView(enemyInit);
        tl.addView(tr);
      }
    }
  }


  //adds modifier to all pcs
  public void saveInits(View v) {
    TableLayout tl = findViewById(R.id.PlayerTable);
    Characters list = Characters.getInstance();

    for(int i = 0, j = tl.getChildCount(); i < j; i++) {
      View view = tl.getChildAt(i);
      if (view instanceof TableRow) {
        TableRow row = (TableRow) view;
        TextView tv = (TextView) row.getChildAt(0);
        EditText et = (EditText) row.getChildAt(1);
        if(tv != null && et != null && !tv.getText().toString().contains("Enemy")) {
          Character c = list.getCharacter(tv.getText().toString());
          if (c != null)
            et.setText("" + c.getRoll());
        }
      }
    }
  }

}
