package lib;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Glyph {

  public int width = 0;
  public int height = 0;
  int x = 0;
  int y = 0;
  byte[][] buffer;

  public Glyph () {}

  public Glyph (String fpath) {
    byte [] buf;
    int i;

    buffer = new byte[80][80];
    
    try {
      buf = Files.readAllBytes(Paths.get(fpath));
      for (i = 0; i < buf.length; i++) {
        byte ch = buf[i];
        if (0x0a == ch) {
          height++;
          y = height -1;
          width = (x > width) ? x : width;
          x = 0;
          buffer[y] = new byte[80];
        }
        else {
          buffer[y][x] = ch;
          x++;
        }
      }
      width++;
      height++;
    }
    catch (IOException e) {
      // ignore ...
    }
  }

  public char charAt (int x, int y) {
    byte value = 0;

    if (x < width && y < height) {
      try {
        value = buffer[y][x];
      }
      catch (Exception e) {
        value = 0x20;
      }
      finally {
        return (char)value;
      }
    }
    else {
      System.out.println("Request exceeds size of glyph");
      return 0x0;
    }
  }

  public boolean isClosure () {

    return false;
  }
}
