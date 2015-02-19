/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yufang.anagrams;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author houyg
 */
public class DicFilenameFilter implements FilenameFilter {

    public static final DicFilenameFilter DIC_FILEFILTER_INSTANCE = new DicFilenameFilter();

    public boolean accept(File directory, String name) {
        return name.endsWith(".txt");
    }
}
