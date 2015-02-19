/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yufang.anagrams.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import yufang.anagrams.Dictionary;

/**
 *
 * @author yufang
 */
public class FindAnagrams {

    public static void main(String[] args) {
        System.out.println("****find anagrams for a word***");
        System.out.println("Please input a word (input q to exit the program):");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            while (!(input = br.readLine()).equalsIgnoreCase("q")) {
                ArrayList<String> result = Dictionary.getInstance().findAnagrams(input);
                if (result == null || result.size() == 1) {
                    System.out.println("opps! There's no anagrams for " + input + " in the dictionary!");
                } else {
                    System.out.println("the aragrams for " + input + " are:");
                    for (String s : result) {
                        if (!(s.equals(input))) {
                            System.out.println(s);
                        }
                    }
                }
                System.out.println("Please input a word (input q to exit the program):");
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

}
