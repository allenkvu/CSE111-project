--
-- Queries Through Links
--

--# user inputs English word in "ew_word =" , outputs japanese word in Kana sequence　(english word to many japanese word)
SELECT kns_hiragana, kns_katakana, kns_romaji
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
INNER JOIN japaneseEnglishWordLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
WHERE japaneseEnglishWordLink.jewl_englishWordID = (
      select ew_wordID from englishWord where ew_word = 'tall'
)
ORDER BY japaneseWordKanaLink.jwkn_kanaOrder;

--inputs English sequence in "ew_word ="outputs the corresponding japanese word in Kana sequence (doesnt work properly)
SELECT kns_hiragana, kns_katakana, kns_romaji
FROM kanaSystem
INNER JOIN japaneseWordKanaLink
INNER JOIN japaneseEnglishWordLink
ON kanaSystem.kns_kanaID = japaneseWordKanaLink.jwkn_kanaID
AND japaneseWordKanaLink.jwkn_japaneseWordID = japaneseEnglishWordLink.jewl_japaneseWordID
WHERE japaneseEnglishWordLink.jewl_englishWordID = (
      select ew_wordID from englishWord where ew_word in ( 'tall', 'mountain', 'cheap' )
)
ORDER BY japaneseEnglishWordLink.jewl_japaneseWordOrder, japaneseWordKanaLink.jwkn_kanaOrder;

--input will be Japanese word in hiragana or katakana or romaji or kanji outputs English sequence (doesnt work properly becuse of kns_hiragana in ('や', 'ま') part)
SELECT ew_word
FROM englishWord
INNER JOIN japaneseEnglishWordLink
ON englishWord.ew_wordid = japaneseEnglishWordLink.jewl_englishWordID
WHERE japaneseEnglishWordLink.jewl_japaneseWordID in (
      select jwkn_japaneseWordID
      from japaneseWordKanaLink
      inner join kanaSystem
      on jwkn_kanaID = kns_kanaID
      and kns_hiragana in ('や', 'ま')
)
order by japaneseEnglishWordLink.jewl_englishWordOrder;

--inputs a japanese word in hiragana etc and outputs the corresponding kanji (same as above doesnt work properly)
select ks_char
from kanjiSystem, japaneseWord, japaneseWordKanjiLink
where jw_WordID in( 
      select jwkn_japaneseWordID
      from japaneseWordKanaLink
      inner join kanaSystem
      on jwkn_kanaID = kns_kanaID
      and kns_hiragana in ('や', 'ま')
)
and jw_WordID = jwki_japaneseWordID and jwki_kanjiID = ks_kanjiID; 

--kanji to english word (user inputs a kanji in "ks_char =" and the output will be english word)
select ew_word
From englishWord, kanjiSystem, kanjiEnglishLink
where ks_char = '山' and ks_kanjiID = kel_kanjiID and kel_englishWordID = ew_wordid

--input will be a japanese word and output would be an english description for that japanese word (doesnt work properly)
select ew_word
from englishWord, englishPhrase, japaneseWordDescription
where jwd_japaneseWordID =  select jwkn_japaneseWordID
      from japaneseWordKanaLink
      inner join kanaSystem
      on jwkn_kanaID = kns_kanaID
      and kns_hiragana in ('や', 'ま')
)
 and jwd_englishPhraseID = ep_ID and ep_englishwordID = ew_wordid

