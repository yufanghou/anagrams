/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yufang.anagrams;

import edu.stanford.nlp.process.PTBTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides: 
 * 1) creating dic file from .txt files 
 * 2) query anagrams for an input word
 *
 * @author yufang
 */
public class Dictionary {

    private static Dictionary singleton;
    private static HashMap<String, ArrayList<String>> anagramsIndex;

    public static Dictionary getInstance() {
        if (singleton == null) {
            singleton = new Dictionary();
        }
        return singleton;
    }

    private Dictionary() {
        anagramsIndex = new HashMap<String, ArrayList<String>>();
    }
    

    /**
     * load dictionary into a HashMap<String, ArrayList<String>> structure from a txt file (one unique word per line)
     * all anagrams are stored in an ArrayList, the key of the ArrayList is the sorted string of any string in this list
     * e.g., abst----{bats, stab}
     * the path of the dictionary file is configured in config.properties
     */
    private void loadDictionary() {
        BufferedReader br = null;
        String line = null;
        try {
            FileInputStream fis = new FileInputStream(ConfigProperties.getInstance().getCurrentDicFile());
            br = new BufferedReader(new InputStreamReader(fis));
            while ((line = br.readLine()) != null) {
                char[] wordChars = line.toCharArray();
                Arrays.sort(wordChars);
                String indexStr = String.valueOf(wordChars);
                ArrayList<String> anagrams;
                if ((anagrams = anagramsIndex.get(indexStr)) != null) {
                    anagrams.add(line);
                } else {
                    anagrams = new ArrayList<String>();
                    anagrams.add(line);
                    anagramsIndex.put(indexStr, anagrams);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("cannot find the dictionary file! Please check the dicionary path in the config.properties file!");
                System.exit(1);
            }
        }
    }
    
    
    
    /**
     * query the anagrams for an input word
     * return null if no anagrams are found;
     * otherwise return a list of anagrams including the input word
     */
    public ArrayList<String> findAnagrams(String word) {
        if (anagramsIndex.isEmpty()) {
            loadDictionary();
        }
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        return (anagramsIndex.get(String.valueOf(wordChars)));
    }
    

    /**
     * use Stanford Tokenizer to create a dictionary file (one unique word per line) from .txt files under a directory
     * the input file directory and the output file path/name are configured in config.properties
     */
    public void createNewDicFromTxtFile() {
        Set<String> words = new HashSet<String>();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ConfigProperties.getInstance().getDicOutputFile()));
            File rootDir = new File(ConfigProperties.getInstance().getDicInputFile());
            if (rootDir.exists()) {
                for (File file : rootDir.listFiles(DicFilenameFilter.DIC_FILEFILTER_INSTANCE)) {
                    PTBTokenizer ptbt = new PTBTokenizer(new FileReader(file));
                    while (ptbt.hasNext()) {
                        words.add(ptbt.next().toString());
                    }
                    for (String s : words) {
                        bw.write(s);
                        bw.newLine();
                    }
                    bw.flush();
                }
                System.out.println("dictionary creation finished!");
            } else {
                System.err.println("input directory doesn't exist, please check the config file!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
