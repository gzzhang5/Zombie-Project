public class Zombie {
//zombie's attributes
private String ztype;
private int zattack;
private int zspeed;
private int zhealth;
//behavior: what zombie says before the fight
private String zbehavior;

//default constructor
//Normal zombies: balance of attack, health, speed
public Zombie(){
  ztype="Zombie";
  zattack=100;
  zspeed=100;
  zhealth=100;
  zbehavior="The battle begins!";
}

//getter and setter methods
public String getztype(){
  return ztype;
}
public int getzattack(){
  return zattack;
}
public int getzspeed(){
  return zspeed;
}
public int getzhealth(){
  return zhealth;
}

public int setzhealth(int a){
  return zhealth+a;
}
public int setzattack(int a){
  return zattack+a;
}

//speak method
public void speak(){
  System.out.println(zbehavior);
}

//attack method
public void zattack(Player player){
  zhealth-=5;
  zattack-=10;
  player.setphealth(-5);
  player.setpattack(-10);
  System.out.println("Zombie attacks!");
}
}
