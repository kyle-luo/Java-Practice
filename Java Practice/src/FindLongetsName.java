//You should implement the function String findLongestName(String [] names) which takes an array of Strings as an input containing a list of names, and return the String that has the longest name.
//
//        To do so, try to follow these steps:
//
//        The first step is to calculate and store the length of the input array, this is done using names.length; and store that in an integer variable.
//
//        Then create a new String called longestName that will store the longest name in the array of names, initialize it with the first name in the array, that is names[0].
//
//        Next, you should create a for loop that will compare every name in the array using names[i] against the longestName. Only replace the longestName value if the names[i] is longer .
//
//        Finally, return the longestName variable as the return value of the function.


public class FindLongetsName
{
    public static void main(String[] args)
    {
        String[] testNames = {"haha","hahaha"};
        System.out.println(findLongestName(testNames));
    }

    public static String findLongestName(String [] names)
    {
        String longest = names[0];
        for(int i = 1; i < names.length; i ++)
        {
            if(longest.length() < names[i].length()){
                longest = names[i];
            }
        }
        return longest;
    }

}
