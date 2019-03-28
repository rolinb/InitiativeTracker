package com.example.rbuckoke.initiativetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import java.util.Iterator;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
  static int[] enemy;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Bundle b = getIntent().getExtras();
    if(b != null && b.getInt("clearEnemies") == 1) {
      clearEnemies(new View(this));
    }
    populateCharacterList();
  }

  public void goToAddCharacter(View v) {
    Intent intent = new Intent(this, AddCharacter.class);
    startActivity(intent);
  }

  public void goToAddEnemies(View v) {
    Intent intent = new Intent(this, AddEnemies.class);
    startActivity(intent);
  }

  private void populateCharacterList(){
    TextView tv = findViewById(R.id.CharListView);
    Characters list = Characters.getInstance();
    tv.setText("");
    for(Character c : list.charList){
      tv.append(c.name + ": " + c.reaction + "\n");
    }
    /*if(enemy != null) {
      for (int i = 0; i < enemy.length; i++) {
        tv.append("Enemy " + (i + 1) + " Init = " + enemy[i] + "\n");
      }
    }*/
  }

  public void clearEnemies(View v) {
    Characters list = Characters.getInstance();
    for(Iterator<Character> c = list.charList.iterator(); c.hasNext();){
      if(c.next().enemy) {
        c.remove();
      }
    }
    populateCharacterList();
  }

  public void goToAddInitiatives(View v){
    Intent intent = new Intent(this, AddInitiatives.class);
    startActivity(intent);
  }


}
