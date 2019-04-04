package leetcode;

import leetcode.models.Interval;
import leetcode.models.ListNode;
import leetcode.models.TreeNode;
import org.junit.jupiter.api.Test;

public class GenericTest {

    @Test
    public void DivideTwoInteger() {
        DivideTwoIntegers divide = new DivideTwoIntegers();
        divide.divide(-1, 1);
    }

    @Test
    public void SubstringWithConcatenationOfAllWords() {
        SubstringWithConcatenationOfAllWords substring = new SubstringWithConcatenationOfAllWords();
        substring.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"});
    }

    @Test
    public void NextPermutation() {
        NextPermutation permutation = new NextPermutation();
        permutation.nextPermutation(new int[] {2, 3, 1});
    }

    @Test
    public void LongestValidParentheses() {
        LongestValidParentheses parentheses = new LongestValidParentheses();
        parentheses.longestValidParentheses(")(((((()())()()))()(()))(");
    }

    @Test
    public void SearchInRotatedSortedArray() {
        SearchInRotatedSortedArray rotatedSortedArray = new SearchInRotatedSortedArray();
        rotatedSortedArray.search(new int[] {4,5,6,7,0,1,2}, 0);
    }

    @Test
    public void TrappingRainWater() {
        TrappingRainWater rain = new TrappingRainWater();
        rain.trap(new int[] {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3});
    }

    @Test
    public void MultiplyStrings() {
        MultiplyStrings multiply = new MultiplyStrings();
        multiply.multiply("123", "456");
    }

    @Test
    public void WildcardMatching() {
        WildcardMatching wildcardMatching = new WildcardMatching();
        wildcardMatching.isMatch("a", "a*");
    }

    @Test
    public void MergeIntervals() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new java.util.ArrayList<Interval>() {{
            add(new Interval(4,5));
            add(new Interval(2,4));
            add(new Interval(4,6));
            add(new Interval(3,4));
            add(new Interval(0,0));
            add(new Interval(1,1));
            add(new Interval(3,5));
            add(new Interval(2,2));
        }});
    }

    @Test
    public void uniquePathsWithObstacles() {
        UniquePathsII uniquePathsII = new UniquePathsII();
        uniquePathsII.uniquePathsWithObstacles(new int[][] {{1, 0}});
    }

    @Test
    public void ValidNumber() {
        ValidNumber validNumber = new ValidNumber();
        validNumber.isNumber(" 005047e+6");
    }

    @Test
    public void TextJustification() {
        TextJustification textJustification = new TextJustification();
        textJustification.fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
    }

    @Test
    public void SqrtX() {
        SqrtX sqrtX = new SqrtX();
        sqrtX.mySqrt(2147395599);
    }

    @Test
    public void EditDistance() {
        EditDistance editDistance = new EditDistance();
        editDistance.minDistance("zoologicoarchaeologist", "zoogeologist");
    }

    @Test
    public void MinimumWindowSubstring() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        minimumWindowSubstring.minWindow("aaabdabcefaecbef", "abc");
    }

    @Test
    public void RemoveDuplicatesFromSortedArrayII() {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        removeDuplicatesFromSortedArrayII.removeDuplicates(new int[] {1,1,1,2,2,3});
    }

    @Test
    public void ScrambleString() {
        ScrambleString scrambleString = new ScrambleString();
        scrambleString.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb");
    }

    @Test
    public void SubsetsII() {
        SubsetsII subsetsII = new SubsetsII();
        subsetsII.subsetsWithDup(new int[] {1, 2, 2});
    }

    @Test
    public void DecodeWays() {
        DecodeWays decodeWays = new DecodeWays();
        decodeWays.numDecodings("12");
    }

    @Test
    public void RestoreIPAddresses() {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        restoreIPAddresses.restoreIpAddresses("25525511135");
    }

    @Test
    public void ConstructBinaryTreeFromPreorderAndInorderTraversal() {
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }

    @Test
    public void ConstructBinaryTreeFromInorderAndPostorderTraversal() {
        ConstructBinaryTreeFromInorderAndPostorderTraversal constructBinaryTreeFromInorderAndPostorderTraversal = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        constructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3});
    }

    @Test
    public void DistinctSubsequences() {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        distinctSubsequences.numDistinct("babgbag", "bag");
    }

    @Test
    public void ValidPalindrome() {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
    }

    @Test
    public void WordLadderII() {
        java.util.List<String> wordList = new java.util.ArrayList<String>() {{
            add("hot");add("dot");add("dog");add("lot");add("log");add("cog");
        }};
        WordLadderII wordLadderII = new WordLadderII();
        wordLadderII.findLadders("hit", "cog", wordList);
    }

    @Test
    public void WordLadder() {
        java.util.List<String> wordList = new java.util.ArrayList<String>() {{
            add("hot");add("dot");add("dog");add("lot");add("log");add("cog");
        }};
        WordLadder wordLadder = new WordLadder();
        wordLadder.ladderLength("hit", "cog", wordList);
    }

    @Test
    public void SumRootToLeafNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        sumRootToLeafNumbers.sumNumbers(root);
    }

    @Test
    public void PalindromePartitioningII() {
        PalindromePartitioningII palindromePartitioningII = new PalindromePartitioningII();
        palindromePartitioningII.minCut("aab");
    }

    @Test
    public void GasStation() {
        GasStation gasStation = new GasStation();
        gasStation.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2});
    }

    @Test
    public void Candy() {
        Candy candy = new Candy();
        candy.candy(new int[] {29,51,87,87,72,12});
    }

    @Test
    public void ReorderList() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(first);
    }

    @Test
    public void InsertionSortList() {
        ListNode first = new ListNode(4);
        first.next = new ListNode(2);
        first.next.next = new ListNode(1);
        first.next.next.next = new ListNode(3);
        InsertionSortList insertionSortList = new InsertionSortList();
        insertionSortList.insertionSortList(first);
    }

    @Test
    public void ReverseWordsInAString() {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        reverseWordsInAString.reverseWords("the sky is blue");
    }

    @Test
    public void MaximumProductSubarray() {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        maximumProductSubarray.maxProduct(new int[] {7, -2, -4});
    }

    @Test
    public void FindPeakElement() {
        FindPeakElement findPeakElement = new FindPeakElement();
        findPeakElement.findPeakElement(new int[] {1, 2, 3, 1});
    }

    @Test
    public void CompareVersionNumbers() {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        compareVersionNumbers.compareVersion("0.1", "1.1");
    }

    @Test
    public void RepeatedDNASequences() {
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    @Test
    public void BestTimeToBuyAndSellStockIV() {
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        bestTimeToBuyAndSellStockIV.maxProfit(2, new int[] {8,6,4,3,3,2,3,5,8,3,8,2,6});
    }

    @Test
    public void MinimumSizeSubarraySum() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        minimumSizeSubarraySum.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
    }

    @Test
    public void ShortestPalindrome() {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        shortestPalindrome.shortestPalindrome("aacecaaa");
    }

    @Test
    public void KthLargestElementInAnArray() {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        kthLargestElementInAnArray.findKthLargest(new int[] {3,2,1,5,6,4}, 2);
    }

    @Test
    public void ContainsDuplicateIII() {
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        containsDuplicateIII.containsNearbyAlmostDuplicate(new int[] {-1,2147483647}, 1, 2147483647);
    }

    @Test
    public void BasicCalculator() {
        BasicCalculator basicCalculator = new BasicCalculator();
        basicCalculator.calculate(" 2-1 + 2 ");
    }

    @Test
    public void BasicCalculatorII() {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        basicCalculatorII.calculate("1+1+1");
    }

    @Test
    public void PerfectSquares() {
        PerfectSquares perfectSquares = new PerfectSquares();
        perfectSquares.numSquares(48);
    }

    @Test
    public void FindTheDuplicateNumber() {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        findTheDuplicateNumber.findDuplicate(new int[] {1, 3, 4, 2, 2});
    }

    @Test
    public void WordPattern() {
        WordPattern wordPattern = new WordPattern();
        wordPattern.wordPattern("abba", "dog cat cat dog");
    }

}
