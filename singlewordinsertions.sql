
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
(NULL, '��','�A','a'),
(NULL, '��','�C','i'),
(NULL, '��','�E','u'),
(NULL,'��','�G','e'),
(NULL,'��','�I','o'),
(NULL,'��','�J','ka'),
(NULL,'��','�L','ki'),
(NULL,'��','�N','ku'),
(NULL,'��','�P','ke'),
(NULL,'��','�R','ko'),
(NULL,'��','�T','sa'),
(NULL,'��','�V','shi'),
(NULL,'��','�X','su'),
(NULL,'��','�Z','se'),
(NULL,'��','�\','so'),
(NULL,'��','�^','ta'),
(NULL,'��','�`','chi'),
(NULL,'��','�c','tsu'),
(NULL,'��','�e','te'),
(NULL,'��','�g','to'),
(NULL,'��','�i','na'),
(NULL,'��','�j','ni'),
(NULL,'��','�k','nu'),
(NULL,'��','�l','ne'),
(NULL,'��','�m','no'),
(NULL,'��','�n','ha'),
(NULL,'��','�q','hi'),
(NULL,'��','�t','fu'),
(NULL,'��','�w','he'),
(NULL,'��','�z','ho'),
(NULL,'��','�}','ma'),
(NULL,'��','�~','mi'),
(NULL,'��','��','mu'),
(NULL,'��','��','me'),
(NULL,'��','��','mo'),
(NULL,'��','��','ya'),
(NULL,'��','��','yu'),
(NULL,'��','��','yo'),
(NULL,'��','��','ra'),
(NULL,'��','��','ri'),
(NULL,'��','��','ru'),
(NULL,'��','��','re'),
(NULL,'��','��','ro'),
(NULL,'��','��','wa'),
(NULL,'��','��','wo'),
(NULL,'��','��','n'),
(NULL,'��','�K','ga'),
(NULL,'��','�M','gi'),
(NULL,'��','�O','gu'),
(NULL,'��','�Q','ge'),
(NULL,'��','�S','go'),
(NULL,'��','�U','za'),
(NULL,'��','�W','ji'),
(NULL,'��','�Y','zu'),
(NULL,'��','�[','ze'),
(NULL,'��','�_','da'),
(NULL,'��','�f','de'),
(NULL,'��','�h','do'),
(NULL,'��','�o','ba'),
(NULL,'��','�r','bi' ),
(NULL,'��','�u','bu'),
(NULL,'��','�x','be'),
(NULL,'��','�{','bo'),
(NULL,'��','�p','pa'),
(NULL,'��','�s','pi'),
(NULL,'��','�v','pu'),
(NULL,'��','�y','pe'),
(NULL,'��','�|','po'),
(NULL,'����','�L��','kya'),
(NULL,'����','�L��','kyu'),
(NULL,'����','�L��','kyo'),
(NULL,'����','�V��','sha'),
(NULL,'����','�V��','shu'),
(NULL,'����','�V��','sho'),
(NULL,'����','�`��','cha'),
(NULL,'����','�`��','chu'),
(NULL,'����','�`��','cho'),
(NULL,'�ɂ�','�j��','nya'),
(NULL,'�ɂ�','�j��','nyu'),
(NULL,'�ɂ�','�j��','nyo'),
(NULL,'�Ђ�','�q��','hya'),
(NULL,'�Ђ�','�q��','hyu'),
(NULL,'�Ђ�','�q��','hyo'),
(NULL,'�݂�','�~��','mya'),
(NULL,'�݂�','�~��','myu'),
(NULL,'�݂�','�~��','myo'),
(NULL,'���','����','rya'),
(NULL,'���','����','ryu'),
(NULL,'���','����','ryo'),
(NULL,'����','�M��','gya'),
(NULL,'����','�M��','gyu'),
(NULL,'����','�M��','gyo'),
(NULL,'����','�W��','ja'),
(NULL,'����','�W��','ju'),
(NULL,'����','�W��','jo'),
(NULL,'�т�','�r��','bya'),
(NULL,'�т�','�r��','byu'),
(NULL,'�т�','�r��','byo'),
(NULL,'�҂�','�s��','pya'),
(NULL,'�҂�','�s��','pyu'),
(NULL,'�҂�','�s��','pyo'),
(NULL, '��','�b','xtsu'),
(NULL,'�ӂ�','�t�@','fa');

--# Kangi character insertion
--insertKangiWord = "insert into kangiSystem (\
--  ks_kangiID\
-- ,ks_char\
--) values (\
--  NULL, ?\
--);"
insert into kanjiSystem values (NULL, '�R');
insert into kanjiSystem values(NULL, '�x');
insert into kanjiSystem values(NULL, '�e');
insert into kanjiSystem values(NULL, '��');
insert into kanjiSystem values(NULL, '��');
insert into kanjiSystem values(NULL, '��');
insert into kanjiSystem values(NULL, '�Z');
insert into kanjiSystem values(NULL, '��');
