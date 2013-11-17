--some more data

--random english word
insert into englishWord values(1, 'mountain');
insert into englishWord values(2, 'tall');
insert into englishWord values(3, 'expensive');
insert into englishWord values(4, 'short');
insert into englishWord values(5, 'cheap');
insert into englishWord values(6, 'rest');


--english opposite
insert into englishWordOpposite values(2, 4);
insert into englishWordOpposite values(3, 5);


--I will order japanese word randomly
--rest will be kyuukei
insert into japaneseWord values (1);
insert into japaneseWordKanaLink values (1, 70, 0);
insert into japaneseWordKanaLink values (1, 3, 1);
insert into japaneseWordKanaLink values (1, 9, 2);
insert into japaneseWordKanaLink values (1, 2, 3);

--rest will also be kyuusoku
insert into japaneseWord values (3);
insert into japaneseWordKanaLink values (3, 70, 0);
insert into japaneseWordKanaLink values (3, 3, 1);
insert into japaneseWordKanaLink values (3, 15, 2);
insert into japaneseWordKanaLink values (3, 8, 3);

--tall will be takai
insert into japaneseWord values (2);
insert into japaneseWordKanaLink values (2, 16, 0);
insert into japaneseWordKanaLink values (2, 6, 1);
insert into japaneseWordKanaLink values (2, 2, 2);

--expensive is also spelled out takai
insert into japaneseWord values (5);
insert into japaneseWordKanaLink values (5, 16, 0);
insert into japaneseWordKanaLink values (5, 6, 1);
insert into japaneseWordKanaLink values (5, 2, 2);

--mountain will be yama
insert into japaneseWord values (4);
insert into japaneseWordKanaLink values (4, 36, 0);
insert into japaneseWordKanaLink values (4, 31, 1);

--cheap is yasui
insert into japaneseWord values (6);
insert into japaneseWordKanaLink values (6, 36, 0);
insert into japaneseWordKanaLink values (6, 13, 1);
insert into japaneseWordKanaLink values (6, 2, 2);

--short is mijikai
insert into japaneseWord values (7);
insert into japaneseWordKanaLink values (7, 32, 0);
insert into japaneseWordKanaLink values (7, 53, 1);
insert into japaneseWordKanaLink values (7, 6, 2);
insert into japaneseWordKanaLink values (7, 2, 3);

--short is also hikui
insert into japaneseWord values (8);
insert into japaneseWordKanaLink values (8, 27, 0);
insert into japaneseWordKanaLink values (8, 8, 1);
insert into japaneseWordKanaLink values (8, 2, 2);


--opposite japanese
insert into japaneseWordOpposite values(6, 5);
insert into japaneseWordOpposite values(2, 7);
insert into japaneseWordOpposite values(2, 8);


--kanjis
--yama
insert into kanjiSystem values (1, 'éR');
insert into japaneseWordKanjiLink values(4,1,0);

--making kyuukei and kyuusoku
insert into kanjiSystem values(2, 'ãx');
insert into kanjiSystem values(3, 'åe');
insert into kanjiSystem values(4, 'ëß');

--kyuukei
insert into japaneseWordkanjiLink values(1, 2, 0);
insert into japaneseWordkanjiLink values(1, 3, 1);

--kyuusoku
insert into japaneseWordkanjiLink values(3, 2, 0);
insert into japaneseWordkanjiLink values(3, 4, 1);

--takai 
insert into kanjiSystem values(5, 'çÇ');
insert into japaneseWordkanjiLink values(2, 5, 0);

--yasui
insert into kanjiSystem values(6, 'à¿');
insert into japaneseWordkanjiLink values(6, 6, 0);

--mijikai
insert into kanjiSystem values(7, 'íZ');
insert into japaneseWordkanjiLink values(7, 7, 0);

--hikui
insert into kanjiSystem values(8, 'í·');
insert into japaneseWordkanjiLink values(8, 8, 0);


--japanese english link
--linking mountain/yama
insert into japaneseEnglishWordLinkIndex values(1);
insert into japaneseEnglishWordLink values(1, 4, 1, 0, 0);
insert into kanjiEnglishLink values(1,1,0);

--linking tall (takai)
insert into japaneseEnglishWordLinkIndex values(2);
insert into japaneseEnglishWordLink values(2, 2, 2, 0, 0);
insert into kanjiEnglishLink values(5,2,0);


--linking expensive which is also takai, at first i thought i could put this on the same japaneseEnglsihWordLinkIndex but
--that might cause some funky  error when the user want a japanese word to japaneseOpposite then to english
--for ex if I type Yasui the opposite will be takai then the english of that takai should only be expensive not tall
insert into japaneseEnglishWordLinkIndex values(6);
insert into japaneseEnglishWordLink values(6, 5, 3, 0, 0);
insert into kanjiEnglishLink values(5,3,0);

--linking short(mijikai & hikui)
insert into japaneseEnglishWordLinkIndex values(3);
insert into japaneseEnglishWordLink values(3, 7, 4, 0, 0);
insert into japaneseEnglishWordLink values(3, 8, 4, 1, 0);
insert into kanjiEnglishLink values(7,4,0);
insert into kanjiEnglishLink values(8,4,0);

--linking cheap (yasui)
insert into japaneseEnglishWordLinkIndex values(4);
insert into japaneseEnglishWordLink values(4, 6, 5, 0, 0);
insert into kanjiEnglishLink values(6,5,0);

--linking rest (kyuusoku & kyuukei)
insert into japaneseEnglishWordLinkIndex values(5);
insert into japaneseEnglishWordLink values(5, 1, 6, 0, 0);
insert into japaneseEnglishWordLink values(5, 1, 6, 1, 0);
--how do i tell the database that theres two japanese word each having different kanji character for rest? ex ãxåe&ãxëß are both rest
insert into kanjiEnglishLink values(2,5,0);
insert into kanjiEnglishLink values(3,5,0);
