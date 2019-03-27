package com.example.rbuckoke.initiativetracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;

public class Combat extends AppCompatActivity {
int turnsTaken;
int totalTurns;
int rounds = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createView();

    }

    public void createView() {
        TableLayout tl = findViewById(R.id.CombatTable);
        tl.removeAllViews();
        Characters list = Characters.getInstance();
        Collections.sort(list.charList);
        totalTurns = list.charList.size();
            TableRow roundsRow = new TableRow(this);
            TextView tv = new TextView(this);
            tv.setText("Round: " + rounds);
            roundsRow.addView(tv);
            tl.addView(roundsRow);
        for (final Character c : list.charList) {
            TableRow row = new TableRow(this);
            final Button popupMenu = new Button(this);
            popupMenu.setText("Modifiers");
            popupMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    PopupMenu popup = new PopupMenu(Combat.this, v);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()){
                                case R.id.hastedOption:
                                    if(c.modifiers[0]) {
                                        item.setChecked(false);
                                        c.modifiers[0] =false;
                                    }else {
                                        c.modifiers[0] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.slowedOption:
                                    if(c.modifiers[1]) {
                                        item.setChecked(false);
                                        c.modifiers[1] =false;
                                    }else {
                                        c.modifiers[1] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.higherground:
                                    if(c.modifiers[2]) {
                                        item.setChecked(false);
                                        c.modifiers[2] =false;
                                    }else {
                                        c.modifiers[2] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.charged:
                                    if(c.modifiers[3]) {
                                        item.setChecked(false);
                                        c.modifiers[3] =false;
                                    }else {
                                        c.modifiers[3] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.wadingslippery:
                                    if(c.modifiers[4]) {
                                        item.setChecked(false);
                                        c.modifiers[4] =false;
                                    }else {
                                        c.modifiers[4] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.wadingDeep:
                                    if(c.modifiers[5]) {
                                        item.setChecked(false);
                                        c.modifiers[5] =false;
                                    }else {
                                        c.modifiers[5] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.foreignEnviron:
                                    if(c.modifiers[6]) {
                                        item.setChecked(false);
                                        c.modifiers[6] =false;
                                    }else {
                                        c.modifiers[6] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.hindered:
                                    if(c.modifiers[7]) {
                                        item.setChecked(false);
                                        c.modifiers[7] =false;
                                    }else {
                                        c.modifiers[7] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                                case R.id.waiting:
                                    if(c.modifiers[8]) {
                                        item.setChecked(false);
                                        c.modifiers[8] =false;
                                    }else {
                                        c.modifiers[8] = true;
                                        item.setChecked(true);
                                    }
                                    break;
                            }
                            // createView();
                            return true;
                        }
                    });
                    popup.inflate(R.menu.popupmenu);
                    for(int i=0; i<c.modifiers.length; i++){
                        popup.getMenu().getItem(i).setChecked(c.modifiers[i]);
                    }
                    popup.show();
                }
            });

            TextView playerName = new TextView(this);
            playerName.setText(c.getName());
            final TextView enterInitiative = new TextView(this);
            enterInitiative.setText("" + c.getTotal());
            enterInitiative.setTextSize(24);
            row.addView(popupMenu);
            row.addView(playerName);
            row.addView(enterInitiative);
            tl.addView(row);
        }
    }


    public void endTurn(View v) {
        TableLayout tl = findViewById(R.id.CombatTable);
        Characters list = Characters.getInstance();

            View view = tl.getChildAt(1);
            if (view instanceof TableRow) {
                TableRow row = (TableRow) view;
                TextView tv = (TextView) row.getChildAt(1);
                TextView et = (TextView) row.getChildAt(2);
                if(tv != null && et != null) {
                    Character c = list.getCharacter(tv.getText().toString());
                    if (c != null) {
                        c.gone = true;
                        turnsTaken++;
                        createView();
                        if (totalTurns  == turnsTaken){
                            turnsTaken = 0;
                            rounds++;
                            for(Character c2 : list.charList)
                                c2.gone = false;
                        }
                    }
                }
            }
        }





}
