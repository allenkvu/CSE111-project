
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
(NULL, 'あ','ア','a'),
(NULL, 'い','イ','i'),
(NULL, 'う','ウ','u'),
(NULL,'え','エ','e'),
(NULL,'お','オ','o'),
(NULL,'か','カ','ka'),
(NULL,'き','キ','ki'),
(NULL,'く','ク','ku'),
(NULL,'け','ケ','ke'),
(NULL,'こ','コ','ko'),
(NULL,'さ','サ','sa'),
(NULL,'し','シ','shi'),
(NULL,'す','ス','su'),
(NULL,'せ','セ','se'),
(NULL,'そ','ソ','so'),
(NULL,'た','タ','ta'),
(NULL,'ち','チ','chi'),
(NULL,'つ','ツ','tsu'),
(NULL,'て','テ','te'),
(NULL,'と','ト','to'),
(NULL,'な','ナ','na'),
(NULL,'に','ニ','ni'),
(NULL,'ぬ','ヌ','nu'),
(NULL,'ね','ネ','ne'),
(NULL,'の','ノ','no'),
(NULL,'は','ハ','ha'),
(NULL,'ひ','ヒ','hi'),
(NULL,'ふ','フ','fu'),
(NULL,'へ','ヘ','he'),
(NULL,'ほ','ホ','ho'),
(NULL,'ま','マ','ma'),
(NULL,'み','ミ','mi'),
(NULL,'む','ム','mu'),
(NULL,'め','メ','me'),
(NULL,'も','モ','mo'),
(NULL,'や','ヤ','ya'),
(NULL,'ゆ','ユ','yu'),
(NULL,'よ','ヨ','yo'),
(NULL,'ら','ラ','ra'),
(NULL,'り','リ','ri'),
(NULL,'る','ル','ru'),
(NULL,'れ','レ','re'),
(NULL,'ろ','ロ','ro'),
(NULL,'わ','ワ','wa'),
(NULL,'を','ヲ','wo'),
(NULL,'ん','ン','n'),
(NULL,'が','ガ','ga'),
(NULL,'ぎ','ギ','gi'),
(NULL,'ぐ','グ','gu'),
(NULL,'げ','ゲ','ge'),
(NULL,'ご','ゴ','go'),
(NULL,'ざ','ザ','za'),
(NULL,'じ','ジ','ji'),
(NULL,'ず','ズ','zu'),
(NULL,'ぜ','ゼ','ze'),
(NULL,'だ','ダ','da'),
(NULL,'で','デ','de'),
(NULL,'ど','ド','do'),
(NULL,'ば','バ','ba'),
(NULL,'び','ビ','bi' ),
(NULL,'ぶ','ブ','bu'),
(NULL,'べ','ベ','be'),
(NULL,'ぼ','ボ','bo'),
(NULL,'ば','パ','pa'),
(NULL,'ぴ','ピ','pi'),
(NULL,'ぷ','プ','pu'),
(NULL,'ぺ','ペ','pe'),
(NULL,'ぽ','ポ','po'),
(NULL,'きゃ','キャ','kya'),
(NULL,'きゅ','キュ','kyu'),
(NULL,'きょ','キョ','kyo'),
(NULL,'しゃ','シャ','sha'),
(NULL,'しゅ','シュ','shu'),
(NULL,'しょ','ショ','sho'),
(NULL,'ちゃ','チャ','cha'),
(NULL,'ちゅ','チュ','chu'),
(NULL,'ちょ','チョ','cho'),
(NULL,'にゃ','ニャ','nya'),
(NULL,'にゅ','ニュ','nyu'),
(NULL,'にょ','ニョ','nyo'),
(NULL,'ひゃ','ヒャ','hya'),
(NULL,'ひゅ','ヒュ','hyu'),
(NULL,'ひょ','ヒョ','hyo'),
(NULL,'みゃ','ミャ','mya'),
(NULL,'みゅ','ミュ','myu'),
(NULL,'みょ','ミョ','myo'),
(NULL,'りゃ','リャ','rya'),
(NULL,'りゅ','リュ','ryu'),
(NULL,'りょ','リョ','ryo'),
(NULL,'ぎゃ','ギャ','gya'),
(NULL,'ぎゅ','ギュ','gyu'),
(NULL,'ぎょ','ギョ','gyo'),
(NULL,'じゃ','ジャ','ja'),
(NULL,'じゅ','ジュ','ju'),
(NULL,'じょ','ジョ','jo'),
(NULL,'びゃ','ビャ','bya'),
(NULL,'びゅ','ビュ','byu'),
(NULL,'びょ','ビョ','byo'),
(NULL,'ぴゃ','ピャ','pya'),
(NULL,'ぴゅ','ピュ','pyu'),
(NULL,'ぴょ','ピョ','pyo'),
(NULL, 'っ','ッ','xtsu'),
(NULL,'ふぁ','ファ','fa');

--# Kangi character insertion
--insertKangiWord = "insert into kangiSystem (\
--  ks_kangiID\
-- ,ks_char\
--) values (\
--  NULL, ?\
--);"
insert into kanjiSystem values (NULL, '山');
insert into kanjiSystem values(NULL, '休');
insert into kanjiSystem values(NULL, '憩');
insert into kanjiSystem values(NULL, '息');
insert into kanjiSystem values(NULL, '高');
insert into kanjiSystem values(NULL, '安');
insert into kanjiSystem values(NULL, '短');
insert into kanjiSystem values(NULL, '低');
