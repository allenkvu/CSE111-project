--
-- Queries Through Links
--


--# English word to Kana sequence
--getKanaFromEnglishWord = "SELECT kns_hiragana, kns_katakana, kns_romaji\
--FROM kanaSystem\
--INNER JOIN japaneseWordKanaLink\
--INNER JOIN japaneseEnglishWordLink\
--ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID\
--AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID\
--WHERE japaneseEnglishWordLink.jewl_englishWordID = ?\
--ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;"

SELECT kns_hiragana, kns_katakana, kns_romaji
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
INNER JOIN japaneseEnglishWordLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
WHERE japaneseEnglishWordLink.jewl_englishWordID = 1
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;

--# English sequence to Kana sequence
--# this could be wrong my head is not clear enough.
--getKanaFromEnglishPhrase = " SELECT kns_hiragana, kns_katakana, kns_romaji\
--FROM kanaSystem\
--INNER JOIN japaneseWordKanaLink\
--ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID\
--INNER JOIN japaneseEnglishWordLink\
--ON japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID\
--INNER JOIN englishPhrase\
--ON japaneseEnglishWordLink.jewl_englishWordID = englishPhrase.ep_ID\
--WHERE japaneseEnglishWordLink.jewl_englishWordID = ?\
--ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;"

SELECT kns_hiragana, kns_katakana, kns_romaji
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
INNER JOIN japaneseEnglishWordLink
ON japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
INNER JOIN englishPhrase\
ON japaneseEnglishWordLink.jewl_englishWordID = englishPhrase.ep_ID
WHERE japaneseEnglishWordLink.jewl_englishWordID = 1
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;

--# Japanese word to English sequence
--getEnglishFromJapaneseWord = " SELECT ew_word\
--FROM englishWord\
--INNER JOIN japaneseEnglishWordLink\
--ON englishWord.ew_wordid = japaneseEnglishWordLink.jewl_englishWordID\
--WHERE japaneseEnglishWordLink.jewl_japaneseWordID = ?;"

SELECT ew_word
FROM englishWord
INNER JOIN japaneseEnglishWordLink
ON englishWord.ew_wordid = japaneseEnglishWordLink.jewl_englishWordID
WHERE japaneseEnglishWordLink.jewl_japaneseWordID = 2;

--Japanese word to kanji sequence
--getKanjiFromJapaneseWord = " Select ks_char\
--from kanjiSystem, japaneseWord, japaneseWordKanjiLink\
--where jw_WordID = ? and jw_WordID = jwki_japaneseWordID and jwki_kanjiID = ks_kanjiID; "

select ks_char
from kanjiSystem, japaneseWord, japaneseWordKanjiLink
where jw_WordID = 1 and jw_WordID = jwki_japaneseWordID and jwki_kanjiID = ks_kanjiID; 

--kanji to english word
select ks_char, ew_word
From englishWord, kanjiSystem, kanjiEnglishLink
where ks_kanjiID = 1 and ks_kanjiID = kel_kanjiID and kel_englishWordID = ew_wordid