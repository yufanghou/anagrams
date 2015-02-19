/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yufang.anagrams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * read attri-value from the configuration file (config.properties) 
 *
 * @author yufang
 */
public class ConfigProperties {

    private static ConfigProperties singleton;
    private final Properties prop;
    private static final String PROP_FILE = "config.properties";
    public static final String DIC_FILE = "current_dic_file";
    public static final String DIC_INPUT_FILE = "dic_input_dir";
    public static final String DIC_OUTPUT_FILE = "dic_output_file";

    public static ConfigProperties getInstance() {
        if (singleton == null) {
            singleton = new ConfigProperties();
        }
        return singleton;
    }

    private ConfigProperties() {
        prop = new Properties();
        //FileInputStream in = null;
        InputStream in = null;
        try {
            //in = new FileInputStream(new File(PROP_FILE));
            in = getClass().getClassLoader().getResourceAsStream(PROP_FILE);
            prop.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("cannot find the configuration file!");
                System.exit(1);
            }
        }
    }
    
    public String getProperty(String property) {
        return prop.getProperty(property);
    }

    
    public String getCurrentDicFile() {
        return prop.getProperty(DIC_FILE);
    }

    public String getDicInputFile() {
        return prop.getProperty(DIC_INPUT_FILE);
    }

    public String getDicOutputFile() {
        return prop.getProperty(DIC_OUTPUT_FILE);
    }
}
