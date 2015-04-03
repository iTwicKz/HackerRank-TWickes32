import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner input = new Scanner(System.in);
    	int testCases = input.nextInt();

    	for(int cases = 0; cases < testCases; cases++){

    		String word = input.next();

    		boolean funny = true;

    		for(int i = 0; i < word.length() - 1; i++){
    			int s = Math.abs(word.charAt(i) - word.charAt(i+1));
    			int r = Math.abs(word.charAt(word.length() - i - 1) - word.charAt(word.length() - i - 2));

    			if(r != s){
    				funny = false;
    				break;
    			}
    		}

    		if(funny) System.out.println("Funny");
    		else System.out.println("Not Funny");
    	}
    }
}