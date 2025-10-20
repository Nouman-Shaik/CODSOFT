import java.util.Random;
import java.util.Scanner;

public class numberGame {
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner sn = new Scanner(System.in);
    boolean playagain=true;
    int roundswon=0;

    System.out.println("welcome to the number game");

    while(playagain){
       int randomnumber = rand.nextInt(100)+1;
       int attempts =0;
       int max_attempts=5;

       System.out.println("\nNew Round Started!");
       System.out.println("you have maximum "+max_attempts+" attempts");
           while(attempts<max_attempts){
            System.out.println("enter your guess (1-100)");
            int num = sn.nextInt();
            if(num==randomnumber){
              System.out.println("YOU WON "+(attempts+1)+" attempts");
              roundswon++;
              break;
            }
            else if(num>randomnumber){
              System.out.println("your guess is High");
            }
            else{
              System.out.println("your guess is Low");
            }
            attempts++;
            System.out.println("you have left "+(max_attempts-attempts)+" attempts");
          }
    if(attempts==max_attempts){
      System.out.println("GAME OVER");
      System.out.println("Random number is :"+randomnumber);
    }

     System.out.println("🏆 Rounds won so far: " + roundswon);
     //use next() to store the string and use equals funtion->if not equals return false
     System.out.println("Do you want to play agian (yes/no):");
     String res= sn.next().toLowerCase();
     playagain= res.equals("yes");

    }
   

    System.out.println("\nThanks for playing! Final score: " + roundswon + " rounds won.");
    sn.close();

  }
  
}
