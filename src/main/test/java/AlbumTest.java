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

  @Test
  public void Album_instantiatesWithTitle_True() {
    Album myAlbum = new Album("Space Oddity");
    assertEquals("Space Oddity", myAlbum.getTitle());
  }

  @Test
  public void all_returnsAllInstancesOfAlbum_true() {
    Album firstAlbum = new Album("Mow the lawn");
    Album secondAlbum = new Album("Buy groceries");
    assertEquals(Album.find(secondAlbum.getId()), secondAlbum);
  }
