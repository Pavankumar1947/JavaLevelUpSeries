package com.eclothing.clothing.programming;

/*
s1 + s1 = "abcdabcd"
"cdab" is present inside "abcdabcd"
*/
public class StringRotation {
    public static void main(String[] args) {
        System.out.println(areRotation("abcd","cdab"));
        System.out.println(areRotation("abcd","acdb"));
    }

    private static boolean areRotation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        String s3 = s1 + s1;
        return s3.contains(s2);
    }
}
