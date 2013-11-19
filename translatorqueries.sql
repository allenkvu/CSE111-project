--
-- Queries Through Links
--


# English word to Kana sequence
getKanaFromEnglishWord = "SELECT kns_hiragana, kns_katakana, kns_romaji\
FROM kanaSystem\
INNER JOIN japaneseWordKanaLink\
INNER JOIN japaneseEnglishWordLink\
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID\
AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID\
WHERE japaneseEnglishWordLink.jewl_englishWordID = ?\
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;"

# English sequence to Kana sequence
# this could be wrong my head is not clear enough.

getKanaFromEnglishPhrase = " SELECT kns_hiragana, kns_katakana, kns_romaji (\
FROM kanaSystem\
INNER JOIN japaneseWordKanaLink\
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID\
INNER JOIN japaneseEnglishWordLink\
ON japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID\
INNER JOIN englishPhrase\
ON japaneseEnglishWordLink.jewl_englishWordID = englishPhrase.ep_ID\
WHERE japaneseEnglishWordLink.jewl_englishWordID = ?\
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;"

# Japanese word to English sequence
getEnglishFromJapaneseWord = " SELECT ew_word\
FROM englishWord\
INNER JOIN japaneseEnglishWordLink\
ON englishWord.ew_wordid = japaneseEnglishWordLink.jewl_englishWordID\
WHERE japaneseEnglishWordLink.jewl_japaneseWordID = ?;"

