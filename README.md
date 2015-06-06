# Texas-Hold-Em
A program in Java that simulates a game of Texas Hold Em

# Included Files 

    TexasHoldEm.java - Driver class that accepts the command line argument "-t" or "-p"
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
