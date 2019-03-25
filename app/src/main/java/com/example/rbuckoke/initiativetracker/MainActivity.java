package com.example.rbuckoke.initiativetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
  static int[] enemy;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    populateCharacterList();


  }

  public void goToAddCharacter(View v) {
    Intent intent = new Intent(this, AddCharacter.class);
    startActivity(intent);
  }

  private void populateCharacterList(){
    TextView tv = findViewById(R.id.CharListView);
    Characters list = Characters.getInstance();
    tv.setText("");
    for(Character c : list.charList){
      tv.append(c.toString() + "\n");
    }
    if(enemy != null) {
      for (int i = 0; i < enemy.length; i++) {
        tv.append("Enemy " + (i + 1) + " Init = " + enemy[i] + "\n");
      }
    }
  }

  public void addEnemies(View v){
    TextView tv = findViewById(R.id.EnemyCounter);
    try {
      int enemyCount = Integer.parseInt(tv.getText().toString());
      Characters list = Characters.getInstance();
      Random ran = new Random();
      for(int i =0; i<enemyCount; i++){
        Character c = new Character("Enemy " + (i+1) + ": ", 0);
        c.setRoll(ran.nextInt(10)+1);
        list.addCharacter(c);
      }
      populateCharacterList();
    }
    catch (NumberFormatException nfe) {
      tv.setError("Please Enter a Number");
    }
  }

  public void goToAddInitiatives(View v){
    Intent intent = new Intent(this, AddInitiatives.class);
    startActivity(intent);
  }


}
