import sqlite3 as sql

import statements as stat
import prompts

def rawInputWithDefault(prompt, default):
    userInput = raw_input(prompt)
    if not userInput:
        return default
    else:
        return userInput

def insertEnglishWordsPhrases:
    switch(int(rawInputWithDefault(prompts.insertWordFrom % ('English','English','english'),'0'))) {
        case 1:
        inputString = raw_input("insert distinct words, phrases separated by comma;
     phrases joined by space or hyphen")
        case 2:
        
        
def insertKangiCharacters:
    

    




def main():
    dbName = rawInputWithDefault("Enter DB name, or blank for
    'translator.db'", 'translator.db')
    conn = sqlite3.connect(dbName)
    cur = conn.cursor()

    switch(int(rawInputWithDefault(prompts.mainMenu, "0"))) {
        case 1: # Database Setup
        switch(int(rawInputWithDefault(prompts.setupChoices, "0"))) {
            case 1: # insert english words/phrases
            insertEnglishWordsPhrases()
            case 2: # insert Kangi characters
            insertKangiCharacters()
                        
    conn.close()

if __name__ == '__main__':
    
conn = sqlite3.connect('foobar.db')


