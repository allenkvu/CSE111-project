import sqlite3 as sql
import sys

import statements as stat
import prompts

def rawInputWithDefault(prompt, default):
    userInput = raw_input(prompt)
    if not userInput:
        return default
    else:
        return userInput
#############################
# Setup
#############################
def insertEnglishWordsPhrases(cursor):
    choice = int(rawInputWithDefault(prompts.insertWordFrom % (
        'English','English','english'),'0'))
    if choice == 1: # manual English word/phrase input
        inputString = raw_input("input distinct words, phrases separated by comma;"+
                                "phrases joined by space or hyphen")
        #phrases = [('NULL', x.lstrip().decode('UTF-8')) for x in inputString.split(',')]
        #phrases = [('NULL', x.lstrip()) for x in inputString.split(',')]
        phrases = [(x.lstrip()) for x in inputString.split(',')]

    elif choice == 2: # read English csv file
        rf = open('englishWords.csv','r')
        lines = rf.readlines()
        #phrases = [('NULL', x.rstrip().decode('UTF-8')) for x in lines]
        #phrases = [('NULL', x.rstrip()) for x in lines]

    else:
        return
    print stat.insertEnglishWord
    #cursor.executemany(stat.insertEnglishWord, phrases)
    cursor.executemany(stat.insertEnglishWor
    return
        
def insertKangiCharacters(cursor):
    return

    

############################
# Translation
############################


def main(conn):
    cur = conn.cursor()

    choice = int(rawInputWithDefault(prompts.mainMenu, "0"))
    while True:
        if choice == 1:
            choice = int(rawInputWithDefault(prompts.setupChoices, "0"))
            if choice == 1: # insert english words/phrases
                insertEnglishWordsPhrases(cur)
            elif choice == 2: # insert Kangi characters
                insertKangiCharacters(cur)
            else:
                return

        else:
            return
        choice = int(rawInputWithDefault(prompts.mainMenu, "0"))

if __name__ == '__main__':
    dbName = rawInputWithDefault("Enter DB name, or blank for "+
                                 "'translator.db'", 'translator.db')
    conn = sql.connect(dbName)
#    sys.setdefaultencoding('utf-8')
    main(conn)
    conn.close()


