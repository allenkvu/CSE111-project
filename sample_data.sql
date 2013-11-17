--this is just a simple sample to see how data fits in table

--japanese word sample "yama"
insert into japaneseWord values (1);
--no need for japaneseWordPredecessor
--no need for japanesePredecessor
--no need for japaneseWordOpposite
--no need for japaneseWordDescription
insert into japaneseWordKanaLink values (1, 36, 0);
insert into japaneseWordKanaLink values (1, 31, 1);
insert into kanjiSystem values (1, 'ŽR');
insert into japaneseWordKanjiLink values(1,1,0);

--no need for WasesiEigo

--english of "yama"
insert into englishWord values(1, 'mountain');
--no need for englishWordOpposite
--no need for englishPhraseIndex
--no need for englishPhrase

--japanese english link
insert into japaneseEnglishWordLinkIndex values(1);
insert into japaneseEnglishWordLink values(1, 1, 1, 0, 0);
insert into kanjiEnglishLink values(1,1,0);
