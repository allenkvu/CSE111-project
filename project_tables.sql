Create TABLE englishWord(
       ew_wordid INTEGER PRIMARY KEY -- auto increment if NULL inserted
       , ew_word VARCHAR(20) UNIQUE
);

CREATE TABLE englishWordOpposite(
	ewo_englishWordID INTEGER
	, ewo_englishOppositeID INTEGER
	, FOREIGN KEY(ewo_englishWordID) REFERENCES englishWord(ew_wordid)
	, FOREIGN KEY(ewo_englishOppositeID) REFERENCES englishWord(ew_wordid)
);

CREATE TABLE englishPhraseIndex(
	epi_ID INTEGER PRIMARY KEY
);

CREATE TABLE englishPhrase(   -- English Phrase is now a weak entity set
	ep_ID INTEGER
	, ep_englishwordID INTEGER NOT NULL
	, ep_order INTEGER DEFAULT 0
	, FOREIGN KEY(ep_ID) REFERENCES englishPhraseIndex(epi_ID)
	, FOREIGN KEY(ep_englishWordID) REFERENCES englishWord(ew_wordid)
);

--not very sure if right
--start
CREATE TABLE japaneseWord(
        jw_WordID INTEGER PRIMARY KEY
);

CREATE TABLE japaneseWordPredecessor(
        jwp_japaneseWordID INTEGER
        , jwp_predecessorID INTEGER
	, FOREIGN KEY(jwp_japaneseWordID) REFERENCES japaneseWord(jw_WordID)
	, FOREIGN KEY(jwp_predecessorID) REFERENCES japaneseWord(jw_WordID)

);


CREATE TABLE japaneseWordOpposite(
    	jwo_japaneseWordID INTEGER
    	, jwo_oppositeID INTEGER
	, FOREIGN KEY(jwo_japaneseWordID) REFERENCES japaneseWord(jw_WordID)
	, FOREIGN KEY(jwo_oppositeID) REFERENCES japaneseWord(jw_WordID)
);

CREATE TABLE japaneseWordDescription(
    	jwd_japaneseWordID INTEGER
        , jwd_englishPhraseID INTEGER
	, FOREIGN KEY(jwd_japaneseWordID) REFERENCES japaneseWord(jw_wordID)
	, FOREIGN KEY(jwd_englishPhraseID) REFERENCES englishPhrase(ep_ID)
);

--end

CREATE TABLE japaneseEnglishWordLinkIndex(
	jewli_linkID INTEGER PRIMARY KEY
);

CREATE TABLE japaneseEnglishWordLink(
	jewl_linkID INTEGER NOT NULL -- not really a key
	, jewl_japaneseWordID INTEGER NOT NULL
	, jewl_englishWordID INTEGER NOT NULL
	, jewl_japaneseWordOrder INTEGER DEFAULT 0
	, jewl_englishWordOrder INTEGER DEFAULT 0
	, FOREIGN KEY(jewl_linkID) REFERENCES
	  	  japaneseEnglishWordLinkIndex(jewli_linkID)
	, FOREIGN KEY(jewl_japaneseWordID) REFERENCES
	  	  japaneseWord(jw_wordID)
	, FOREIGN KEY(jewl_englishWordID) REFERENCES
	  	  englishWord(ew_wordID)
);

CREATE TABLE japaneseWordKanaLink(
	jwkn_japaneseWordID INTEGER NOT NULL
	, jwkn_kanaID INTEGER NOT NULL
	, jwkn_kanaOrder DEFAULT 0
	, FOREIGN KEY(jwkn_japaneseWordID) REFERENCES
	  	  japaneseWord(jw_wordID)
	, FOREIGN KEY(jwkn_kanaID) REFERENCES
	  	  kanaSystem(kns_kanaID)
);
-- jwk_order used to order Kana characters to spell one
-- Japanese word; ordering of multiple Japanese words that
-- share a Kana character is unimportant.

CREATE TABLE japaneseWordKanjiLink(
	jwki_japaneseWordID INTEGER NOT NULL
	, jwki_kanjiID INTEGER NOT NULL
	, jwki_order INTEGER DEFAULT 0
	, FOREIGN KEY(jwki_japaneseWordID) REFERENCES
		japaneseWord(jw_wordID)
	, FOREIGN KEY(jwki_kanjiID) REFERENCES
	  	kanjiSystem(ks_kanjiID)
);

CREATE TABLE kanaSystem(
	kns_kanaID INTEGER PRIMARY KEY
	, kns_hiragana nvarchar(20) UNIQUE
	, kns_katakana nvarchar(20) UNIQUE
	, kns_romaji varchar(5) UNIQUE
);

CREATE TABLE waseiEigoKanaLinkIndex(
	wekli_linkID INTEGER PRIMARY KEY
);

CREATE TABLE waseiEigoKanaLink(
	wekl_linkID INTEGER NOT NULL
	, wekl_waseiEigoId INTEGER NOT NULL
	, wekl_kanaID INTEGER NOT NULL
	, wekl_kanaOrder INTEGER DEFAULT 0
	, FOREIGN KEY(wekl_linkID) REFERENCES
	  	  waseiEigoKanaLinkIndex(wekli_linkID)
	, FOREIGN KEY(wekl_waseiEigoId) REFERENCES
	  	  waseiEigo(we_waseiEigoID)
	, FOREIGN KEY(wekl_kanaID) REFERENCES
	  	  kanaSystem(kns_kanaID)
);

CREATE TABLE kanjiSystem(
	ks_kanjiID INTEGER PRIMARY KEY
	, ks_char nvarchar(20) NOT NULL UNIQUE
);

-- link index only necessary when bidirectional ordering matters;
-- kanji-English is a many to many relationship,
-- but we only care about 
--kanjiEnglishLinkIndex(
--	keli_index INTEGER PRIMARY KEY
--);
CREATE TABLE kanjiEnglishLink(
--	kel_index INTEGER NOT NULL
	kel_kanjiID INTEGER NOT NULL
	, kel_englishWordID INTEGER NOT NULL
	, kel_englishWordOrder INTEGER DEFAULT 0
	, FOREIGN KEY(kel_englishWordID) REFERENCES
	  	  englishWord(ew_wordID)
	, FOREIGN KEY(kel_kanjiID) REFERENCES
	  	  kanjiSystem(ks_kanjiID)
);

--should we_easeiEigo be nvarchar(20)? 
-- Wasei Eigo is just a link to a Japanese word
-- also a sequence of Kana, by extension
CREATE TABLE waseiEigo(
        we_waseiEigoID INTEGER
        , we_japaneseWordID INTEGER NOT NULL
	, FOREIGN KEY(we_japaneseWordID) REFERENCES
	  	  japaneseWord(jw_wordID)
);
--englishWaseiEigoPhoneticLink(ewep_englishWordID, ewep_waseiEigoID)
-- use a function to find phonetic links; don't store them

--CREATE TABLE englishWaseiEigoEqualityLink(
--       ewep_englishWordID INTEGER
--       , ewep_waseiEigoID INTEGER
--);

