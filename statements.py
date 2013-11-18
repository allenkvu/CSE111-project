
# SQL statement templates;
# queries and updates/insertions

foo = 'bar'



# insertEnglishWord
# insertKanaWord
# insertKangiWord
# insertJapaneseWordKanaLink
# insertJapaneseWordKangiLink

# insertJapaneseEnglishLinkIndex
# getJapaneseEnglishLinkIndex
# insertJapaneseWordEnglishLink

# insertEnglishPhraseIndex
# getEnglishPhraseIndex
# insertEnglishPhrase

# getKanaFromEnglishWord
# getKanaFromEnglishPhrase
# getEnglishFromJapaneseWord
# getEnglishFromJapaneseSequence

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

# Link together a Japanese word and a sequence of Kangi characters

# If word link between Japanese word and Kangi sequence does not
# already exist
insertJapaneseWordKangiLink = "insert into japaneseWordKanaLink (
  jwki_japaneseWordID
 ,jwki_kangiID
 ,jwki_order
) values (
  ?, ?, ?
)"


# Link together a sequence of English words and a sequence
# of Japanese words.
# If Japanese-English word link does not already exist
# AND Japanese word(s) exists
# AND English word(s) exists

# complexity will be in the Python that generates jWordOrder, eWordOrder
insertJapaneseEnglishLinkIndex = "insert into japaneseEnglishWordLinkIndex (
  jewli_linkID
) values (
  NULL
);"
getJapaneseEnglishLinkIndex = "select max(jewli_linkID)
  from japaneseEnglishWordLinkIndex;"

insertJapaneseWordEnglishLink = "insert into japaneseEnglishWordLink (
  jewl_linkID --determined by previous SQL query
 ,jewl_japaneseWordID
 ,jewl_englishWordID
 ,jewl_japaneseWordOrder
 ,jewl_englishWordOrder
) values (
  NULL, ?, ?, ?, ?
);"

# Create an English phrase from sequence of English words
# if phrase does not already exist

insertEnglishPhraseIndex = "insert englishPhraseIndex (
  epi_ID
) values (
  NULL
);"
getEnglishPhraseIndex = "select max(epi_ID)
  from englishPhraseIndex;"

insertEnglishPhrase = "insert into englishPhrase (
  ep_id
 ,ep_englishWordID
 ,ep_order
) values (
  ?, ?, ?
);"


######################
# Queries Through Links
######################


# English word to Kana sequence
getKanaFromEnglishWord = "SELECT kns_hiragana, kns_katakana, kns_romaji
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
INNER JOIN japaneseEnglishWordLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
WHERE japaneseEnglishWordLink.jewl_englishWordID = ?
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;"

# English sequence to Kana sequence
# this could be wrong my head is not clear enough.

getKanaFromEnglishPhrase = " SELECT kns_hiragana, kns_katakana, kns_romaji (
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
INNER JOIN japaneseEnglishWordLink
ON japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
INNER JOIN englishPhrase
ON japaneseEnglishWordLink.jewl_englishWordID = englishPhrase.ep_ID
WHERE japaneseEnglishWordLink.jewl_englishWordID = ?
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;"

# Japanese word to English sequence
getEnglishFromJapaneseWord = " SELECT ew_word
FROM englishWord
INNER JOIN japaneseEnglishWordLink
ON englishWord.ew_wordid = japaneseEnglishWordLink.jewl_englishWordID
WHERE japaneseEnglishWordLink.jewl_japaneseWordID = ?;"

