package problems;

//https://leetcode.com/problems/read-n-characters-given-read4/discuss/49557/Accepted-clean-java-solution
public class ReadNCharactersGivenRead4Part1_9 {

  public int read(char[] buf, int n) {
    char[] buffer = new char[4];
    boolean endOfFile = false;
    int readBytes = 0;

    while (readBytes < n && !endOfFile) {
      int currReadBytes = read4(buffer);

      if (currReadBytes != 4) {
        endOfFile = true;
      }

      int toReadBytes = Math.min(n - readBytes, currReadBytes);

      for (int i = 0; i < toReadBytes; i++) {
        buf[readBytes + i] = buffer[i];
      }

      readBytes += toReadBytes;

    }

    return readBytes;
  }

  // dummy read 4 api method
  public int read4(char[] buf) {
    return 0;
  }
}
