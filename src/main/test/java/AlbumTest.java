import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void Album_instantiatesCorrectly_true() {
    Album myAlbum = new Album("Space Oddity");
    assertEquals(true, myAlbum instanceof Album);
  }
