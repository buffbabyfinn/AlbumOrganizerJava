import java.util.ArrayList;
import java.time.LocalDateTime;

public class Album {
  private static ArrayList<Album> instances = new ArrayList<Album>();

  private String mTitle;
  private int mId;

  public Album(String title) {
    mTitle = title;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle(){
    return mTitle;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Album> all() {
    return instances;
  }

  public static Album find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
}
