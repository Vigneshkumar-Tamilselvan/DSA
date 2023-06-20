/*
 * package mandatoryHomeWork.week6.Day_2;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.Assert; import org.junit.Test;
 * 
 * public class Reverse_Only_Letters_917 {
 * 
 * @Test public void test_01() { String word = "ab-cd"; reverse_letters(word);
 * Assert.assertEquals(reverse_letters(word), "dc-ba"); }
 * 
 * @Test public void test_02() { String word = "a-bC-dEf-ghIj";
 * reverse_letters(word); Assert.assertEquals(reverse_letters(word),
 * "j-Ih-gfE-dCba"); }
 * 
 * @Test public void test_03() { String word = "Test1ng-Leet=code-Q!";
 * reverse_letters(word); Assert.assertEquals(reverse_letters(word),
 * "Qedo1ct-eeLg=ntse-T!"); }
 * 
 * private String reverse_letters(String word) { int left = 0, right =
 * word.length() - 1; char[] letter = word.toCharArray(); while (left < right) {
 * if (isWord(letter[left]) && Character.isLetter(letter[right])) { char temp =
 * letter[left]; letter[left++] = letter[right]; letter[right--] = temp; } else
 * if (!(Character.isLetter(letter[left]))) left++; else if
 * (!(Character.isLetter(letter[right]))) right--;
 * 
 * } word.contains(isWord(letter)); isWord(letter) // lower case alphabets are
 * from 97 to 122 // upper case alphabets are from 65 to 90
 * 
 * return String.valueOf(letter);
 * 
 * }
 * 
 * private boolean isWord(char[] letter) {
 * 
 * List<Character> result = new ArrayList<>(); int lc_Start = 97, lc_End = 122;
 * for (int i = lc_Start; i < lc_End; i++) { result.add((char) i); } int
 * uc_Start = 65, uc_End = 90; for (int i = uc_Start; i < lc_End; i++) {
 * result.add((char) i); }
 * 
 * if (result.contains(letter)) return true;
 * 
 * return false; }
 * 
 * }
 * 
 * //Space complexity - O(1) //Time Complexity - O(n)
 */