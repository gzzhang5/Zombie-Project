//subclass of Zombie
public class StrongZombie extends Zombie {

  //default constructor
  public StrongZombie(){
    super();
  }

  //getter methods
  //features: stronger, more health, slower speed
 public String getztype(){
    return "Super Zombie";
  }
public int getzhealth(){
    return super.getzhealth()*2;
  }
public int getzattack(){
    return super.getzattack()*2;
  }
  public int getzspeed(){
    return super.getzspeed()/2;
  }

  //speak method
  public void speak(){
    System.out.println("You can't beat me! I am a strong zombie!");
  }
}