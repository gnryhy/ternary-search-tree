# ternary-search-tree
ternary search tree assignment for algorithms course of hacettepe university

## Requirements and Restrictions
* jdk 1.8+
* jre 1.8+
* only .txt files can be searched

## Installation
* Open terminal on the directory of source files.
* Build all files (javac *)

## Usage
* Run the executable with specifying the path of the text files to be searched (java Main /path/to/the/files)
* If the previous step is done in a correct way a message like below will appear.

```
File1.txt is indexed
File2.txt is indexed
GoodFile.txt is indexed
```

* There are two different search types you can use.

If you search with lowercase w argument, you can only search for single words.

```
search -w foo
```

If you search with uppercase W argument, you can search both a word group or a single word.

```
search -W foo bar
```

If there's a hit, program will print the related file and position of the word in the file.

* You can simply exit the program by hitting CTRL+C (SIGINT) or typing an invalid command.

