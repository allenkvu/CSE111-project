# prompts

mainMenu = "\
  1) Database Setup\n\
  2) Translation\n\
  0) Exit\n\
  Enter choice:\n\
"

setupChoices = "\
  1) Insert English word and phrases\n\
  2) Insert Kangi characters\n\
  3) Insert Japanese words\n\
  4) Insert Wasei-Eigo expression (also a Japanese word)\n\
  ------Translation links--------\n\
  5) Insert English word sequence -- Japanese word sequence link\n\
  6) Tag Japanese word with a descriptive English phrase\n\
  0) Go back\n\
  Enter choice (default 0):\n\
"


insertWordFrom = "\
  1) Insert %s words and phrases by prompt;\n\
     distinct words, phrases separated by comma;\n\
     phrases joined by space or hyphen\n\
  2) Import %s words from %sWords.csv\n\
  0) Go back\n\
  Enter choice (default 0):\n\
"

