#!/bin/sh

JAR=/home/yufang/yufang_anagrams/yufang_anagrams.jar
CONFIG=/home/yufang/yufang_anagrams/config/


java -cp $JAR:$CONFIG yufang.anagrams.main.CreateDic
