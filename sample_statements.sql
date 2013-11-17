--this is using data from sample_data
--The first japanaese word in hiragana
select kns_hiragana
from kanaSystem, japaneseWord, japaneseWordKanaLink
where jw_WordID = 1 and jw_WordID = jwkn_japaneseWordID and jwkn_kanaID = kns_kanaID;

--the kanji for the first japanese word
select ks_char
from kanjiSystem, japaneseWord, japaneseWordKanjiLink
where jw_WordID = 1 and jw_WordID = jwki_japaneseWordID and jwki_kanjiID = ks_kanjiID; 

--Engish word for the first japanese word
select ew_word
from englishWord, japaneseWord, japaneseEnglishWordLink
where jw_wordID = jewl_japaneseWordID and jewl_englishWordID = ew_wordid;

--displaying both
select kns_hiragana, ew_word
from kanaSystem, japaneseWord, japaneseWordKanaLink, englishWord, japaneseEnglishWordLink
where jw_WordID = 1 and jw_WordID = jwkn_japaneseWordID and jwkn_kanaID = kns_kanaID and jewl_englishWordID = ew_wordid;