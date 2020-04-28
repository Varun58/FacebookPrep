package problems;

import java.util.regex.Pattern;

public class ValidIPAddress_Part1_23 {

  public static void main(String[] args) {
    System.out.println(new ValidIPAddress_Part1_23().validIPAddress("172.16.254.1"));
    System.out.println(new ValidIPAddress_Part1_23().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    System.out.println(new ValidIPAddress_Part1_23().validIPAddress("256.256.256.256"));
  }

  public String validIPAddress(String IP) {
    if(IP.chars().filter(ch-> ch == '.').count() == 3 ) {
      return validIPv4Address(IP);
    } else if(IP.chars().filter(ch-> ch == ':').count() == 7 ) {
      return validIPv6Address(IP);
    } else return "Neither";
  }

  private String validIPv4Address(String IP) {
    String[] nums = IP.split("\\.", -1);
    for(String x: nums) {
      if(x.length() == 0 || x.length() > 3) {
        return "Neither";
      }

      if(x.charAt(0) == '0' && x.length() != 1 ) {
        return "Neither";
      }

      for(char ch: x.toCharArray()) {
        if(!Character.isDigit(ch)) {
          return "Neither";
        }
      }

      if(Integer.parseInt(x) > 255) {
        return "Neither";
      }
    }
    return "IPv4";
  }

  private String validIPv6Address(String IP) {
    String[] nums = IP.split("\\:", -1);
    String hexDigits = "1234567890abcdefABCDEF";
    for(String x: nums) {
      if(x.length() == 0 || x.length() > 4) {
        return "Neither";
      }

      for(char ch: x.toCharArray()) {
        if(hexDigits.indexOf(ch) == -1) {
          return "Neither";
        }
      }
    }
    return "IPv6";
  }

  String chunkIpv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-5]|25[0-5])";
  Pattern patternIPv4 = Pattern.compile("^("+ chunkIpv4 +"\\.){3}"+ chunkIpv4+"$");

  String chunkIpv6 = "([0-9a-fA-F]{1,4})";
  Pattern patternIPv6 = Pattern.compile("^("+ chunkIpv6 +"\\:){7}"+ chunkIpv6+"$");

  public String validIPAddressRegex(String IP) {
    if(patternIPv4.matcher(IP).matches()) {
      return "IPv4";
    } else if(patternIPv6.matcher(IP).matches()) {
      return "IPv6";
    } else {
      return "Neither";
    }
  }
}
