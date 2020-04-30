package problems;

public class FindPeakElementInArray_33
{
  public static void main(String[] args) {
    int arr[] = {1, 2, 1, 3, 5 , 6, 4};

    System.out.println(new FindPeakElementInArray_33().findPeakElement(arr));
  }

  public int findPeakElement(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while(l < r) {
      int mid = l + (r - l)/2;

      if(nums[mid] < nums[mid+1]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }

    return l;
  }
}
