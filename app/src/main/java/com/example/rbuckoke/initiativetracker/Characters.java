package com.example.rbuckoke.initiativetracker;

import java.util.ArrayList;

public class Characters {
  public  ArrayList<Character> charList;

  public Characters(){
    charList = new ArrayList<>();
  }

  public void addCharacter(Character c){
    charList.add(c);
  }
  
  private static final Characters holder = new Characters();

  public static Characters getInstance() {return holder;}

  public Character getCharacter(String s){
    for (Character c: charList){
      if(c.getName().equals(s)){
        return c;
      }
    }
    return null;
  }





}
