package com.example.rbuckoke.initiativetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
  int[] enemy;

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
    int enemyCount = Integer.parseInt(tv.getText().toString());
    enemy = new int[enemyCount];
    Random ran = new Random();
    for(int i =0; i<enemyCount; i++){
      enemy[i] = ran.nextInt(10) + 1;
    }
    populateCharacterList();
  }

  public void goToAddInitiatives(View v){
    Intent intent = new Intent(this, AddInitiatives.class);
    startActivity(intent);
  }


}
