package mandatoryHomeWork.week4.day3;

import java.util.Stack;

import org.junit.Test;

public class Remove_All_Adjacent_Duplicates_In_String_1047 {

    public static class TestSolution {
        @Test
        public void example1() {
            String s = "abbaca";
            String result = new Remove_All_Adjacent_Duplicates_In_String_1047().removeDuplicates(s);
            System.out.println(result); // Output: "ca"
        }

        @Test
        public void example2() {
            String s = "azxxzy";
            String result = new Remove_All_Adjacent_Duplicates_In_String_1047().removeDuplicates(s);
            System.out.println(result); // Output: "ay"
        }
    }
    
	 public String removeDuplicates(String s) {
	        Stack<Character> stack = new Stack<Character>();

	        for (char c : s.toCharArray()) {
	            if (!stack.isEmpty() && stack.peek() == c) {
	                stack.pop();
	            } else {
	                stack.push(c);
	            }
	        }

	        StringBuilder result = new StringBuilder();
	        while (!stack.isEmpty()) {
	            result.append(stack.pop());
	        }

	        return result.reverse().toString();
	    }


}
