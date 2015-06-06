# Texas-Hold-Em

Texas Hold 'Em is a program that can read in a poker hands from a Texas Hold 'Em table and
determine who the winner of the hand is, with consideration to the kicker of each hand as 
well as whether or not the hand has been folded. Additionally, the user can choose to simulate
a Texas Hold 'Em hand.

# Compiling

     javac TexasHoldEm.java
     
# Running

     java TexasHoldEm <run mode> <number of players>
     
          <run mode>: "-t" to run a predetermined test version with unit test results printed to stdout, 
                         "-p" to simulate random game of Texas Hold `Em
          <number of players>: The number of players in the game of Texas Hold `Em. Only required for "-p" run mode. 
          
# Tests

This program contains a suite of unit tests that tests the ability to determine each possible hand in a game of Texas Hold `Em as well as the program's ability to determine the winning player in the game, with consideration to kickers. The unit tests are located in the "TexasHoldEmTester" class. Please note, I wrote this program while I was only in my second ever Computer Science class (outside of the course, as part of an internship application process) and was not aware of the JUnit package, so I wrote each test's functionality from scratch. I will likely refactor it using JUnit at some point, but please feel free to refactor it and commit those changes if you would like. The "TexasHoldEmTester" class relies on the "PokerTableTest" which deals cards in a predetermined fashion for testing purposes.
          

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
