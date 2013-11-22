
-- Single Word Insertions
-- (excluding Japanese word weak entity set)
--

-- English word insertion
--insertEnglishWord = "insert into englishWord (\
--  ew_wordID\
-- ,ew_word\
--) values (\
--  NULL, %s\
--);"

--random english word
insert into englishWord values(NULL, 'mountain');
insert into englishWord values(NULL, 'tall');
insert into englishWord values(NULL, 'expensive');
insert into englishWord values(NULL, 'short');
insert into englishWord values(NULL, 'cheap');
insert into englishWord values(NULL, 'rest');

insert into englishWord values(NULL, 'for');
insert into englishWord values(NULL, 'object');

--# Hiragana, Katakana, Romaji insertion (together)
--insertKanaWord = "insert into kanaSystem (\
--  kns_kanaID\
-- ,kns_hiragana\
-- ,kns_katakana\
-- ,kns_romaji\
--) values (\
-- NULL, ?, ?, ?\
--);"
INSERT INTO kanaSystem
VALUES 
(NULL, 'あ','ア','a');
INSERT INTO kanaSystem
VALUES (NULL, 'い','イ','i');
INSERT INTO kanaSystem
VALUES (NULL, 'う','ウ','u');
insert into kanaSystem values (NULL,'え','エ','e');
insert into kanaSystem values (NULL,'お','オ','o');
insert into kanaSystem values (NULL,'か','カ','ka');
insert into kanaSystem values (NULL,'き','キ','ki');
insert into kanaSystem values (NULL,'く','ク','ku');
insert into kanaSystem values (NULL,'け','ケ','ke');
insert into kanaSystem values (NULL,'こ','コ','ko');
insert into kanaSystem values (NULL,'さ','サ','sa');
insert into kanaSystem values (NULL,'し','シ','shi');
insert into kanaSystem values (NULL,'す','ス','su');
insert into kanaSystem values (NULL,'せ','セ','se');
insert into kanaSystem values (NULL,'そ','ソ','so');
insert into kanaSystem values (NULL,'た','タ','ta');
insert into kanaSystem values (NULL,'ち','チ','chi');
insert into kanaSystem values (NULL,'つ','ツ','tsu');
insert into kanaSystem values (NULL,'て','テ','te');
insert into kanaSystem values (NULL,'と','ト','to');
insert into kanaSystem values (NULL,'な','ナ','na');
insert into kanaSystem values (NULL,'に','ニ','ni');
insert into kanaSystem values (NULL,'ぬ','ヌ','nu');
insert into kanaSystem values (NULL,'ね','ネ','ne');
insert into kanaSystem values (NULL,'の','ノ','no');
insert into kanaSystem values (NULL,'は','ハ','ha');
insert into kanaSystem values (NULL,'ひ','ヒ','hi');
insert into kanaSystem values (NULL,'ふ','フ','fu');
insert into kanaSystem values (NULL,'へ','ヘ','he');
insert into kanaSystem values (NULL,'ほ','ホ','ho');
insert into kanaSystem values (NULL,'ま','マ','ma');
insert into kanaSystem values (NULL,'み','ミ','mi');
insert into kanaSystem values (NULL,'む','ム','mu');
insert into kanaSystem values (NULL,'め','メ','me');
insert into kanaSystem values (NULL,'も','モ','mo');
insert into kanaSystem values (NULL,'や','ヤ','ya');
insert into kanaSystem values (NULL,'ゆ','ユ','yu');
insert into kanaSystem values (NULL,'よ','ヨ','yo');
insert into kanaSystem values (NULL,'ら','ラ','ra');
insert into kanaSystem values (NULL,'り','リ','ri');
insert into kanaSystem values (NULL,'る','ル','ru');
insert into kanaSystem values (NULL,'れ','レ','re');
insert into kanaSystem values (NULL,'ろ','ロ','ro');
insert into kanaSystem values (NULL,'わ','ワ','wa');
insert into kanaSystem values (NULL,'を','ヲ','wo');
insert into kanaSystem values (NULL,'ん','ン','n');
insert into kanaSystem values (NULL,'が','ガ','ga');
insert into kanaSystem values (NULL,'ぎ','ギ','gi');
insert into kanaSystem values (NULL,'ぐ','グ','gu');
insert into kanaSystem values (NULL,'げ','ゲ','ge');
insert into kanaSystem values (NULL,'ご','ゴ','go');
insert into kanaSystem values (NULL,'ざ','ザ','za');
insert into kanaSystem values (NULL,'じ','ジ','ji');
insert into kanaSystem values (NULL,'ず','ズ','zu');
insert into kanaSystem values (NULL,'ぜ','ゼ','ze');
insert into kanaSystem values (NULL,'だ','ダ','da');
insert into kanaSystem values (NULL,'で','デ','de');
insert into kanaSystem values (NULL,'ど','ド','do');
insert into kanaSystem values (NULL,'ば','バ','ba');
insert into kanaSystem values (NULL,'び','ビ','bi' );
insert into kanaSystem values (NULL,'ぶ','ブ','bu');
insert into kanaSystem values (NULL,'べ','ベ','be');
insert into kanaSystem values (NULL,'ぼ','ボ','bo');
--insert into kanaSystem values (NULL,'ば','パ','pa');
insert into kanaSystem values (NULL,'ぴ','ピ','pi');
insert into kanaSystem values (NULL,'ぷ','プ','pu');
insert into kanaSystem values (NULL,'ぺ','ペ','pe');
insert into kanaSystem values (NULL,'ぽ','ポ','po');
insert into kanaSystem values (NULL,'きゃ','キャ','kya');
insert into kanaSystem values (NULL,'きゅ','キュ','kyu');
insert into kanaSystem values (NULL,'きょ','キョ','kyo');
insert into kanaSystem values (NULL,'しゃ','シャ','sha');
insert into kanaSystem values (NULL,'しゅ','シュ','shu');
insert into kanaSystem values (NULL,'しょ','ショ','sho');
insert into kanaSystem values (NULL,'ちゃ','チャ','cha');
insert into kanaSystem values (NULL,'ちゅ','チュ','chu');
insert into kanaSystem values (NULL,'ちょ','チョ','cho');
insert into kanaSystem values (NULL,'にゃ','ニャ','nya');
insert into kanaSystem values (NULL,'にゅ','ニュ','nyu');
insert into kanaSystem values (NULL,'にょ','ニョ','nyo');
insert into kanaSystem values (NULL,'ひゃ','ヒャ','hya');
insert into kanaSystem values (NULL,'ひゅ','ヒュ','hyu');
insert into kanaSystem values (NULL,'ひょ','ヒョ','hyo');
insert into kanaSystem values (NULL,'みゃ','ミャ','mya');
insert into kanaSystem values (NULL,'みゅ','ミュ','myu');
insert into kanaSystem values (NULL,'みょ','ミョ','myo');
insert into kanaSystem values (NULL,'りゃ','リャ','rya');
insert into kanaSystem values (NULL,'りゅ','リュ','ryu');
insert into kanaSystem values (NULL,'りょ','リョ','ryo');
insert into kanaSystem values (NULL,'ぎゃ','ギャ','gya');
insert into kanaSystem values (NULL,'ぎゅ','ギュ','gyu');
insert into kanaSystem values (NULL,'ぎょ','ギョ','gyo');
insert into kanaSystem values (NULL,'じゃ','ジャ','ja');
insert into kanaSystem values (NULL,'じゅ','ジュ','ju');
insert into kanaSystem values (NULL,'じょ','ジョ','jo');
insert into kanaSystem values (NULL,'びゃ','ビャ','bya');
insert into kanaSystem values (NULL,'びゅ','ビュ','byu');
insert into kanaSystem values (NULL,'びょ','ビョ','byo');
insert into kanaSystem values (NULL,'ぴゃ','ピャ','pya');
insert into kanaSystem values (NULL,'ぴゅ','ピュ','pyu');
insert into kanaSystem values (NULL,'ぴょ','ピョ','pyo');
insert into kanaSystem values (NULL, 'っ','ッ','xtsu');
insert into kanaSystem values (NULL,'ふぁ','ファ','fa');

--# Kangi character insertion
--insertKangiWord = "insert into kangiSystem (\
--  ks_kangiID\
-- ,ks_char\
--) values (\
--  NULL, ?\
--);"
insert into kanjiSystem values (NULL, '山');
insert into kanjiSystem values (NULL, '休');
insert into kanjiSystem values (NULL, '憩');
insert into kanjiSystem values (NULL, '息');
insert into kanjiSystem values (NULL, '高');
insert into kanjiSystem values (NULL, '安');
insert into kanjiSystem values (NULL, '短');
insert into kanjiSystem values (NULL, '低');
