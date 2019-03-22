package com.example.rbuckoke.initiativetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AddInitiatives extends AppCompatActivity {
PopupMenu popup;
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

    /*  final Button button = new Button(this);
      button.setText("Add modifier");
      button.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {
          final View tmp = v;
          popup = new PopupMenu(AddInitiatives.this, button);
          popup.getMenu().add("Hasted");
          popup.getMenu().add("Slowed");
          popup.getMenu().add("Higher Ground");
          popup.getMenu().add("Set to receive a charge");
          popup.getMenu().add("Wading on slippery footing");
          popup.getMenu().add("Wading in deep water");
          popup.getMenu().add("Foreign Environment");
          popup.getMenu().add("Hindered");
          popup.getMenu().add("Waiting");

          popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
               String mod = item.getTitle().toString();
                      switch(mod){
                        case "Hasted":
                          c.modifyRoll(-2);
                          break;
                        case "Slowed":
                          c.modifyRoll(2);
                          break;
                        case "Higher Ground":
                          c.modifyRoll(-1);
                          break;
                        case "Set to receive a charge":
                          c.modifyRoll(-2);
                          break;
                        case "Wading in deep water":
                          c.modifyRoll(4);
                          break;
                        case "Wading on slippery footing":
                          c.modifyRoll(2);
                          break;
                        case "Foreign Environment":
                          c.modifyRoll(6);
                          break;
                        case "Hindered":
                          c.modifyRoll(3);
                          break;
                        case "Waiting":
                          c.modifyRoll(1);
                          break;
                        default:
                          break;
                      }
              updateTable(tmp);
              return true;
            }
          });
          popup.show();

        }
      });*/
      TextView playerName = new TextView(this);
      playerName.setText(c.getName());
      final EditText enterInitiative = new EditText(this);
      if(c.getRoll() != 0){
        enterInitiative.setText(""+c.getRoll());
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
     // row.addView(button);
      row.addView(playerName);
      row.addView(enterInitiative);
      tl.addView(row);
    }

    /**
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
    }*/
  }


  //adds modifier to all pcs
  public void saveInits(View v) {

    Intent intent = new Intent(this, Combat.class);
    startActivity(intent);

    TableLayout tl = findViewById(R.id.PlayerTable);
    Characters list = Characters.getInstance();
/*
    for(int i = 0, j = tl.getChildCount(); i < j; i++) {
      View view = tl.getChildAt(i);
      if (view instanceof TableRow) {
        TableRow row = (TableRow) view;
        TextView tv = (TextView) row.getChildAt(1);
        EditText et = (EditText) row.getChildAt(2);
        if(tv != null && et != null && !tv.getText().toString().contains("Enemy")) {
          Character c = list.getCharacter(tv.getText().toString());
          if (c != null)
            c.addReaction();
        }
      }
    }
    updateTable(v);*/
  }

  public void updateTable(View v) {
    TableLayout tl = findViewById(R.id.PlayerTable);
    Characters list = Characters.getInstance();

    for(int i = 0, j = tl.getChildCount(); i < j; i++) {
      View view = tl.getChildAt(i);
      if (view instanceof TableRow) {
        TableRow row = (TableRow) view;
        TextView tv = (TextView) row.getChildAt(1);
        EditText et = (EditText) row.getChildAt(2);
        if(tv != null && et != null) {
          Character c = list.getCharacter(tv.getText().toString());
          if (c != null)
            et.setText("" + c.getRoll());
        }
      }
    }


  }

}
