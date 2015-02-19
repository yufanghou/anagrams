/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yufang.anagrams.main;

import yufang.anagrams.Dictionary;

/**
 *
 * @author houyg
 */
public class CreateDic {
    
   public static void main(String[] args){
       Dictionary.getInstance().createNewDicFromTxtFile();
   }
    
}
