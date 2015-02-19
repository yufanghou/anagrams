1. This is a small java program to:
1) query anagrams from a dictionary (one unique word per line) for an input word;

2) create a dictionary using Stanford Tokenizer from .txt files under a directory



2. Directory structure:
1) dist: contains the jar file (yufang_anagrams.jar) and the necessary libarary files 

2) src: contains source files 

3) config: contains the configuration file (config.properties) for setting the dictionary path, please set the correct value according to your local system configuration.

4) script: the command line scripts to query anagrams (findAnagrams.sh) and to create a dictionary (createDic.sh). Please change "JAR" and "CONFIG" to the path of the jar file
and of the config in your local system.  

5) libs: contains the jar file of Stanford old postagger

6) dic: contains a dictionary file

3. How to use
1) downloand all files, put it somewhere in your local system, suppose the root directory
of this package (i.e., yufang_paragrams) is $root

2) change config.properties:
current_dic_file = $root/yufang_anagrams/dic/dic.txt
dic_input_dir = $root/yufang_anagrams/dic/input
dic_output_file = $root/yufang_anagrams/dic/output.txt

3) change the values of JAR and CONFIG in findAnagrams.sh and createDic.sh:
JAR = $root/yufang_anagrams/dist/yufang.anagrams.jar
CONFIG = $root/yufang_anagrams/config/

4) run findAnagrams.sh and createDic.sh


