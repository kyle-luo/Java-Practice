//You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
//
//The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
//Example 1:
//
//Input: J = "aA", S = "aAAbbbb"
//Output: 3
//Example 2:
//
//Input: J = "z", S = "ZZ"
//Output: 0

public class JewelsAndStones {
    public static void main(String[] args)
    {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    public static int numJewelsInStones(String J, String S)
    {
        int count = 0;
        for(char Stone : S.toCharArray())
        {
            if(J.contains(Character.toString(Stone)))
            {
                count ++;
            }
        }
        return count;
    }
}
