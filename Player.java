import java.util.ArrayList;
public class Player {
  
  //instance variables
  private String pname;
  private int phealth;
  private int pattack;
  private int pspeed;
  private ArrayList<Supply> inventory;

//constructor w one parameter
public Player(String name){
  pname=name;
  phealth=100;
  pattack=100;
  pspeed=100;
  inventory = new ArrayList<>();
}

  //getter and setter methods
public String getpname(){
    return pname;
  }
  public int getphealth(){
    return phealth;
  }
  public int getpattack(){
    return pattack;
  }
  public ArrayList getinventory(){
    return inventory;
  }
  public int setphealth(int a){
    return phealth+a;
  }
  public int setpattack(int a){
    return pattack+a;
  }

//add supplies to inventory
public void collectPotion(){
  Supply p = new Supply();
  inventory.add(p);
}
public void collectWeapon(){
  Weapon w = new Weapon();
  inventory.add(w);
}

//method to use potion
public void usePotion(){
  int y=getphealth();
  if(y<=0){
    for(int i=0; i<inventory.size(); i++){
      Supply temp = inventory.get(i);
      String tempname = temp.getSupplyName();
      if(tempname.equals("Potion")){
        phealth+=50;
        inventory.remove(i);
        System.out.println("Player's health is refilled");
        break;
      } else{
        System.out.println("No potions in inventory");
        break;
      }
    }
  }
}
  
//attack method
  public void attack(Zombie zombie){
    phealth-=5;
    pattack-=5;
    zombie.setzhealth(-10);
    zombie.setzattack(-10);
    System.out.println(pname + " attacks");
  }

  //defend method
  public void defend(){
    phealth+=5;
    pattack+=5;
    System.out.println(pname + " defends");
  }

}