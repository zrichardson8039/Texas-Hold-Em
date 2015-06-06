package Game;

import Test.TexasHoldEmTester;
import Exceptions.InvalidConsoleArgException;


/**
 * The driver class of the Texas Hold Em program.
 * 
 * @author Zach Richardson
 */
public class TexasHoldEm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidConsoleArgException {
        
        if(args[0].equals("-t"))
            testPoker();
        
        else if(args[0].equals("-p"))
            playPoker(args[1]);
        
        else
            throw new InvalidConsoleArgException("Please enter \"-t\" for test, \"-p\" for play hand, "
                    + "or \"-s\" for simulation");
    }
    
    /**
     * Displays the results of the tester class to the console
     */
    private static void testPoker()
    {
        TexasHoldEmTester tester = new TexasHoldEmTester();
        tester.runTests();
    }
    
    /**
     * Prints the results of a simulated poker hand to the console
     */
    private static void playPoker(String numPlayers)
    {
        int playerCount = 0;
        try {
            playerCount = Integer.parseInt(numPlayers);
        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer value as the second argument.");
        }
        
        PokerTable table = new PokerTable();
        
        table.shuffleUpAndDeal(playerCount);
        table.dealFlop();
        table.dealTurn();
        table.dealRiver();
            
        table.getWinningHand();
            
        System.out.println(table);
    }
}
