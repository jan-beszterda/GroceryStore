package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ShopDataLoader {

  public static ArrayList<String> readData(String fileName) {
    ArrayList<String> data = new ArrayList<>();
    try {
      data = (ArrayList<String>) Files.readAllLines(Paths.get(fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }
}
