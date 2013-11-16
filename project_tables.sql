CREATE TABLE englishWord(
       ew_wordid INTEGER PRIMARY KEY AUTOINCREMENT
       , ew_word VARCHAR(20)
);
englishWordOpposite(
	ewo_englishWordID INTEGER
	, ewo_englishOppositeID INTEGER
	, FOREIGN KEY(ewo_englishWordID) REFERENCES englishWord(ew_wordid)
	, FOREIGN KEY(ewo_englishOppositeID) REFERENCES englishWord(ew_wordid)
);

englishPhraseIndex(
	epi_ID INTEGER PRIMARY KEY AUTOINCREMENT
);
englishPhrase(   -- English Phrase is now a weak entity set
	ep_ID INTEGER
	, ep_englishwordID INTEGER NOT NULL
	, ep_order INTEGER DEFAULT 0
	, FOREIGN KEY(ep_id) REFERENCES englishPhraseIndex(epi_id)
);

japaneseWord(jw_WordID)
japaneseWordPredecessor(jwp_japaneseWordID, jpp_predecessorID)
japaneseWordOpposite(jwo_japaneseWordID, jpo_oppositeID)
japaneseWordDescription(jwd_japaneseWordID, jwd_englishPhraseID)

japaneseEnglishWordLinkIndex(
	jewli_linkID INTEGER PRIMARY KEY AUTOINCREMENT
);
japaneseEnglishWordLink(
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

japaneseWordKanaLink(
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

japaneseWordKangiLink(
	jwki_japaneseWordID INTEGER NOT NULL
	, jwki_kangiID INTEGER NOT NULL
	, jwki_order INTEGER DEFAULT 0
	, FOREIGN KEY(jwki_japaneseWordID) REFERENCES
		japaneseWord(jw_wordID)
	, FOREIGN KEY(jwki_kangiID) REFERENCES
	  	kangiSystem(ks_kangiID)
);

kanaSystem(
	kns_kanaID INTEGER PRIMARY KEY AUTOINCREMENT
	, kns_hiragana nvarchar(20)
	, kns_katakana nvarchar(20)
	, kns_romaji varchar(5)
);

waseiEigoKanaLinkIndex(
	wekli_linkID INTEGER PRIMARY KEY AUTOINCREMENT
);

waseiEigoKanaLink(
	wekl_linkID INTEGER NOT NULL
	, wekl_waseiEigoId INTEGER NOT NULL
	, wekl_kanaID INTEGER NOT NULL
	, wekl_kanaOrder INTEGER DEFAULT 0
	, FOREIGN KEY(wekl_linkID) REFERENCES
	  	  waseiEigoKanaLinkIndex(wekli_linkid)
	, FOREIGN KEY(wekl_waseiEigoId) REFERENCES
	  	  waseiEigo(we_waseiEigoID)
	, FOREIGN KEY(wekl_kanaID) REFERENCES
	  	  kanaSystem(kns_id)
);

kangiSystem(
	ks_kangiID INTEGER PRIMARY KEY AUTOINCREMENT
	, ks_char nvarchar(20) NOT NULL
);

-- link index only necessary when bidirectional ordering matters;
-- kangi-English is a many to many relationship,
-- but we only care about 
--kangiEnglishLinkIndex(
--	keli_index INTEGER PRIMARY KEY AUTOINCREMENT
--);
kangiEnglishLink(
--	kel_index INTEGER NOT NULL
	kel_kangiID INTEGER NOT NULL
	, kel_englishWordID INTEGER NOT NULL
	, kel_englishWordOrder INTEGER DEFAULT 0
	, FOREIGN KEY(kel_englishWordID) REFERENCES
	  	  englishWord(ew_wordID)
	, FOREIGN KEY(kel_kangiID) REFERENCES
	  	  kangiSystem(ks_kangiID)
);

waseiEigo(we_waseiEigoID
, we_japaneseWordID
, we_waseiEigo
)
--englishWaseiEigoPhoneticLink(ewep_englishWordID, ewep_waseiEigoID)
-- use a function to find phonetic links; don't store them

englishWaseiEigoEqualityLink(ewep_englishWordID, ewep_waseiEigoID)

