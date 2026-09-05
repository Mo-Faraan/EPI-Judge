package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class HIndex {
  @EpiTest(testDataFile = "h_index.tsv")
  public static int hIndex(List<Integer> citations) {

    citations = citations.stream().sorted().toList();
    Integer count = 0;
    int length = citations.size();
    for (int i = 0; i < length; i++) {
      Integer citation = citations.get(i);
      if (citation >= length - i)
        return length - i;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "HIndex.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
