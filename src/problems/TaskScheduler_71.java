package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler_71 {

  //https://www.youtube.com/watch?v=ySTQCRya6B0
  // first option: use priority queue
  // second option: use arrays and sorts
  public int leastInterval(char[] tasks, int n) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    for (char c : tasks) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    maxHeap.addAll(map.values());
    int cycles = 0;

    while (!maxHeap.isEmpty()) {
      List<Integer> tempList = new ArrayList<Integer>();

      for (int i = 0; i < n + 1; i++) {
        if (!maxHeap.isEmpty()) {
          tempList.add(maxHeap.remove());
        }
      }

      for (int task : tempList) {
        if (--task > 0) {
          maxHeap.add(task);
        }
      }

      cycles += maxHeap.isEmpty() ? tempList.size() : n + 1;
    }

    return cycles;
  }
}
