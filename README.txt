1. This is a small java program to:
1) query anagrams from a dictionary (one unique word per line) for an input word;

2) create a dictionary using Stanford Tokenizer from .txt files under a directory



2. Directory structure:
1) yufang_anagrams.jar: an old JDK version (JDK6) is used to compile the jar file due to the using of the old version of stanford POStagger 

2) src: contains source files 

3) config: contains the configuration file (config.properties) for setting the dictionary path, please set the correct value according to your local system configuration.

4) script: the command line scripts to query anagrams (findAnagrams.sh) and to create a dictionary (createDic.sh). Please change "JAR" and "CONFIG" to the path of the jar file
and of the config in your local system.  

5) lib: contains the jar file of Stanford old postagger

6) dic: contains a dictionary file (around 99,000 words)

3. How to use
1) downloand all files, put it somewhere in your local system, suppose the parent directory
of this package (i.e., paragrams) is $root

2) change config.properties:
current_dic_file = $root/anagrams/dic/dic.txt
dic_input_dir = $root/anagrams/dic/input
dic_output_file = $root/anagrams/dic/output.txt

3) change the values of JAR and CONFIG in findAnagrams.sh and createDic.sh:
JAR = $root/anagrams/yufang_anagrams.jar
CONFIG = $root/anagrams/config/

4) run findAnagrams.sh and createDic.sh




