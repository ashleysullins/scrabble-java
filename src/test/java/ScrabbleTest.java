import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleTest {

  @Test
  public void scrabbleScore_returnsAScoreOfOneForA_1() {
      Scrabble app = new Scrabble();
      Integer score = 1;
      assertEquals(score, app.scrabbleScore("a"));
  }
}
