import java.util.Scanner; 

class GenerateRandom {
    public static int gen_dealer() {
      int min = 11;
      int max = 21;
        
      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
      return random_int;
    }

    public static int gen() {
      int min = 1;
      int max = 13;
        
      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
      return random_int;
    }

    public static void main(String args[]) {
      System.out.println("Welcome to Blackjack!");
      Scanner input = new Scanner(System.in);
      int player_total = 0;
      int dealer_total = gen_dealer();
      String another = "y";
      while (another.equals("y")) {
        int card_value = 0;
        int drawn_card = gen();
        String card_name = "";
        if (drawn_card == 11){
          card_name = "King";
          card_value = 10;
        }
        else if (drawn_card == 12) {
          card_name = "Queen";
          card_value = 10;
        }
        else if (drawn_card == 13) {
          card_name = "Ace";

          if (player_total < 11) {
            card_value = 11;
          }

          else {
            card_value = 1;
          }
        }
        else{
          card_name = String.valueOf(drawn_card);
          card_value = drawn_card;
        }
        player_total += card_value;
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("You drew a " + card_name);
        System.out.println("Your total is " + player_total);
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        if (player_total < 22) {
          System.out.println("Would you like to draw another? (y/n)");
          another = input.nextLine().toString();
        }
        else {
          System.out.println("You broke! Game over.");
          System.exit(0);
        }
      }
      System.out.println("~~~~~~~~~~~~~~~~~~~~");
      System.out.println("The dealer got " + dealer_total + ", and you got " + player_total + ".");
      if (dealer_total < player_total) {
        System.out.println("You win!");
      }

      else if (dealer_total > player_total) {
        System.out.println("You lose!");
      }

      else {
        System.out.println("You tied!");
      }
      
      input.close();
    }
}