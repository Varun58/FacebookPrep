package problems;

//https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/269/discuss/49615/Clean-solution-in-Java
public class ReadNCharactersGivenRead4Part2_9 {

  char[] prevBuf = new char[4];
  int prevIndex = 0;
  int prevSize = 0;

  public int read(char[] buf, int n) {
    int counter = 0;
    while (counter < n) {
      if (prevIndex < prevSize) {
        buf[counter++] = prevBuf[prevIndex++];
      } else {
        prevSize = read4(prevBuf);
        prevIndex = 0;
        if (prevSize == 0) {
          break;
        }
      }
    }

    return counter;
  }

  // dummy read 4 api method
  public int read4(char[] buf) {
    return 0;
  }
}
