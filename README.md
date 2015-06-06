# Texas-Hold-Em

Texas Hold 'Em is a program that can read in a poker hands from a Texas Hold 'Em table and
determine who the winner of the hand is, with consideration to the kicker of each hand as 
well as whether or not the hand has been folded. Additionally, the user can choose to simulate
a Texas Hold 'Em hand.

# Included Files 

     TexasHoldEm.java - <i>Driver class that accepts the command line argument "-t" or "-p"</i>
     TexasHoldEmTester.java - Class that tests the effectiveness of each algorithm used to determine
                              the winning hand.
     PokerTable.java - Class that simulates an individual hand of Texas Hold 'Em where no player folds.
     PokerTableTest.java - Class that allows simulation of specific scenarios of Texas Hold 'Em for testing purposes.
     PokerHand.java - A class that wraps the Cards of a poker player and identifies the best hand that can be made.
     CardDeck.java - A class that wraps a deck of Cards contained in a standard 52 card deck.
     Card.java - A class that wraps a Card that would be contained in a standard 52 card deck.
     InvalidDealException.java - Exception that will be thrown in the instance PokerTable's methods are not called in 
                                   proper order.
     InvalidHandException.java - Exception that will be thrown in the instance a PokerHand contains a number of cards
                                   that is not allowed in traditional Texas Hold 'Em.
     InvalidSuitException.java - Exception that will be thrown in the instance a Card's suit is invalid.
     InvalidRankException.java - Exception that will be thrown in the instance a Card's rank is invalid.
