//subclass of Zombie
public class FastZombie extends Zombie {
  
  //default constructor
  public FastZombie(){
    super();
  }

  //getter methods
  //features: less damage, less health, higher speed
  public String getztype(){
    return "Fast zombie";
  }
public int getzhealth(){
    return super.getzhealth()/2;
  }
public int getzottack(){
    return super.getzattack()/2;
  }
  public int getzspeed(){
    return super.getzspeed()*2;
  }

  //speak method
  public void speak(){
    System.out.println("I'm so fast, you won't know what hit you!");
  }
}