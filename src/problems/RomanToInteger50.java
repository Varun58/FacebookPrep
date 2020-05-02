package problems;

import java.util.HashMap;

public class RomanToInteger50
{
  public static void main(String[] args) {
    System.out.println(new RomanToInteger50().romanToInt("MCMXCIV"));
  }
  static HashMap<String, Integer> values = new HashMap<String, Integer>();

  static {
    values.put("M",1000);
    values.put("D",500);
    values.put("C",100);
    values.put("L",50);
    values.put("X",10);
    values.put("V",5);
    values.put("I",1);
  }

  public int romanToInt(String s) {
    String lastSymbol = s.substring(s.length() -1);
    int lastValue  = values.get(lastSymbol);
    int total = lastValue;

    for(int i = s.length() - 2; i >=0 ;i--) {
      String currentSymbol = s.substring(i, i + 1);
      int currentValue = values.get(currentSymbol);
      if(lastValue > currentValue) {
        total -= currentValue;
      } else {
        total += currentValue;
      }
      lastValue = currentValue;
    }

    return total;
  }
}
