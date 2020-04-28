package problems;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=JfB3BugMht8
public class RestoreIpAddresses_24 {

  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<String>();
    int n = s.length();
    for(int i=1;i<n && i < 4; i++) {
      String first= s.substring(0, i);
      if(!isValidPart(first)) {
        continue;
      }

      for(int j = 1; i+j <n && j<4 ; j++) {
        String second = s.substring(i, i+j);
        if(!isValidPart(second)) {
          continue;
        }

        for(int k = 1; i+j +k <n && k<4 ; k++) {
          String third = s.substring(i+j, i+j+k);
          String fourth = s.substring(i+j+k);

          if(!isValidPart(third) || !isValidPart(fourth)) {
            continue;
          }
          result.add(first+"."+second+"."+third+"."+fourth);
        }
      }
    }
    return result;
  }

  public boolean isValidPart(String s) {
    if(s.length()> 3) {
      return false;
    }

    if(s.startsWith("0") && s.length() > 1) {
      return false;
    }

    int val = Integer.parseInt(s);
    return val >= 0 && val <= 255;
  }
}
