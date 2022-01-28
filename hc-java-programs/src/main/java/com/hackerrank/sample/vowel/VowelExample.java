package com.hackerrank.sample.vowel;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 2. Vowel Substring
 Given a string of lowercase letters in the range ascii['a'-'z'], determine the number of substrings that can be created where every letter is a vowel and every vowel is present at least once. The vowels are ['a', 'e', 'i', 'o', 'u']. A substring is a contiguous group of characters in the string.
 Example
 s = 'aeioaexaaeuiou'

 There is a substring to the left that is made of vowels, 'aeioae' which is followed by an 'x'. Since 'x' is not a vowel, it cannot be included in the substring, and this substring does not contain all of the vowels. It is not a qualifying substring. Moving to the right, there are four substrings that do qualify: 'aaeuiou', 'aaeuio', 'aeuiou' and 'aeuio'.

 Function Description
 Complete the function vowelSubstring in the editor below.
 vowelSubstring has the following parameter(s):
 string s:  a string
 Returns
 int: the number of substrings which consist of vowels only ('a', 'e,' i', 'o', 'u')  where every vowel appears at least once

 Constraints
 1 ≤ size_of(s) ≤ 105
 s[i] ∈ ascii['a'-'z'] (where 0 ≤ i < size_of(s) )

 Input Format For Custom Testing
 Sample Case 0
 Sample Input For Custom Testing

 STDIN         Function
 -----         --------
 aaeiouxa  →   s = "aaeiouxa"
 Sample Output
 2

 Explanation
 s = "aaeiouxa"
 There are two qualifying substrings:
 s[0:5] = "aaeiou"
 s[1:5] = "aeiou"

 Sample Case 1
 Language
 */

public class VowelExample {


    // Returns true if x is vowel.
    static boolean isVowel(char x) {
        // Function to check whether a character is
        // vowel or not
        return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u');
    }


    /*
     * Complete the 'vowelsubstring' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int vowelsubstring(String s) {
        int count = 0;
        HashSet<Character> hash = new HashSet<Character>();
        // Outer loop picks starting character and
        // inner loop picks ending character.
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                // If current character is not vowel,
                // then no more result substrings
                // possible starting from str[i].
                if (isVowel(s.charAt(j)) == false)
                    break;

                // If vowel, then we insert it in hash
                hash.add(s.charAt(j));

                // If all vowels are present in current substring
                if (hash.size() == 5)
                    count++;
            }
            hash.clear();
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = vowelsubstring(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
