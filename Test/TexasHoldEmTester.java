package Test;


import java.util.List;

import Exceptions.InvalidDealException;
import Exceptions.InvalidHandException;
import Exceptions.InvalidRankException;
import Exceptions.InvalidSuitException;
import Game.Card;
import Game.CardDeck;
import Game.PokerHand;

/**
 * TexasHoldEmTester is a class that tests specific scenarios of a Texas Hold Em game
 * as well as various properties of each class to ensure the effectiveness of each class'
 * methods.
 * 
 * @author Zach
 */
public class TexasHoldEmTester {
    int passes = 0;
    int failures = 0;
    int total = 0;
    /**
     * @param args the command line arguments
     */
    
    private void printTestResults(String testDesc, boolean result)
    {
        total++;
        
        if(result) 
            passes++;
        else
            failures++;
        
        System.out.printf("%-80s\t%s\n", testDesc, (result ? " PASS" : "***FAIL***"));
    }
    
    private void printSummary()
    {
        System.out.printf("\nTotal Tests: %d, Passed: %d, Failed: %d\n", total, passes, failures);
    }
    
    public void runTests()
    {
        ////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////CARD TESTS////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\t\t//////////////////////////CARD TESTS/////////////////////////\n");
        
        //TESTS ON VALID CARD
        System.out.println("\nTESTS ON VALID CARD:");
        printTestResults("getSuitAfterValidCardAdded", getSuitAfterValidCardAdded());
        printTestResults("getSuitDisplayAfterValidCardAdded", getSuitDisplayAfterValidCardAdded());
        printTestResults("getRankAfterValidCardAdded", getRankAfterValidCardAdded());
        printTestResults("getRankValueAfterValidCardAdded", getRankValueAfterValidCardAdded());
        printTestResults("getRankDisplayAfterValidCardAdded", getRankDisplayAfterValidCardAdded());
        printTestResults("toStringAfterValidCardAdded", toStringAfterValidCardAdded());
        
        //TESTS ON INVALID RANK
        System.out.println("\nTESTS ON INVALID RANK:");
        printTestResults("getSuitAfterInvalidRankAdded", getSuitAfterInvalidRankAdded());
        printTestResults("getRankAfterInvalidRankAdded", getRankAfterInvalidRankAdded());
        printTestResults("getRankValueAfterInvalidRankAdded", getRankValueAfterInvalidRankAdded());
        
        //TESTS ON VALID SUIT
        System.out.println("\nTESTS ON INVALID SUIT:");
        printTestResults("getSuitAfterInvalidSuitAdded", getSuitAfterInvalidSuitAdded());
        printTestResults("getRankAfterInvalidSuitAdded", getRankAfterInvalidSuitAdded());
        printTestResults("getRankValueAfterInvalidSuitAdded", getRankValueAfterInvalidSuitAdded());
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////CARD DECK TESTS///////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n\t\t//////////////////////////CARD DECK TESTS/////////////////////////");
        
        //NEW DECK
        System.out.println("\nTESTS ON CARD DECK:");
        printTestResults("dealCard", dealCard());
        printTestResults("shuffleDeck", shuffleDeck());
        printTestResults("toStringOfNewDeck", toStringOfCardDeck());
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////POKER HAND TESTS//////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n\t\t//////////////////////////POKER HAND TESTS: NOT FOLDED/////////////////////////");
        
        //High Card
        System.out.println("\nTESTS ON HIGH CARD:\n");
        printTestResults("addCardOnHighCardValid", addCardOnHighCardValid());
        printTestResults("addCardOnHighCardInvalid", addCardOnHighCardInvalid());
        printTestResults("getHandOnHighCard", getHandOnHighCard());
        printTestResults("getPocketCardsOnHighCard", getPocketCardsOnHighCard());
        printTestResults("setBestHandOnHighCard", setBestHandValidOnHighCard());
        printTestResults("setBestHandOnHighCard", setBestHandInvalidOnHighCard());
        printTestResults("getBestHandOnHighCard", getBestHandOnHighCard());
        printTestResults("getBestHandValueOnHighCard", getBestHandValueOnHighCard());
        printTestResults("setWinnerTrueOnHighCard", setWinnerTrueOnHighCard());
        printTestResults("setWinnerFalseOnHighCard", setWinnerFalseOnHighCard());
        printTestResults("isWinnerOnHighCard", isWinnerOnHighCard());
        printTestResults("isNotWinnerOnHighCard", isNotWinnerOnHighCard());
        printTestResults("toStringOnWinningHighCard", toStringOnWinningHighCard());
        printTestResults("toStringOnLosingHighCard", toStringOnLosingHighCard());
        
        //Pair 
        System.out.println("\nTESTS ON PAIR:\n");
        printTestResults("getHandOnPair", getHandOnPair());
        printTestResults("setBestHandOnPair", setBestHandOnPair());
        printTestResults("getBestHandOnPair", getBestHandOnPair());
        printTestResults("getBestHandValueOnPair", getBestHandValueOnPair());
        printTestResults("toStringOnPair", toStringOnPair());
        
        //Two Pair
        System.out.println("\nTESTS ON TWO PAIR:\n");
        printTestResults("getHandOnTwoPair", getHandOnTwoPair());
        printTestResults("setBestHandOnTwoPair", setBestHandOnTwoPair());
        printTestResults("getBestHandOnTwoPair", getBestHandOnTwoPair());
        printTestResults("getBestHandValueOnTwoPair", getBestHandValueOnTwoPair());
        printTestResults("toStringOnTwoPair", toStringOnTwoPair());
        
        //Three Of A Kind
        System.out.println("\nTESTS ON THREE OF A KIND:\n");
        printTestResults("getHandOnThreeOfAKind", getHandOnThreeOfAKind());
        printTestResults("setBestHandOnThreeOfAKind", setBestHandOnThreeOfAKind());
        printTestResults("getBestHandOnThreeOfAKind", getBestHandOnThreeOfAKind());
        printTestResults("getBestHandValueOnThreeOfAKind", getBestHandValueOnThreeOfAKind());
        printTestResults("toStringOnThreeOfAKind", toStringOnThreeOfAKind());
        
        //Straight
        System.out.println("\nTESTS ON STRAIGHT:\n");
        printTestResults("getHandOnStraight", getHandOnStraight());
        printTestResults("setBestHandOnStraight", setBestHandOnStraight());
        printTestResults("getBestHandOnStraight", getBestHandOnStraight());
        printTestResults("getBestHandValueOnStraight", getBestHandValueOnStraight());
        printTestResults("toStringOnStraight", toStringOnStraight());
        
        //Flush
        System.out.println("\nTESTS ON FLUSH:\n");
        printTestResults("getHandOnFlush", getHandOnFlush());
        printTestResults("setBestHandOnFlush", setBestHandOnFlush());
        printTestResults("getBestHandOnFlush", getBestHandOnFlush());
        printTestResults("getBestHandValueOnFlush", getBestHandValueOnFlush());
        printTestResults("toStringOnFlush", toStringOnFlush());
        
        //Full House (From Two Pair)
        System.out.println("\nTESTS ON FULL HOUSE (From Two Pair):\n");
        printTestResults("getHandOnFullHouseFromTwoPair", getHandOnFullHouseFromTwoPair());
        printTestResults("setBestHandOnFullHouseFromTwoPair", setBestHandOnFullHouseFromTwoPair());
        printTestResults("getBestHandOnFullHouseFromTwoPair", getBestHandOnFullHouseFromTwoPair());
        printTestResults("getBestHandValueOnFullHouseFromTwoPair", getBestHandValueOnFullHouseFromTwoPair());
        printTestResults("toStringOnFullHouseFromTwoPair", toStringOnFullHouseFromTwoPair());
        
        //Full House (From Three Pair)
        System.out.println("\nTESTS ON FULL HOUSE (From Three Pair):\n");
        printTestResults("getHandOnFullHouseFromThreePair", getHandOnFullHouseFromThreePair());
        printTestResults("setBestHandOnFullHouseFromThreePair", setBestHandOnFullHouseFromThreePair());
        printTestResults("getBestHandOnFullHouseFromThreePair", getBestHandOnFullHouseFromThreePair());
        printTestResults("getBestHandValueOnFullHouseFromThreePair", getBestHandValueOnFullHouseFromThreePair());
        printTestResults("toStringOnFullHouseFromThreePair", toStringOnFullHouseFromThreePair());
        
        //Four Of A Kind
        System.out.println("\nTESTS ON FOUR OF A KIND:\n");
        printTestResults("getHandOnFourOfAKind", getHandOnFourOfAKind());
        printTestResults("setBestHandOnFourOfAKind", setBestHandOnFourOfAKind());
        printTestResults("getBestHandOnFourOfAKind", getBestHandOnFourOfAKind());
        printTestResults("getBestHandValueOnFourOfAKind", getBestHandValueOnFourOfAKind());
        printTestResults("toStringOnFourOfAKind", toStringOnFourOfAKind());
        
        //Straight Flush
        System.out.println("\nTESTS ON STRAIGHT FLUSH:\n");
        printTestResults("getHandOnStraightFlush", getHandOnStraightFlush());
        printTestResults("setBestHandOnStraightFlush", setBestHandOnStraightFlush());
        printTestResults("getBestHandOnStraightFlush", getBestHandOnStraightFlush());
        printTestResults("getBestHandValueOnStraightFlush", getBestHandValueOnStraightFlush());
        printTestResults("toStringOnStraightFlush", toStringOnStraightFlush());
        
        System.out.println("\n\t\t//////////////////////////POKER HAND TESTS: FOLDED BEFORE FLOP/////////////////////////\n");
        
        //High Card
        printTestResults("getBestHandOnHighCardPreFlop", getBestHandOnHighCardPreFlop());
        printTestResults("hasFoldedOnHighCardPreFlop", hasFoldedOnHighCardPreFlop());
        System.out.println();
        
        //Pair
        printTestResults("getBestHandOnPairPreFlop", getBestHandOnPairPreFlop());
        printTestResults("hasFoldedOnPairPreFlop", hasFoldedOnPairPreFlop());
        
        
        System.out.println("\n\t\t//////////////////////////POKER HAND TESTS: FOLDED AFTER FLOP/////////////////////////\n");
        
        //High Card
        System.out.println("\nHIGH CARD:");
        printTestResults("getBestHandOnHighCardAfterFlop", getBestHandOnHighCardAfterFlop());
        
        //Pair
        System.out.println("\nPAIR:");
        printTestResults("getBestHandOnPairAfterFlop", getBestHandOnPairAfterFlop());
            
        //Two Pair
        System.out.println("\nTWO PAIR:");
        printTestResults("getBestHandOnTwoPairAfterFlop", getBestHandOnTwoPairAfterFlop());
           
        //Three of a Kind
        System.out.println("\nTHREE OF A KIND:");
        printTestResults("getBestHandOnThreeOfAKindAfterFlop", getBestHandOnThreeOfAKindAfterFlop());
        
        //Straight
        System.out.println("\nSTRAIGHT:");
        printTestResults("getBestHandOnStraightAfterFlop", getBestHandOnStraightAfterFlop());
        
        //Flush
        System.out.println("\nFLUSH:");
        printTestResults("getBestHandOnFlushAfterFlop", getBestHandOnFlushAfterFlop());
        
        //Full House
        System.out.println("\nFULL HOUSE:");
        printTestResults("getBestHandOnFullHouseAfterFlop", getBestHandOnFullHouseAfterFlop());
        
        //Four of a Kind
        System.out.println("\nFOUR OF A KIND:");
        printTestResults("getBestHandOnFourOfAKindAfterFlop", getBestHandOnFourOfAKindAfterFlop());
        
        //Straight Flush
        System.out.println("\nSTRAIGHT FLUSH:");
        printTestResults("getBestHandOnStraightFlushAfterFlop", getBestHandOnStraightFlushAfterFlop());
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////POKER TABLE TESTS/////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
 
        //Poker Table of 3 With No Folds
        System.out.println("\nTABLE OF 3 WITH NO FOLDS:");
        printTestResults("shuffleUpAndDealToTableOf3", shuffleUpAndDealToTableOf3());
        printTestResults("dealFlopToTableOf3Valid", dealFlopToTableOf3Valid());
        printTestResults("dealFlopToTableOf3Invalid", dealFlopToTableOf3Invalid());
        printTestResults("dealTurnToTableOf3Valid", dealTurnToTableOf3Valid());
        printTestResults("dealTurnToTableOf3Invalid", dealTurnToTableOf3Invalid());
        printTestResults("dealRiverToTableOf3Valid", dealRiverToTableOf3Valid());
        printTestResults("dealRiverToTableOf3Invalid", dealRiverToTableOf3Invalid());
        printTestResults("calculateWinnerOfTableOf3", getWinningHandOfTableOf3());
        printTestResults("toStringOfTableOf3", toStringOfTableOf3());
        
        //Poker Table of 3 With 1 Fold
        System.out.println("\nTABLE OF 3 WITH 1 FOLD:");
        printTestResults("calculateWinnerOfTableOf3", getWinningHandOfTableOf3WithFold());
        printTestResults("toStringOfTableOf3", toStringOfTableOf3WithFold());
        
        //Poker Table of 3 With 2 Folds After the River
        System.out.println("\nTABLE OF 3 WITH 2 FOLDS AFTER THE RIVER:");
        printTestResults("calculateWinnerOfTableOf3", getWinningHandOfTableOf3With2FoldsAfterRiver());
        printTestResults("toStringOfTableOf3", toStringOfTableOf3With2FoldsAfterRiver());
        
        //Poker Table of 3 With 2 Folds After the Turn
        System.out.println("\nTABLE OF 3 WITH 2 FOLDS BEFORE THE RIVER:");
        printTestResults("dealRiverToTableOf3Invalid", dealRiverOfTableOf3With2FoldsBeforeRiver());
        printTestResults("calculateWinnerOfTableOf3", getWinningHandOfTableOf3With2FoldsBeforeRiver());
        printTestResults("toStringOfTableOf3", toStringOfTableOf3With2FoldsBeforeRiver());
        
        //Poker Table of 3 With 2 Folds After the Flop
        System.out.println("\nTABLE OF 3 WITH 2 FOLDS BEFORE THE TURN:");
        printTestResults("dealTurnToTableOf3Invalid", dealTurnOfTableOf3With2FoldsBeforeTurn());
        printTestResults("calculateWinnerOfTableOf3", getWinningHandOfTableOf3With2FoldsBeforeTurn());
        printTestResults("toStringOfTableOf3", toStringOfTableOf3With2FoldsBeforeTurn());
        
        //Poker Table of 3 With 2 Folds Before the Flop
        System.out.println("\nTABLE OF 3 WITH 2 FOLDS BEFORE THE FLOP:");
        printTestResults("dealFlopToTableOf3Valid", dealFlopOfTableOf3With2FoldsBeforeFlop());
        printTestResults("calculateWinnerOfTableOf3", getWinningHandOfTableOf3With2FoldsBeforeFlop());
        printTestResults("toStringOfTableOf3", toStringOfTableOf3With2FoldsBeforeFlop());
        
        ///////////////////////////POKER TABLE TEST OF EACH HAND TYPE///////////////////////////////
        
        System.out.println("\n\t\t//////////////////POKER TABLE TEST OF EACH HAND TYPE//////////////////////");
        
        //High Card
        System.out.println("\nHIGH CARD:");
        printTestResults("pokerTableHighCard", pokerTableHighCard());
        
        //Pair
        System.out.println("\nPAIR:");
        printTestResults("pokerTablePair", pokerTablePair());
        
        //Two Pair
        System.out.println("\nTWO PAIR:");
        printTestResults("pokerTableTwoPair", pokerTableTwoPair());
        
        //Three of a Kind
        System.out.println("\nTHREE OF A KIND:");
        printTestResults("pokerTableThreeOfAKind", pokerTableThreeOfAKind());
        
        //Straight 
        System.out.println("\nSTRAIGHT:");
        printTestResults("pokerTableStraight", pokerTableStraight());
        
        //Flush
        System.out.println("\nFLUSH:");
        printTestResults("pokerTableFlush", pokerTableFlush());
        
        //Full House
        System.out.println("\nFULL HOUSE:");
        printTestResults("pokerTableFullHouse", pokerTableFullHouse());
        
        //Four of a kind
        System.out.println("\nFOUR OF A KIND:");
        printTestResults("pokerTableFourOfAKind", pokerTableFourOfAKind());
        
        //Straight Flush
        System.out.println("\nSTRAIGHT FLUSH:");
        printTestResults("pokerTableStraightFlush", pokerTableStraightFlush());
        
        //Royal Flush
        System.out.println("\nROYAL FLUSH:");
        printTestResults("pokerTableRoyalFlush", pokerTableRoyalFlush());
        
        printSummary();
    }
    
        ////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////CARD TESTS////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
    
    //SCENARIO; Valid Card
    
    /**@return test result*/
    private boolean getSuitAfterValidCardAdded()
    {
        Card twoOfClubs = new Card('2', 'C');
        
        try {
            return twoOfClubs.getSuit() == 'c'; 
        } catch (Exception e) {
            return false;
        }
    }
    
    /**@return test result*/
    private boolean getSuitDisplayAfterValidCardAdded()
    {
        Card twoOfClubs = new Card('2', 'C');
        
        try {
            return twoOfClubs.getSuitDisplay().equals("Clubs"); 
        } catch (Exception e) {
            return false;
        }
    }
    
    /**@return test result*/
    private boolean getRankAfterValidCardAdded()
    {
        Card twoOfClubs = new Card('2', 'C');
        
        try {
            return twoOfClubs.getRank() == '2'; 
        } catch (Exception e) {
            return false;
        }
    }
    
    /**@return test result*/
    private boolean getRankValueAfterValidCardAdded()
    {
        Card validCard = new Card('2', 'C');
        
        try {
            return validCard.getRankValue() == 2; 
        } catch (Exception e) {
            return false;
        }
    }
    
    /**@return test result*/
    private boolean getRankDisplayAfterValidCardAdded()
    {
        Card validCard = new Card('2', 'C');
        
        try {
            return validCard.getRankDisplay().equals("Two"); 
        } catch (Exception e) {
            return false;
        }
    }

    /**@return test result*/
    private boolean toStringAfterValidCardAdded()
    {
        Card validCard = new Card('2', 'C');
        
        try {
            return validCard.toString().equals("2c"); 
        } catch (Exception e) {
            return false;
        }
    }
    
    //SCENARIO: Invalid Rank
    
    /**@return test result*/
    private boolean getSuitAfterInvalidRankAdded()
    {
        try {
            Card invalidRank = new Card('Z', 'h');
        } catch (InvalidRankException e) {
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test result*/
    private boolean getRankAfterInvalidRankAdded()
    {
        try {
            Card invalidRank = new Card('Z', 'h');
        } catch (InvalidRankException e) {
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test result*/
    private boolean getRankValueAfterInvalidRankAdded()
    {
        try {
            Card invalidRank = new Card('Z', 'h');
        } catch (InvalidRankException e) {
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        return false;
    }
    
    //SCENARIO: Invalid Suit
    
    /**@return test result*/
    private boolean getSuitAfterInvalidSuitAdded()
    {
        try {
            Card invalidRank = new Card('2', 'Z');
        } catch (InvalidSuitException e) {
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test result*/
    private boolean getRankAfterInvalidSuitAdded()
    {
        try {
            Card invalidRank = new Card('2', 'Z');
        } catch (InvalidSuitException e) {
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test result*/
    private boolean getRankValueAfterInvalidSuitAdded()
    {
        try {
            Card invalidRank = new Card('2', 'Z');
        } catch (InvalidSuitException e) {
            return true;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        return false;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////CARD DECK TESTS///////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    //SCENARIO: New Deck
    
    /**@return test results*/
    private boolean shuffleDeck()
    {
        CardDeck deck = new CardDeck();
        CardDeck compareDeck = new CardDeck();
        
        try {
            deck.shuffleDeck();
            boolean passed = true;
            int deckCount = 0;
            
            while(passed && deckCount < deck.getDeck().length)
            {
                int compareCount = 0;
                boolean found = false;
                while(!found && compareCount < compareDeck.getDeck().length)
                {
                    found = deck.getDeck()[deckCount].getRank() == compareDeck.getDeck()[compareCount].getRank()
                            && deck.getDeck()[deckCount].getSuit() == compareDeck.getDeck()[compareCount].getSuit();
                    
                    compareCount++;
                }
                
                passed = found;
                deckCount++;
            }
            return passed;
        } catch (Exception e) {
            System.out.println("shuffleDeck: "+ e.getMessage());
            return false;
        }
    }
    
    /**@return test result*/
    private boolean dealCard()
    {
        CardDeck deck = new CardDeck();
        
        try {
            deck.shuffleDeck();
            Card firstCard = deck.dealCard();
            Card secondCard = deck.dealCard();
            
            return (secondCard.equals(deck.getDeck()[1]));
        } catch (Exception e) {
            System.out.println("dealValidCardFromNewDeck: " + e.getMessage());
            return false;
        }
    }
    
    
    
    /**@return test result*/
    private boolean toStringOfCardDeck()
    {
        CardDeck deck = new CardDeck();
        String testToString = "[2s, 3s, 4s, 5s, 6s, 7s, 8s, 9s, Ts, Js, Qs, Ks, As, " +
                                "2h, 3h, 4h, 5h, 6h, 7h, 8h, 9h, Th, Jh, Qh, Kh, Ah, " +
                                "2c, 3c, 4c, 5c, 6c, 7c, 8c, 9c, Tc, Jc, Qc, Kc, Ac, " +
                                "2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d, Td, Jd, Qd, Kd, Ad]";
        
        try {
            return deck.toString().equals(testToString);
        } catch (Exception e) {
            System.out.println("toStringOfNewDeck: " + e.getMessage());
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////POKER HAND TESTS//////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    //SCENARIO: HIGH CARD
    
    /**@return test results*/
    public boolean addCardOnHighCardValid()
    {
        PokerHand hand = new PokerHand();
        
        try {
            hand.addCard(new Card('7', 'c'));
        } catch (Exception e) {
            System.out.println("addCardOnHighCardValid: " + e.getMessage());
            return false;
        }
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        
        return true;
        
    }
    
    /**@return test results*/
    public boolean addCardOnHighCardInvalid()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        try {
            hand.addCard(new Card('7', 'c'));
        } catch (InvalidHandException e) {
            return true;
        } catch (Exception e) {
            System.out.println("addCardOnHighCardValid: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test results*/
    public boolean getHandOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        String handAsString = "[As, Ks, Qh, 9s, 8c, 5h, 2c]";
    
        try {
            return hand.getHand().toString().equals(handAsString);
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getPocketCardsOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        System.out.println(hand.getPocketCards()[0] + ", " + hand.getPocketCards()[1]);
        
        try {
            return hand.getPocketCards()[0].getRank() == 'A'
                    && hand.getPocketCards()[0].getSuit() == 's'
                    && hand.getPocketCards()[1].getRank() == '2'
                    && hand.getPocketCards()[1].getSuit() == 'c';
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandValidOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean setBestHandInvalidOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        
        try {
            hand.setBestHand();
        } catch (InvalidHandException e) {
            return true;
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test results*/
    public boolean getBestHandOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("High Card");
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 0;
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setWinnerTrueOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        try {
            hand.setWinner(true);
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean setWinnerFalseOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        try {
            hand.setWinner(false);
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean isWinnerOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        hand.setWinner(true);
        
        try {
            return hand.isWinner();
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean isNotWinnerOnHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        hand.setWinner(false);
        
        try {
            return !hand.isWinner();
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnWinningHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        hand.setBestHand();
        hand.setWinner(true);
        
        String testToString = "As Ks Qh 9s 8c 5h 2c High Card WINNER!";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnLosingHighCard()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('2', 'c'));
        hand.addCard(new Card('5', 'h'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('8', 'c'));
        hand.addCard(new Card('Q', 'h'));
        hand.addCard(new Card('9', 's'));
        
        hand.setBestHand();
        hand.setWinner(false);
        
        String testToString = "As Ks Qh 9s 8c 5h 2c High Card";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch (Exception e) {
            System.out.println("getHandOnHighCard: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Pair
    
    /**@return test results*/
    public boolean getHandOnPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('Q', 'H'));
        
        String getHandToString = "[As, Ks, Qh, Tc, 7d, 6c, 6d]";
        
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnPair: " + e.getLocalizedMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('Q', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnPair: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('Q', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Pair");
        } catch(Exception e) {
            System.out.println("getHandOnPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('Q', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 1;
        } catch(Exception e) {
            System.out.println("getHandOnPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('Q', 'H'));
        
        hand.setBestHand();
        
        String testToString = "6c 6d As Ks Qh Tc 7d Pair";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnPair: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: TWO PAIR
    
    /**@return test results*/
    public boolean getHandOnTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('T', 'H'));
        
        String getHandToString = "[As, Ks, Th, Tc, 7d, 6c, 6d]";
        
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('T', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnTwoPair: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('T', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Two Pair");
        } catch(Exception e) {
            System.out.println("getHandOnTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('T', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 2;
        } catch(Exception e) {
            System.out.println("getHandOnTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('T', 'H'));
        
        hand.setBestHand();
        
        String testToString = "Th Tc 6c 6d As Ks 7d Two Pair";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Three Of A Kind
    
    /**@return test results*/
    public boolean getHandOnThreeOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        String getHandToString = "[As, Ks, Tc, 7d, 6h, 6c, 6d]";
       
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnThreeOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnThreeOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnThreeOfAKind: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnThreeOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Three of a Kind");
        } catch(Exception e) {
            System.out.println("getHandOnThreeOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnThreeOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 3;
        } catch(Exception e) {
            System.out.println("getHandOnThreeOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnThreeOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        String testToString = "6h 6c 6d As Ks Tc 7d Three of a Kind";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnThreeOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Straight
    
    /**@return test results*/
    public boolean getHandOnStraight()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('4', 'D'));
        hand.addCard(new Card('5', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('A', 'H'));
        
        String getHandToString = "[Ah, Ks, 7d, 6c, 5c, 4d, 3s]";
        
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnStraight: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnStraight()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('4', 'D'));
        hand.addCard(new Card('5', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnStraight: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnStraight()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('4', 'D'));
        hand.addCard(new Card('5', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('A', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Straight");
        } catch(Exception e) {
            System.out.println("getHandOnStraight: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnStraight()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('4', 'D'));
        hand.addCard(new Card('5', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('A', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 4;
        } catch(Exception e) {
            System.out.println("getHandOnStraight: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnStraight()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('4', 'D'));
        hand.addCard(new Card('5', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('A', 'H'));
        
        hand.setBestHand();
        
        String testToString = "7d 6c 5c 4d 3s Ah Ks Straight";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnStraight: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Flush
    
    /**@return test results*/
    public boolean getHandOnFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'C'));
        hand.addCard(new Card('Q', 'S'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        String getHandToString = "[Ks, Qs, Ts, 9c, 6h, 6s, 3s]";
        
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnFlush: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'C'));
        hand.addCard(new Card('Q', 'S'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnFlush: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'C'));
        hand.addCard(new Card('Q', 'S'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Flush");
        } catch(Exception e) {
            System.out.println("getHandOnFlush: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'C'));
        hand.addCard(new Card('Q', 'S'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 5;
        } catch(Exception e) {
            System.out.println("getHandOnFlush: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'C'));
        hand.addCard(new Card('Q', 'S'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        String testToString = "Ks Qs Ts 6s 3s 9c 6h Flush";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnFlush: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Full House (From Two Pair)
    
    /**@return test results*/
    public boolean getHandOnFullHouseFromTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        String getHandToString = "[As, Ts, Tc, 7d, 6h, 6c, 6d]";
        
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnFullHouseFromTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromTwoPair: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnFullHouseFromTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Full House");
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnFullHouseFromTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 6;
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnFullHouseFromTwoPair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        String testToString = "6h 6c 6d Ts Tc As 7d Full House";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Full House (From Two Pair)
    
    /**@return test results*/
    public boolean getHandOnFullHouseFromThreePair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        String getHandToString = "[Ts, Tc, 7d, 7s, 6h, 6c, 6d]";
        
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromThreePair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnFullHouseFromThreePair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromThreePair: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnFullHouseFromThreePair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Full House");
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromThreePair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnFullHouseFromThreePair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 6;
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromThreePair: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnFullHouseFromThreePair()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('7', 'D'));
        hand.addCard(new Card('T', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        String testToString = "6h 6c 6d Ts Tc 7d 7s Full House";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnFullHouseFromThreePair: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Four Of A Kind
    
    /**@return test results*/
    public boolean getHandOnFourOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        String getHandToString = "[As, Ks, Tc, 6h, 6s, 6c, 6d]";

        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnFourOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnFourOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnFourOfAKind: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnFourOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
    
        try {
            return hand.getBestHand().equals("Four of a Kind");
        } catch(Exception e) {
            System.out.println("getHandOnFourOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnFourOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 7;
        } catch(Exception e) {
            System.out.println("getHandOnFourOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnFourOfAKind()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 'S'));
        hand.addCard(new Card('6', 'D'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('6', 'C'));
        hand.addCard(new Card('6', 'S'));
        hand.addCard(new Card('K', 'S'));
        hand.addCard(new Card('6', 'H'));
        
        hand.setBestHand();
        
        String testToString = "6h 6s 6c 6d As Ks Tc Four of a Kind";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnFourOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Straight Flush
    
    /**@return test results*/
    public boolean getHandOnStraightFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'D'));
        hand.addCard(new Card('5', 'S'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('4', 'S'));
        hand.addCard(new Card('6', 'S'));
        
        String getHandToString = "[Tc, 9d, 7s, 6s, 5s, 4s, 3s]";
        
        try {
            return hand.getHand().toString().equals(getHandToString);
        } catch(Exception e) {
            System.out.println("getHandOnStraightFlush: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean setBestHandOnStraightFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'D'));
        hand.addCard(new Card('5', 'S'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('4', 'S'));
        hand.addCard(new Card('6', 'S'));
        
        try {
            hand.setBestHand();
        } catch(Exception e) {
            System.out.println("getHandOnStraightFlush: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    public boolean getBestHandOnStraightFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'D'));
        hand.addCard(new Card('5', 'S'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('4', 'S'));
        hand.addCard(new Card('6', 'S'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHand().equals("Straight Flush");
        } catch(Exception e) {
            System.out.println("getHandOnStraightFlush: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean getBestHandValueOnStraightFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'D'));
        hand.addCard(new Card('5', 'S'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('4', 'S'));
        hand.addCard(new Card('6', 'S'));
        
        hand.setBestHand();
        
        try {
            return hand.getBestHandValue() == 8;
        } catch(Exception e) {
            System.out.println("getHandOnStraightFlush: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    public boolean toStringOnStraightFlush()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('3', 'S'));
        hand.addCard(new Card('9', 'D'));
        hand.addCard(new Card('5', 'S'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('7', 'S'));
        hand.addCard(new Card('4', 'S'));
        hand.addCard(new Card('6', 'S'));
        
        hand.setBestHand();
        
        String testToString = "7s 6s 5s 4s 3s Tc 9d Straight Flush";
        System.out.println(hand.toString());
        try {
            return hand.toString().equals(testToString);
        } catch(Exception e) {
            System.out.println("getHandOnStraightFlush: " + e.getMessage());
            return false;
        }
    }
    
    //////////////////////////////TESTS ON POKER HAND: FOLDED BEFORE FLOP/////////////////////////////////////////
    
    //SCENARIO: High Card
    
    /**@return results*/
    private boolean getBestHandOnHighCardPreFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('K', 's'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnHighCardPreFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("High Card");
        } catch (Exception e) {
            System.out.println("getBestHandOnHighCardPreFlop: " + e.getMessage());
            return false;
        }
    }
    
    /**@return results*/
    private boolean hasFoldedOnHighCardPreFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('K', 's'));
        
        try {
            hand.fold(true);
            return hand.hasFolded();
        } catch (Exception e) {
            System.out.println("getBestHandOnHighCardPreFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Pair
    
    /**@return test results*/
    private boolean getBestHandOnPairPreFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('A', 'h'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnPairPreFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Pair");
        } catch (Exception e) {
            System.out.println("getBestHandOnPairPreFlop: " + e.getMessage());
            return false;
        }
    }
    
    /**@return results*/
    private boolean hasFoldedOnPairPreFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('K', 's'));
        
        try {
            hand.fold(true);
            return hand.hasFolded();
        } catch (Exception e) {
            System.out.println("getBestHandOnPairPreFlop: " + e.getMessage());
            return false;
        }
    }
    
    //////////////////////////////TESTS ON POKER HAND: FOLDED AFTER FLOP/////////////////////////////////////////
    
    //SCENARIO: High Card
    
    /**@return test results*/
    private boolean getBestHandOnHighCardAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('5', 'c'));
        hand.addCard(new Card('8', 'h'));
        hand.addCard(new Card('3', 'd'));
        hand.addCard(new Card('7', 'h'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnHighCardAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("High Card");
        } catch (Exception e) {
            System.out.println("getBestHandOnHighCardAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Pair
    
    /**@return test results*/
    private boolean getBestHandOnPairAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('5', 'c'));
        hand.addCard(new Card('8', 'h'));
        hand.addCard(new Card('3', 'd'));
        hand.addCard(new Card('5', 'h'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnPairAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Pair");
        } catch (Exception e) {
            System.out.println("getBestHandOnPairAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Two Pair
    
    /**@return test results*/
    private boolean getBestHandOnTwoPairAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('5', 'c'));
        hand.addCard(new Card('8', 'h'));
        hand.addCard(new Card('A', 'd'));
        hand.addCard(new Card('5', 'h'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnTwoPairAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Two Pair");
        } catch (Exception e) {
            System.out.println("getBestHandOnTwoPairAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Three Of A Kind
    
    /**@return test results*/
    private boolean getBestHandOnThreeOfAKindAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('A', 's'));
        hand.addCard(new Card('5', 'c'));
        hand.addCard(new Card('8', 'h'));
        hand.addCard(new Card('5', 'd'));
        hand.addCard(new Card('5', 'h'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnThreeOfAKindAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Three of a Kind");
        } catch (Exception e) {
            System.out.println("getBestHandOnThreeOfAKindAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Straight
    
    /**@return test results*/
    private boolean getBestHandOnStraightAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('7', 's'));
        hand.addCard(new Card('4', 'c'));
        hand.addCard(new Card('8', 'h'));
        hand.addCard(new Card('6', 'd'));
        hand.addCard(new Card('5', 'h'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnStraightAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            System.out.println(hand);
            return hand.getBestHand().equals("Straight");
        } catch (Exception e) {
            System.out.println("getBestHandOnStraightAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Flush
    
     /**@return test results*/
    private boolean getBestHandOnFlushAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('2', 's'));
        hand.addCard(new Card('T', 's'));
        hand.addCard(new Card('8', 's'));
        hand.addCard(new Card('K', 's'));
        hand.addCard(new Card('5', 's'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnFlushAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Flush");
        } catch (Exception e) {
            System.out.println("getBestHandOnFlushAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Full House
    
    /**@return test results*/
    private boolean getBestHandOnFullHouseAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('2', 's'));
        hand.addCard(new Card('T', 'h'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('2', 'H'));
        hand.addCard(new Card('T', 'd'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnFullHouseAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Full House");
        } catch (Exception e) {
            System.out.println("getBestHandOnFullHouseAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Four Of A Kind
    
    /**@return test results*/
    private boolean getBestHandOnFourOfAKindAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('T', 's'));
        hand.addCard(new Card('T', 'h'));
        hand.addCard(new Card('T', 'C'));
        hand.addCard(new Card('2', 'H'));
        hand.addCard(new Card('T', 'd'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnFourOfAKindAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Four of a Kind");
        } catch (Exception e) {
            System.out.println("getBestHandOnFourOfAKindAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Straight Flush
    
    /**@return test results*/
    private boolean getBestHandOnStraightFlushAfterFlop()
    {
        PokerHand hand = new PokerHand();
        
        hand.addCard(new Card('7', 's'));
        hand.addCard(new Card('4', 's'));
        hand.addCard(new Card('8', 's'));
        hand.addCard(new Card('6', 's'));
        hand.addCard(new Card('5', 's'));
        
        try {
            hand.setBestHand();
        } catch (Exception e) {
            System.out.println("getBestHandOnStraightFlushAfterFlop: " + e.getMessage());
            return false;
        }
        try {
            return hand.getBestHand().equals("Straight Flush");
        } catch (Exception e) {
            System.out.println("getBestHandOnStraightFlushAfterFlop: " + e.getMessage());
            return false;
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////POKER TABLE TESTS/////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //SCENARIO: Poker Table of 3 With No Folds and No Ties
    
    /**@return test results*/
    private boolean shuffleUpAndDealToTableOf3()
    {
        PokerTableTest table = new PokerTableTest();
        
        try {
            table.shuffleUpAndDeal(3);
        } catch(Exception e) {
            System.out.println("shuffleUpAndDealToTableOf3: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    private boolean dealFlopToTableOf3Valid()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        
        try {
            table.dealFlop();
        } catch(Exception e) {
            System.out.println("dealFlopToTableOf3Valid: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    private boolean dealFlopToTableOf3Invalid()
    {
        PokerTableTest table = new PokerTableTest();
        
        try {
            table.dealFlop();
        } catch(InvalidDealException e) {
            return true;
        } catch(Exception e) {
            System.out.println("dealFlopToTableOf3Invalid: " + e.getMessage());
            return false;
        } 
        return false;
    }
    
    /**@return test results*/
    private boolean dealTurnToTableOf3Valid()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        
        try {
            table.dealTurn();
        } catch(Exception e) {
            System.out.println("dealTurnToTableOf3Valid: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    private boolean dealTurnToTableOf3Invalid()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        
        try {
            table.dealTurn();
        } catch(InvalidDealException e) {
            return true;
        } catch(Exception e) {
            System.out.println("dealTurnToTableOf3Invalid: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test results*/
    private boolean dealRiverToTableOf3Valid()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        
        try {
            table.dealRiver();
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Valid: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    /**@return test results*/
    private boolean dealRiverToTableOf3Invalid()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        
        try {
            table.dealRiver();
        } catch (InvalidDealException e) {
            return true;
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Invalid: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test results*/
    private boolean getWinningHandOfTableOf3()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        table.dealRiver();
        
        String winningHandToString = "[Ks, Js, Ts, 9s, 7s, 4s, 2h]";
        
        try {
            List<PokerHand> winners = table.getWinningHand();
            System.out.println(winners.get(0));
            return winners.size()==1 && winners.get(0).getHand().toString().equals(winningHandToString);
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    private boolean toStringOfTableOf3()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        table.dealRiver();
        
        table.getWinningHand();
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("2s 5s \t9s Ts Js  Ks  2h  Flush\n");
        testToString.append("3s 6s \t9s Ts Js  Ks  2h  Flush\n");
        testToString.append("4s 7s \t9s Ts Js  Ks  2h  Flush  WINNER!\n");
        
        try {
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Table of 3 With 1 Fold
    
    /**@return test results*/
    private boolean getWinningHandOfTableOf3WithFold()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        table.dealRiver();
        
        table.foldPlayer(2);
        
        String winningHandToString = "[Ks, Js, Ts, 9s, 6s, 3s, 2h]";
        
        try {
            List<PokerHand> winners = table.getWinningHand();
            return winners.size()==1 && winners.get(0).getHand().toString().equals(winningHandToString);
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    private boolean toStringOfTableOf3WithFold()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        table.dealRiver();
        
        table.foldPlayer(2);
        
        table.getWinningHand();
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("2s 5s \t9s Ts Js  Ks  2h  Flush\n");
        testToString.append("3s 6s \t9s Ts Js  Ks  2h  Flush  WINNER!\n");
        testToString.append("4s 7s \t9s Ts Js  Ks  2h  Folded\n");
        
        try {
            table.toString();
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }  
    
    //SCENARIO: Table of 3 With 2 Folds After The River
    
    /**@return test results*/
    private boolean getWinningHandOfTableOf3With2FoldsAfterRiver()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        table.dealRiver();
        
        table.foldPlayer(1);
        table.foldPlayer(2);
        
        String winningHandToString = "[Ks, Js, Ts, 9s, 5s, 2s, 2h]";
        
        try {
            List<PokerHand> winners = table.getWinningHand();
            return winners.size()==1 && winners.get(0).getHand().toString().equals(winningHandToString);
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    private boolean toStringOfTableOf3With2FoldsAfterRiver()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        table.dealRiver();
        
        table.foldPlayer(1);
        table.foldPlayer(2);
        
        table.getWinningHand();
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("2s 5s \t9s Ts Js  Ks  2h  Flush  WINNER!\n");
        testToString.append("3s 6s \t9s Ts Js  Ks  2h  Folded\n");
        testToString.append("4s 7s \t9s Ts Js  Ks  2h  Folded\n");
        
        try {
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Invalid: " + e.getMessage());
            return false;
        }
    } 
    
    //SCENARIO: Table of 3 With 2 Folds Before The River
    
    /**@return test results*/
    private boolean dealRiverOfTableOf3With2FoldsBeforeRiver()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        
        table.foldPlayer(0);
        table.foldPlayer(2);
        
        try {
            table.dealRiver();
        } catch (InvalidDealException e) {
            return true;
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test results*/
    private boolean getWinningHandOfTableOf3With2FoldsBeforeRiver()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        
        table.foldPlayer(0);
        table.foldPlayer(2);
        
        String winningHandToString = "[Ks, Js, Ts, 9s, 6s, 3s]";
        
        try {
            List<PokerHand> winners = table.getWinningHand();
            return winners.size()==1 && winners.get(0).getHand().toString().equals(winningHandToString);
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    private boolean toStringOfTableOf3With2FoldsBeforeRiver()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        table.dealTurn();
        
        table.foldPlayer(0);
        table.foldPlayer(2);
        
        table.getWinningHand();
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("2s 5s \t9s Ts Js  Ks  Folded\n");
        testToString.append("3s 6s \t9s Ts Js  Ks  Flush  WINNER!\n");
        testToString.append("4s 7s \t9s Ts Js  Ks  Folded\n");
        
        try {
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Invalid: " + e.getMessage());
            return false;
        }
    } 
    
    //SCENARIO: Table of 3 With 2 Folds Before The Turn
    
    /**@return test results*/
    private boolean dealTurnOfTableOf3With2FoldsBeforeTurn()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        
        table.foldPlayer(0);
        table.foldPlayer(2);
        
        try {
            table.dealTurn();
        } catch (InvalidDealException e) {
            return true;
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test results*/
    private boolean getWinningHandOfTableOf3With2FoldsBeforeTurn()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        
        table.foldPlayer(1);
        table.foldPlayer(2);
        
        String winningHandToString = "[Js, Ts, 9s, 5s, 2s]";
        
        try {
            List<PokerHand> winners = table.getWinningHand();
            return winners.size()==1 && winners.get(0).getHand().toString().equals(winningHandToString);
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    private boolean toStringOfTableOf3With2FoldsBeforeTurn()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        table.dealFlop();
        
        table.foldPlayer(1);
        table.foldPlayer(2);
        
        table.getWinningHand();
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("2s 5s \t9s Ts Js  Flush  WINNER!\n");
        testToString.append("3s 6s \t9s Ts Js  Folded\n");
        testToString.append("4s 7s \t9s Ts Js  Folded\n");
        
        try {
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Invalid: " + e.getMessage());
            return false;
        }
    } 
    
    //SCENARIO: Table of 3 With 2 Folds Before the Flop
    
    /**@return test results*/
    private boolean dealFlopOfTableOf3With2FoldsBeforeFlop()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        
        table.foldPlayer(0);
        table.foldPlayer(2);
        
        try {
            table.dealFlop();
        } catch (InvalidDealException e) {
            return true;
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    /**@return test results*/
    private boolean getWinningHandOfTableOf3With2FoldsBeforeFlop()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        
        table.foldPlayer(1);
        table.foldPlayer(2);
        
        String winningHandToString = "[5s, 2s]";
        
        try {
            List<PokerHand> winners = table.getWinningHand();
            return winners.size()==1 && winners.get(0).getHand().toString().equals(winningHandToString);
        } catch(Exception e) {
            System.out.println("getWinningHandOfTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    /**@return test results*/
    private boolean toStringOfTableOf3With2FoldsBeforeFlop()
    {
        PokerTableTest table = new PokerTableTest();
        
        table.shuffleUpAndDeal(3);
        
        table.foldPlayer(1);
        table.foldPlayer(2);
        
        table.getWinningHand();
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("2s 5s  High Card  WINNER!\n");
        testToString.append("3s 6s  Folded\n");
        testToString.append("4s 7s  Folded\n");
        
        try {
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("dealRiverToTableOf3Invalid: " + e.getMessage());
            return false;
        }
    }
    
    /////////////////////////POKER TABLE TESTS ON EACH HAND TYPE/////////////////////////////////////
    
    //SCENARIO: High Card
    
    /**@return test result*/
    private boolean pokerTableHighCard()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('A', 's');
        player1[1] = new Card('2', 'C');
        
        player2[0] = new Card('K', 's');
        player2[1] = new Card('3', 'C');
        
        player3[0] = new Card('Q', 's');
        player3[1] = new Card('5', 'C');
        
        flop[0] = new Card('T', 'h');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('8', 'h');
        
        Card turn = new Card('J', 'c');
        Card river = new Card('7', 's');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("As 2c \tTh 6d 8h  Jc  7s  High Card  WINNER!\n");
        testToString.append("Ks 3c \tTh 6d 8h  Jc  7s  High Card\n");
        testToString.append("Qs 5c \tTh 6d 8h  Jc  7s  High Card\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableHighCard: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Pair
    
    /**@return test result*/
    private boolean pokerTablePair()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('T', 's');
        player1[1] = new Card('2', 'C');
        
        player2[0] = new Card('T', 'c');
        player2[1] = new Card('3', 'C');
        
        player3[0] = new Card('T', 'd');
        player3[1] = new Card('5', 'C');
        
        flop[0] = new Card('T', 'h');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('8', 'h');
        
        Card turn = new Card('J', 'c');
        Card river = new Card('9', 's');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("Ts 2c \tTh 6d 8h  Jc  9s  Pair  SPLIT WINNER!\n");
        testToString.append("Tc 3c \tTh 6d 8h  Jc  9s  Pair  SPLIT WINNER!\n");
        testToString.append("Td 5c \tTh 6d 8h  Jc  9s  Pair  SPLIT WINNER!\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTablePair: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Two Pair
    
    /**@return test result*/
    private boolean pokerTableTwoPair()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('T', 's');
        player1[1] = new Card('2', 'C');
        
        player2[0] = new Card('T', 'c');
        player2[1] = new Card('3', 'C');
        
        player3[0] = new Card('T', 'd');
        player3[1] = new Card('5', 'C');
        
        flop[0] = new Card('T', 'h');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('6', 'h');
        
        Card turn = new Card('J', 'c');
        Card river = new Card('9', 's');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("Ts 2c \tTh 6d 6h  Jc  9s  Two Pair  SPLIT WINNER!\n");
        testToString.append("Tc 3c \tTh 6d 6h  Jc  9s  Two Pair  SPLIT WINNER!\n");
        testToString.append("Td 5c \tTh 6d 6h  Jc  9s  Two Pair  SPLIT WINNER!\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableTwoPair: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Three Of A Kind
    
    /**@return test result*/
    private boolean pokerTableThreeOfAKind()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('T', 's');
        player1[1] = new Card('2', 'C');
        
        player2[0] = new Card('T', 'c');
        player2[1] = new Card('3', 'C');
        
        player3[0] = new Card('T', 'd');
        player3[1] = new Card('5', 'C');
        
        flop[0] = new Card('6', 'c');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('6', 'h');
        
        Card turn = new Card('J', 'c');
        Card river = new Card('9', 's');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("Ts 2c \t6c 6d 6h  Jc  9s  Three of a Kind  SPLIT WINNER!\n");
        testToString.append("Tc 3c \t6c 6d 6h  Jc  9s  Three of a Kind  SPLIT WINNER!\n");
        testToString.append("Td 5c \t6c 6d 6h  Jc  9s  Three of a Kind  SPLIT WINNER!\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableThreeOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Straight
    
    /**@return test result*/
    private boolean pokerTableStraight()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('T', 's');
        player1[1] = new Card('8', 'h');
        
        player2[0] = new Card('T', 'c');
        player2[1] = new Card('8', 'C');
        
        player3[0] = new Card('T', 'd');
        player3[1] = new Card('8', 'd');
        
        flop[0] = new Card('6', 'c');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('Q', 'h');
        
        Card turn = new Card('J', 'c');
        Card river = new Card('9', 's');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("Ts 8h \t6c 6d Qh  Jc  9s  Straight  SPLIT WINNER!\n");
        testToString.append("Tc 8c \t6c 6d Qh  Jc  9s  Straight  SPLIT WINNER!\n");
        testToString.append("Td 8d \t6c 6d Qh  Jc  9s  Straight  SPLIT WINNER!\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableStraight: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Flush
    
    /**@return test result*/
    private boolean pokerTableFlush()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('A', 'c');
        player1[1] = new Card('8', 'c');
        
        player2[0] = new Card('T', 'c');
        player2[1] = new Card('4', 'C');
        
        player3[0] = new Card('Q', 'c');
        player3[1] = new Card('3', 'c');
        
        flop[0] = new Card('6', 'c');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('Q', 'h');
        
        Card turn = new Card('J', 'c');
        Card river = new Card('9', 'c');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("Ac 8c \t6c 6d Qh  Jc  9c  Flush  WINNER!\n");
        testToString.append("Tc 4c \t6c 6d Qh  Jc  9c  Flush\n");
        testToString.append("Qc 3c \t6c 6d Qh  Jc  9c  Flush\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableStraight: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Full House
    
    /**@return test result*/
    private boolean pokerTableFullHouse()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('A', 'c');
        player1[1] = new Card('A', 'h');
        
        player2[0] = new Card('T', 'c');
        player2[1] = new Card('T', 'h');
        
        player3[0] = new Card('4', 'h');
        player3[1] = new Card('4', 'c');
        
        flop[0] = new Card('6', 'c');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('6', 'h');
        
        Card turn = new Card('J', 'c');
        Card river = new Card('9', 'c');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("Ac Ah \t6c 6d 6h  Jc  9c  Full House  WINNER!\n");
        testToString.append("Tc Th \t6c 6d 6h  Jc  9c  Full House\n");
        testToString.append("4h 4c \t6c 6d 6h  Jc  9c  Full House\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableFullHouse: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Four of a Kind
    
    /**@return test result*/
    private boolean pokerTableFourOfAKind()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('8', 's');
        player1[1] = new Card('8', 'd');
        
        player2[0] = new Card('6', 's');
        player2[1] = new Card('T', 'h');
        
        player3[0] = new Card('4', 'h');
        player3[1] = new Card('4', 'c');
        
        flop[0] = new Card('8', 'c');
        flop[1] = new Card('6', 'd');
        flop[2] = new Card('6', 'h');
        
        Card turn = new Card('8', 'h');
        Card river = new Card('6', 'c');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("8s 8d \t8c 6d 6h  8h  6c  Four of a Kind  WINNER!\n");
        testToString.append("6s Th \t8c 6d 6h  8h  6c  Four of a Kind\n");
        testToString.append("4h 4c \t8c 6d 6h  8h  6c  Full House\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableFourOfAKind: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Straight Flush
    
    /**@return test result*/
    private boolean pokerTableStraightFlush()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('8', 's');
        player1[1] = new Card('8', 'd');
        
        player2[0] = new Card('6', 's');
        player2[1] = new Card('4', 'h');
        
        player3[0] = new Card('5', 'h');
        player3[1] = new Card('4', 'c');
        
        flop[0] = new Card('T', 's');
        flop[1] = new Card('9', 's');
        flop[2] = new Card('Q', 's');
        
        Card turn = new Card('J', 's');
        Card river = new Card('K', 's');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("8s 8d \tTs 9s Qs  Js  Ks  Straight Flush  SPLIT WINNER!\n");
        testToString.append("6s 4h \tTs 9s Qs  Js  Ks  Straight Flush  SPLIT WINNER!\n");
        testToString.append("5h 4c \tTs 9s Qs  Js  Ks  Straight Flush  SPLIT WINNER!\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableStraightFlush: " + e.getMessage());
            return false;
        }
    }
    
    //SCENARIO: Royal Flush
    
    /**@return test result*/
    private boolean pokerTableRoyalFlush()
    {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card[] player3 = new Card[2];
        Card[] flop = new Card[3];
        
        player1[0] = new Card('8', 's');
        player1[1] = new Card('8', 'd');
        
        player2[0] = new Card('6', 's');
        player2[1] = new Card('T', 'h');
        
        player3[0] = new Card('4', 'h');
        player3[1] = new Card('4', 'c');
        
        flop[0] = new Card('T', 's');
        flop[1] = new Card('A', 's');
        flop[2] = new Card('Q', 's');
        
        Card turn = new Card('J', 's');
        Card river = new Card('K', 's');
        
        StringBuilder testToString = new StringBuilder();
        testToString.append("8s 8d \tTs As Qs  Js  Ks  Royal Flush!!!  SPLIT WINNER!\n");
        testToString.append("6s Th \tTs As Qs  Js  Ks  Royal Flush!!!  SPLIT WINNER!\n");
        testToString.append("4h 4c \tTs As Qs  Js  Ks  Royal Flush!!!  SPLIT WINNER!\n");
        
        try {
            PokerTableTest table = new PokerTableTest(player1, player2, player3, flop, turn, river);
            
            table.dealFlop();
            table.dealTurn();
            table.dealRiver();
            
            table.getWinningHand();
            
            System.out.println(table);
            return table.toString().equals(testToString.toString());
        } catch(Exception e) {
            System.out.println("pokerTableRoyalFlush: " + e.getMessage());
            return false;
        }
    }
}
