import java.util.*;
class Main {

  //game loop
  static boolean gamestate=true;

  public static void main(String[] args) {
    String[][] city = new String[6][6];
    for (int i=0; i<6; i++) {
    for (int j=0; j<6; j++) {
    city[i][j] = "  "; }}
    city[0][1] = "SZ";
    city[0][0] = "o ";
    city[0][2] = "P ";
    for(int i = 0; i<6; i++){
      city[1][i] = "FZ";}
     for(int i = 0; i<6; i++){
      city[2][i] = "Z ";}
    city[5][3] = "P ";
    city[5][4] = "E ";
    city[5][5] = "SZ";
    city[4][3] = "A ";
    city[4][1] = "P ";
    city[3][1] = "A ";
    city[4][2] = "Z ";
    int x = 0;
    int y = 0;
    show(city);

    Scanner console = new Scanner(System.in);
    System.out.println("You have spawned in a city full of zombies. Will you make it out alive? Before we begin, what is your name?");
    String userName = console.nextLine();
    Player player = new Player(userName);
    System.out.println();
    System.out.println("Hello " + player.getpname() + "! Your position is marked with o on the first floor. The escape route is marked with E on the top floor. You can fight zombies (Z). gain attack (A), and heal with potions (P). Currently, your attack, health, and speed are at 100.");
    System.out.println();
    System.out.println("Each turn you can move 1 space up (u), down (d), left (l), or right (r).");


    while(gamestate){
      System.out.println("Move: ");
      String move = console.nextLine();
      String temp= "";

  //moving player around
    if (move.equals("u")){
      city[x][y] = "  ";
      x -=1;
      temp = city[x][y];
      city[x][y] = "o ";
      show(city);
      System.out.println("You landed on \"" + temp + "\"");
    }else if (move.equals("d")){
      city[x][y] = "  ";
      x +=1;
      temp = city[x][y];
      city[x][y] = "o ";
      show(city);
      System.out.println("You landed on \"" + temp + "\"");
    }else if (move.equals("l")){
      city[x][y] = "  ";
      y -=1;
      temp = city[x][y];
      city[x][y] = "o ";
      show(city);
      System.out.println("You landed on \"" + temp + "\"");
    }else if (move.equals("r")){
      city[x][y] = "  ";
      y +=1;
      temp = city[x][y];
      city[x][y] = "o ";
      show(city);
      System.out.println("You landed on " + temp);
    }else{
      System.out.println("Invalid input. Please restart.");
      gamestate = false;
    }

    if(temp.equals("E ")){
      System.out.println("You found the escape route! Congratulations, you made it!");
      gamestate=false;
    } else if(temp.equals("P ")){
      player.collectPotion();
      System.out.println("You added a potion to your inventory. This will heal you if you reach 0 health in a fight. Here is your inventory: ");
      ArrayList<Supply> printInventory = player.getinventory();
      for(int i=0; i<printInventory.size(); i++){
        Supply n = printInventory.get(i);
        String m = n.getSupplyName();
        System.out.println(m);
      }
    } else if(temp.equals("A ")){
      player.collectWeapon();
      player.setpattack(50);
      System.out.println("You added a weapon to your inventory. This will increase your power. Here is your inventory: ");
      ArrayList<Supply> printInventory = player.getinventory();
      for(int i=0; i<printInventory.size(); i++){
        Supply n = printInventory.get(i);
        String m = n.getSupplyName();
        System.out.println(m);
    }
    } else if(temp.equals("Z ")){
      System.out.println("Zombie! Fight!");
      Zombie zombie = new Zombie();
      zombie.speak();

      fightingfirst(zombie, player);
    } else if(temp.equals("FZ")){
      System.out.println("Fast zombie! Fight quick!");
      FastZombie fastzombie = new FastZombie();
      fastzombie.speak();
      fightingfast(fastzombie, player);
    } else if(temp.equals("SZ")){
      System.out.println("Strong zombie! Be careful!");
      StrongZombie strongzombie = new StrongZombie();
      strongzombie.speak();
      fightingstrong(strongzombie, player);
    }



      
    } //end of game loop

    
  } //end of main method

  public static void fightingfirst(Zombie z, Player p){
    p.attack(z);
    z.zattack(p);
    p.usePotion();
    p.defend();
    int a = p.getphealth();
    System.out.println("Player's health is "+a);

    if(z.getzhealth()<=0){
      System.out.println("Zombie is dead!");
      return; // Base case: Defender's health reaches zero, fight 
    } else if(p.getphealth()<0){
      System.out.println("Your health is at 0. You died.");
      gamestate=false;
      System.exit(0);
    }
    //recursive call for the next turn
    fightingfirst(z,p);
  }

  //fast fighting method
  public static void fightingfast(FastZombie z, Player p){
    z.zattack(p);
    p.usePotion();
    p.defend();
    z.zattack(p);
    p.usePotion();
    p.attack(z);
    int a=p.getphealth();
    System.out.println("Player health is " + a);
    
    if (z.getzhealth() <= 0) {
      System.out.println("Zombie is defeated!");
      return; // Base case: Defender's health reaches zero, fight ends
    } else if (p.getphealth() < 0) {
      System.out.println("Your health is zero. You died.");
      gamestate = false;
      System.exit(0);
      }

        // Recursive call for the next turn
        fightingfast(z, p);
  
}
  public static void fightingstrong(StrongZombie z, Player p){
    z.zattack(p);
    p.usePotion();
    p.defend();
    z.zattack(p);
    p.usePotion();
    p.attack(z);
    int a = p.getphealth();
    System.out.println("Player health is " + a);

    if (z.getzhealth() <= 0) {
      System.out.println("zombie is defeated!");
      return; // Base case: Defender's health reaches zero, fight ends
    } else if (p.getphealth() < 0) {
      System.out.println("Your health is zero. You died.");
      gamestate = false;
      System.exit(0);
      }
    
    // Recursive call for the next turn
    fightingstrong(z, p);
  }

  //print the city
  public static void show(String[][] city){
  for (int i = 0; i < 6; i++) {
  for (int j = 0; j < 6; j++) {
  System.out.print("|" + city[i][j] + "|");
  }  
  System.out.println();
  }
  }
  
  }