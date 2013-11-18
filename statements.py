
# SQL statement templates;
# queries and updates/insertions

foo = 'bar'

#############################
# Single Word Insertions
# (excluding Japanese word weak entity set)
#############################

# English word insertion

insertEnglishWord = "insert into englishWord (
  ew_wordID
 ,ew_word
) values (
  NULL, ?
);"

# Hiragana, Katakana, Romaji insertion (together)
insertKanaWord = "insert into kanaSystem (
  kns_kanaID
 ,kns_hiragana
 ,kns_katakana
 ,kns_romaji
) values (
 NULL, ?, ?, ?
);"

# Kangi character insertion
insertKangiWord = "insert into kangiSystem (
  ks_kangiID
 ,ks_char
) values (
  NULL, ?
);"

##########################
# Link Insertions
##########################


# Link together a sequence of Kana characters and a new Japanese word

# If Japanese word does not already exist

insertJapaneseWordKanaLink = "insert into japaneseWordKangiLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
) values (
 ?, ?, ?
);"


# Link together a sequence of English words and a sequence
# of Japanese words.
# If Japanese-English word link does not already exist
# AND Japanese word(s) exists
# AND English word(s) exists
insertJapaneseEnglishLinkIndex = "insert into japaneseEnglishWordLinkIndex (
  jewli_linkID
) values (
  NULL
);"
getJapaneseEnglishLinkIndex = "select max(jewli_linkID)
  from japaneseEnglishWordLinkIndex;"

insertJapaneseWordEnglishLink = "insert into japaneseEnglishWordLink (
  jewl_linkID
 ,jewl_japaneseWordID
 ,jewl_englishWordID
 ,jewl_japaneseWordOrder
 ,jewl_englishWordOrder
) values (
  NULL, ?, ?, ?, ?
);"


######################
# Queries Through Links
######################

# English word to Kana sequence
getKanaFromEnglishWord = "SELECT kns_hiragana, kns_katakana, kns_romaji (
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
INNER JOIN japaneseEnglishWordLink
ON japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
WHERE japaneseEnglishWordLink.jewl_englishWordID = ?
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;"

# English sequence to Kana sequence
# Peter will do this
getKanaFromEnglishPhrase = " SELECT 

"

# Japanese word to English sequence
getEnglishFromJapaneseWord = " SELECT ew_word
FROM englishWord
INNER JOIN japaneseEnglishWordLink
ON englishWord.ew_wordid = japaneseEnglishWordLink.jewl_englishWordID
WHERE japaneseEnglishWordLink.jewl_japaneseWordID = ?;"

