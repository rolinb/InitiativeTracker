package com.example.rbuckoke.initiativetracker;


import java.util.HashMap;

public class Character implements Comparable<Character> {
  String name;
  int reaction;
  int roll = 0;
  boolean[] modifiers;
  public Character(String name, int reaction){
    this.name = name;
    this.reaction = reaction;
    modifiers = new boolean[9];
    for(int i=0; i<modifiers.length; i++){
      modifiers[i] = false;
    }
  }

  @Override
  public String toString() {
    return name + " " + reaction;
  }

  public void setRoll(int rolled){
    roll = rolled ;
  }

  public int addReaction(){
    return roll - reaction;
  }

  public int getTotal(){
    return roll - reaction + this.allModifiers();
  }

  /*
  Hasted, Slowed, On Higher Ground, Set to receive a charge, wading or slippery footing,
  wading in deep water, foreign environment, hindered, waiting
   */
  public int allModifiers(){
    int total =0;
    if(modifiers[0]) //hasted
      total+=-2;
    if(modifiers[1]) //slowed
      total+=2;
    if(modifiers[2]) //higher ground
      total+=-1;
    if(modifiers[3]) //charge
      total+=-2;
    if(modifiers[4]) //wading slippery
      total+=2;
    if(modifiers[5]) //wading deep
      total+=4;
    if(modifiers[6]) //foreign
      total+=6;
    if(modifiers[7]) //hindered
      total+=3;
    if(modifiers[8]) //waiting
      total+=1;
    return total;
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

  @Override
  public int compareTo(Character o) {
    if(this.getTotal() > o.getTotal()) return 1;
    else return -1;
    }
}
