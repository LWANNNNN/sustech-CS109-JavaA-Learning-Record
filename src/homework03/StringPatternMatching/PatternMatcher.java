package homework03.StringPatternMatching;

import java.util.Arrays;
import java.util.Scanner;

public class PatternMatcher
{
    public static int[] findPatternMatches1(String text, String pattern)
    {
        int resultLength = 0;

        for (int i = 0; i < text.length() - pattern.length() + 1; i++)
        {
            String testStr = "";
            if (i < text.length() - pattern.length())
            {
                testStr = text.substring(i, i + pattern.length());
            } else
            {
                testStr = text.substring(i);
            }

            if (testStr.equals(pattern))
            {
                resultLength++;
            }
        }

        int[] result = new int[resultLength];
        int position = 0;
        for (int i = 0; i < text.length() - pattern.length() + 1; i++)
        {
            String testStr = "";
            if (i < text.length() - pattern.length())
            {
                testStr = text.substring(i, i + pattern.length());
            } else
            {
                testStr = text.substring(i);
            }


            if (testStr.equals(pattern))
            {
                result[position] = i;
                position++;
            }
        }

        return result;
    }

    public static int[] findPatternMatches2(String text, String pattern)
    {
        int resultLength = 0;

        for (int i = 0; i < text.length() - pattern.length() + 1; i++)
        {
            String subText = text.substring(i);
            char[] subtextChar = subText.toCharArray();
            char[] patternChar = pattern.toCharArray();

            if (subtextChar[0] == patternChar[0])
            {
                int correctnum = 1;
                int newstart = 1;
                for (int j = 1; j < patternChar.length; j++)
                {

                    for (int k = newstart; k < subtextChar.length; k++)
                    {
                        if (patternChar[j] == subtextChar[k])
                        {
                            correctnum++;
                            newstart = k + 1;
                            break;
                        }
                    }
                }

                if (correctnum == patternChar.length)
                {
                    resultLength++;
                }
            }
        }

        int[] result = new int[resultLength];
        int position = 0;
        for (int i = 0; i < text.length() - pattern.length() + 1; i++)
        {
            String subText = text.substring(i);
            char[] subtextChar = subText.toCharArray();
            char[] patternChar = pattern.toCharArray();

            if (subtextChar[0] == patternChar[0])
            {
                int correctnum = 1;
                int newstart = 1;
                for (int j = 1; j < patternChar.length; j++)
                {

                    for (int k = newstart; k < subtextChar.length; k++)
                    {
                        if (patternChar[j] == subtextChar[k])
                        {
                            correctnum++;
                            newstart = k + 1;
                            break;
                        }
                    }
                }

                if (correctnum == patternChar.length)
                {
                    result[position] = i;
                    position++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "aabaa";
        String pattern = "aba";
        System.out.println(Arrays.toString(findPatternMatches1(text, pattern)));// [1]
        System.out.println(Arrays.toString(findPatternMatches2(text, pattern)));// [0,1]

        int[] test1 = findPatternMatches1(text, pattern);
        System.out.println(test1.length);
        int[] test2 = findPatternMatches2(text, pattern);
        System.out.println(test2.length);
        Scanner sc = new Scanner(System.in);
        int[] write = new int [2];
        write = new int[]{sc.nextInt()};

    }
}
