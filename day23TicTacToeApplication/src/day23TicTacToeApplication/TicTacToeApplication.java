package day23TicTacToeApplication;

import java.util.Scanner;

public class TicTacToeApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Getting input from User
		Scanner sc = new Scanner(System.in);
		// Allows for continuous game
		boolean doYouWantToPlay = true;

		while (doYouWantToPlay) {
			// Setting up our tokens and AI
			System.out.println("Welcome to TicTacToe! You are about to go against a master AI player."
					+ "Are you ready? \n. But first you must pick what character you want to be and which"
					+ "character I will be: ");
			System.out.println("Enter a single character that will represent you on the board");
			char playerToken = sc.next().charAt(0);
			System.out.println("Enter a single character that will represent your opponent on the board");
			char opponentToken = sc.next().charAt(0);
			TicTacToe game = new TicTacToe(playerToken, opponentToken);
			AI ai = new AI();

			// Set Up the Game
			System.out.println();
			System.out.println("Now we can start the game. To play, enter a number and your token shall "
					+ "be put in its place. \n The numbers goes from 1 -9, left to right. We shall see "
					+ "who will win this round. ");
			TicTacToe.printIndexBoard();
			System.out.println();

			// Let the game begin. Let's play!
			while (game.gameOver().equals("notOver")) {
				if (game.currentMarker == game.userMarker) {
					// USER TURN
					System.out.println("It is your turn. Enter a spot for your token");
					int spot = sc.nextInt();
					while (game.playTurn(spot)) {
						System.out.println("Try again. " + spot + " is invalid. This spot is already taken "
								+ "or it out of range");
						spot = sc.nextInt();
					}
					System.out.println("You picked " + spot + " !");
				} else {
					// AI Turn
					System.out.println("It is my turn");
					// Pick spot
					int aiSpot = ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked " + aiSpot + " !");
				}
				// Print out new board
				System.out.println();
				game.printBoard();
			}
			System.out.println(game.gameOver());
			System.out.println();

			// Set up a new game / not depending on the response
			System.out.println("Do you want to play again? Enter Y if you do. Enter anything else if you are "
					+ "tired of playing. ");
			char response = sc.next().charAt(0);
			doYouWantToPlay = (response == 'Y');
			System.out.println();
			System.out.println();

		}
	}

}
