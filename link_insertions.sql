

---- Link Insertions

-- Link together a sequence of Kana characters and a new Japanese word

-- If Japanese word does not already exist

-- insert into japaneseWordKanjiLink (
--  jwkn_japaneseWordID
-- ,jwkn_kanaID
-- ,jwkn_kanaOrder
--) values (
-- ?, ?, ?
--);


--I will order japanese word randomly
--rest will be kyuukei
insert into japaneseWord values (1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (1, 70, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (1, 3, 1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (1, 9, 2);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (1, 2, 3);

--rest will also be kyuusoku
insert into japaneseWord values (3);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (3, 70, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (3, 3, 1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (3, 15, 2);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (3, 8, 3);

--tall will be takai
insert into japaneseWord values (2);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (2, 16, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (2, 6, 1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (2, 2, 2);

--expensive is also spelled out takai
insert into japaneseWord values (5);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (5, 16, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (5, 6, 1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (5, 2, 2);

--mountain will be yama
insert into japaneseWord values (4);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (4, 36, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (4, 31, 1);

--cheap is yasui
insert into japaneseWord values (6);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (6, 36, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (6, 13, 1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (6, 2, 2);

--short is mijikai
insert into japaneseWord values (7);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (7, 32, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (7, 53, 1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (7, 6, 2);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (7, 2, 3);

--short is also hikui
insert into japaneseWord values (8);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (8, 27, 0);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (8, 8, 1);
insert into japaneseWordKanaLink (
  jwkn_japaneseWordID
 ,jwkn_kanaID
 ,jwkn_kanaOrder
)  values (8, 2, 2);



-------------------------------------------------------------------
-- Link together a Japanese word and a sequence of Kanji characters
-------------------------------------------------------------------
-- If word link between Japanese word and Kanji sequence does not
-- already exist
-- insert into japaneseWordKanjiLink (
--  jwki_japaneseWordID
-- ,jwki_kanjiID
-- ,jwki_order
--) values (
--  ?, ?, ?
--);

--yama

insert into japaneseWordKanjiLink (
  jwki_japaneseWordID
 ,jwki_kanjiID
 ,jwki_order
) values (
  (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID 
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'や')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'ま')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  )
  ,(select ks_kanjiID from kanjiSystem where ks_char = '山')
  ,0
);

--making kyuukei and kyuusoku
--kyuukei
insert into japaneseWordkanjiLink values(
  (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID 
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'きゅ')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'う')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  )
,(select ks_kanjiID from kanjiSystem where ks_char = '休')
, 0
);


insert into japaneseWordkanjiLink values(
 (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID 
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'け')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'い')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  )
,(select ks_kanjiID from kanjiSystem where ks_char = '憩')
, 1
);

--takai 

insert into japaneseWordkanjiLink values(
  (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  inner join japaneseWordKanaLink c
  inner join japaneseWordKanaLink d
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID 
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'た')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'か')
  and c.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'い')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  and c.jwkn_kanaorder = 2
  )
, (select ks_kanjiID from kanjiSystem where ks_char = '高')
, 0
);

--yasui

insert into japaneseWordkanjiLink values(
  (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  inner join japaneseWordKanaLink c
  inner join japaneseWordKanaLink d
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID 
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'や')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'す')
  and c.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'い')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  and c.jwkn_kanaorder = 2
  )
, (select ks_kanjiID from kanjiSystem where ks_char = '安')
, 0
);

--mijikai

insert into japaneseWordkanjiLink values(
  (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  inner join japaneseWordKanaLink c
  inner join japaneseWordKanaLink d
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID 
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and c.jwkn_japaneseWordID = d.jwkn_japaneseWordID
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'み')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'じ')
  and c.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'か')
  and d.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'い')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  and c.jwkn_kanaorder = 2
  and d.jwkn_kanaorder = 3
  )
, (select ks_kanjiID from kanjiSystem where ks_char = '短')
, 0
);

--hikui

insert into japaneseWordkanjiLink values(
  (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  inner join japaneseWordKanaLink c
  inner join japaneseWordKanaLink d
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID 
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'ひ')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'く')
  and c.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'い')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  and c.jwkn_kanaorder = 2
  )
, (select ks_kanjiID from kanjiSystem where ks_char = '低')
, 0
);


insert into englishPhraseIndex values (NULL);

insert into englishPhrase values (
  (select max(epi_ID) from englishPhraseIndex)
 ,(select ew_wordid from englishWord where ew_word = 'short')
 ,0
);

insert into englishPhrase values (
  (select max(epi_ID) from englishPhraseIndex)
 ,(select ew_wordid from englishWord where ew_word = 'for')
 ,0
);

insert into englishPhrase values (
  (select max(epi_ID) from englishPhraseIndex)
 ,(select ew_wordid from englishWord where ew_word = 'object')
 ,0
);

insert into japaneseWordDescription values (
    (select a.jwkn_japaneseWordID
  from japaneseWordKanaLink a
  inner join japaneseWordKanaLink b
  inner join japaneseWordKanaLink c
  inner join japaneseWordKanaLink d
  on a.jwkn_japaneseWordID = b.jwkn_japaneseWordID
  and b.jwkn_japaneseWordID = c.jwkn_japaneseWordID
  and c.jwkn_japaneseWordID = d.jwkn_japaneseWordID
  and a.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'み')
  and b.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'じ')
  and c.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'か')
  and d.jwkn_kanaID = (select kns_kanaID from kanaSystem where kns_hiragana = 'い')
  and a.jwkn_kanaorder = 0
  and b.jwkn_kanaorder = 1
  and c.jwkn_kanaorder = 2
  and d.jwkn_kanaorder = 3
  )
, (select max(epi_ID) from englishPhraseIndex)
);
---------------------------------------------------------------------------------
-- Link together a sequence of English words and a sequence
-- of Japanese words.
---------------------------------------------------------------------------------
-- If Japanese-English word link does not already exist
-- AND Japanese word(s) exists
-- AND English word(s) exists

-- complexity will be in the Python that generates jWordOrder, eWordOrder
-- insert into japaneseEnglishWordLinkIndex (
--  jewli_linkID
--) values (
--  NULL
--);
--select max(jewli_linkID)
--  from japaneseEnglishWordLinkIndex;

--insert into japaneseEnglishWordLink (
--  jewl_linkID --determined by previous SQL query
-- ,jewl_japaneseWordID
-- ,jewl_englishWordID
-- ,jewl_japaneseWordOrder
-- ,jewl_englishWordOrder
--) values (
--  NULL, ?, ?, ?, ?
--);

-- Create an English phrase from sequence of English words
-- if phrase does not already exist

-- insert englishPhraseIndex (
--  epi_ID
--) values (
--  NULL
--);
--getEnglishPhraseIndex = select max(epi_ID)
--  from englishPhraseIndex;

-- insert into englishPhrase (
--  ep_id
-- ,ep_englishWordID
-- ,ep_order
--) values (
--  ?, ?, ?
--);






