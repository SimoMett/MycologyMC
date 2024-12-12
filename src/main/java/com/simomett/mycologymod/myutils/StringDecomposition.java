package com.simomett.mycologymod.myutils;

public class StringDecomposition
{
    public static String compose(String str1, String str2, char decompChar)
    {
        return str1+decompChar+str2;
    }

    public static String[] decompose(String string, char character)
    {
        String[] stringArray = new String[2];
        stringArray[0]=new String(string.substring(0,string.indexOf(character)));
        stringArray[1]=new String(string.substring(string.indexOf(character)+1));
        return stringArray;
    }
}
