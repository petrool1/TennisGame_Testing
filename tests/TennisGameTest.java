import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score should have been tie", "deuce", score);		
	}
	
	@Test
	public void testTennisGame_Player1_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score should have been Player1 leading", "player1 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player1_Advantage2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score should have been Player1 leading", "player1 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player2_Advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score should have been Player2 leading", "player2 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player2_Advantage2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score should have been Player2 leading", "player2 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player1_Win() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Winner should have been Player1", "player1 wins", score);		
	}
	
	@Test
	public void testTennisGame_Player2_Win() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		game.player2Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Winner should have been Player2", "player2 wins", score);		
	}
	
	@Test
	public void testTennisGame_Player1_WinStraight() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Winner should have been Player1", "player1 wins", score);		
	}
	
	@Test
	public void testTennisGame_Player2_WinStraight() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Winner should have been Player2", "player2 wins", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}		
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	

	@Test 
	public void testTennisGameScore_love_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: love - love", "love - love", score);
	}
	
	@Test 
	public void testTennisGameScore_15_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: 15 - love", "15 - love", score);		
	}
	
	@Test 
	public void testTennisGameScore_30_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: 30 - love", "30 - love", score);		
	}
	
	@Test 
	public void testTennisGameScore_40_love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: 40 - love", "40 - love", score);		
	}
	
	@Test 
	public void testTennisGameScore_love_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: love - 15", "love - 15", score);		
	}
	
	@Test 
	public void testTennisGameScore_love_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: love - 30", "love - 30", score);		
	}
	
	@Test 
	public void testTennisGameScore_love_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: love - 40", "love - 40", score);		
	}
	
	@Test 
	public void testTennisGameScore_15_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: 15 - 15", "15 - 15", score);		
	}
	
	@Test 
	public void testTennisGameScore_30_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		//Assert
		assertEquals("Score should have been: 30 - 30", "30 - 30", score);		
	}
	

}
