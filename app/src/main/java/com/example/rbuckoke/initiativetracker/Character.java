package com.example.rbuckoke.initiativetracker;


public class Character {
  String name;
  int reaction;
  int roll = 0;

  public Character(String name, int reaction){
    this.name = name;
    this.reaction = reaction;
  }

  @Override
  public String toString() {
    return name + " " + reaction;
  }

  public void setRoll(int rolled){
    roll = rolled ;
  }

  public void addReaction(){
    roll -=reaction;
  }

  public int getRoll(){
    return roll;
  }

  public String getName(){
    return name;
  }

  public void modifyRoll(int mod){
    roll += mod;
  }
}
