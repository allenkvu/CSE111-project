
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
(NULL, '��','�A','a');
INSERT INTO kanaSystem
VALUES (NULL, '��','�C','i');
INSERT INTO kanaSystem
VALUES (NULL, '��','�E','u');
insert into kanaSystem values (NULL,'��','�G','e');
insert into kanaSystem values (NULL,'��','�I','o');
insert into kanaSystem values (NULL,'��','�J','ka');
insert into kanaSystem values (NULL,'��','�L','ki');
insert into kanaSystem values (NULL,'��','�N','ku');
insert into kanaSystem values (NULL,'��','�P','ke');
insert into kanaSystem values (NULL,'��','�R','ko');
insert into kanaSystem values (NULL,'��','�T','sa');
insert into kanaSystem values (NULL,'��','�V','shi');
insert into kanaSystem values (NULL,'��','�X','su');
insert into kanaSystem values (NULL,'��','�Z','se');
insert into kanaSystem values (NULL,'��','�\','so');
insert into kanaSystem values (NULL,'��','�^','ta');
insert into kanaSystem values (NULL,'��','�`','chi');
insert into kanaSystem values (NULL,'��','�c','tsu');
insert into kanaSystem values (NULL,'��','�e','te');
insert into kanaSystem values (NULL,'��','�g','to');
insert into kanaSystem values (NULL,'��','�i','na');
insert into kanaSystem values (NULL,'��','�j','ni');
insert into kanaSystem values (NULL,'��','�k','nu');
insert into kanaSystem values (NULL,'��','�l','ne');
insert into kanaSystem values (NULL,'��','�m','no');
insert into kanaSystem values (NULL,'��','�n','ha');
insert into kanaSystem values (NULL,'��','�q','hi');
insert into kanaSystem values (NULL,'��','�t','fu');
insert into kanaSystem values (NULL,'��','�w','he');
insert into kanaSystem values (NULL,'��','�z','ho');
insert into kanaSystem values (NULL,'��','�}','ma');
insert into kanaSystem values (NULL,'��','�~','mi');
insert into kanaSystem values (NULL,'��','��','mu');
insert into kanaSystem values (NULL,'��','��','me');
insert into kanaSystem values (NULL,'��','��','mo');
insert into kanaSystem values (NULL,'��','��','ya');
insert into kanaSystem values (NULL,'��','��','yu');
insert into kanaSystem values (NULL,'��','��','yo');
insert into kanaSystem values (NULL,'��','��','ra');
insert into kanaSystem values (NULL,'��','��','ri');
insert into kanaSystem values (NULL,'��','��','ru');
insert into kanaSystem values (NULL,'��','��','re');
insert into kanaSystem values (NULL,'��','��','ro');
insert into kanaSystem values (NULL,'��','��','wa');
insert into kanaSystem values (NULL,'��','��','wo');
insert into kanaSystem values (NULL,'��','��','n');
insert into kanaSystem values (NULL,'��','�K','ga');
insert into kanaSystem values (NULL,'��','�M','gi');
insert into kanaSystem values (NULL,'��','�O','gu');
insert into kanaSystem values (NULL,'��','�Q','ge');
insert into kanaSystem values (NULL,'��','�S','go');
insert into kanaSystem values (NULL,'��','�U','za');
insert into kanaSystem values (NULL,'��','�W','ji');
insert into kanaSystem values (NULL,'��','�Y','zu');
insert into kanaSystem values (NULL,'��','�[','ze');
insert into kanaSystem values (NULL,'��','�_','da');
insert into kanaSystem values (NULL,'��','�f','de');
insert into kanaSystem values (NULL,'��','�h','do');
insert into kanaSystem values (NULL,'��','�o','ba');
insert into kanaSystem values (NULL,'��','�r','bi' );
insert into kanaSystem values (NULL,'��','�u','bu');
insert into kanaSystem values (NULL,'��','�x','be');
insert into kanaSystem values (NULL,'��','�{','bo');
--insert into kanaSystem values (NULL,'��','�p','pa');
insert into kanaSystem values (NULL,'��','�s','pi');
insert into kanaSystem values (NULL,'��','�v','pu');
insert into kanaSystem values (NULL,'��','�y','pe');
insert into kanaSystem values (NULL,'��','�|','po');
insert into kanaSystem values (NULL,'����','�L��','kya');
insert into kanaSystem values (NULL,'����','�L��','kyu');
insert into kanaSystem values (NULL,'����','�L��','kyo');
insert into kanaSystem values (NULL,'����','�V��','sha');
insert into kanaSystem values (NULL,'����','�V��','shu');
insert into kanaSystem values (NULL,'����','�V��','sho');
insert into kanaSystem values (NULL,'����','�`��','cha');
insert into kanaSystem values (NULL,'����','�`��','chu');
insert into kanaSystem values (NULL,'����','�`��','cho');
insert into kanaSystem values (NULL,'�ɂ�','�j��','nya');
insert into kanaSystem values (NULL,'�ɂ�','�j��','nyu');
insert into kanaSystem values (NULL,'�ɂ�','�j��','nyo');
insert into kanaSystem values (NULL,'�Ђ�','�q��','hya');
insert into kanaSystem values (NULL,'�Ђ�','�q��','hyu');
insert into kanaSystem values (NULL,'�Ђ�','�q��','hyo');
insert into kanaSystem values (NULL,'�݂�','�~��','mya');
insert into kanaSystem values (NULL,'�݂�','�~��','myu');
insert into kanaSystem values (NULL,'�݂�','�~��','myo');
insert into kanaSystem values (NULL,'���','����','rya');
insert into kanaSystem values (NULL,'���','����','ryu');
insert into kanaSystem values (NULL,'���','����','ryo');
insert into kanaSystem values (NULL,'����','�M��','gya');
insert into kanaSystem values (NULL,'����','�M��','gyu');
insert into kanaSystem values (NULL,'����','�M��','gyo');
insert into kanaSystem values (NULL,'����','�W��','ja');
insert into kanaSystem values (NULL,'����','�W��','ju');
insert into kanaSystem values (NULL,'����','�W��','jo');
insert into kanaSystem values (NULL,'�т�','�r��','bya');
insert into kanaSystem values (NULL,'�т�','�r��','byu');
insert into kanaSystem values (NULL,'�т�','�r��','byo');
insert into kanaSystem values (NULL,'�҂�','�s��','pya');
insert into kanaSystem values (NULL,'�҂�','�s��','pyu');
insert into kanaSystem values (NULL,'�҂�','�s��','pyo');
insert into kanaSystem values (NULL, '��','�b','xtsu');
insert into kanaSystem values (NULL,'�ӂ�','�t�@','fa');

--# Kangi character insertion
--insertKangiWord = "insert into kangiSystem (\
--  ks_kangiID\
-- ,ks_char\
--) values (\
--  NULL, ?\
--);"
insert into kanjiSystem values (NULL, '�R');
insert into kanjiSystem values (NULL, '�x');
insert into kanjiSystem values (NULL, '�e');
insert into kanjiSystem values (NULL, '��');
insert into kanjiSystem values (NULL, '��');
insert into kanjiSystem values (NULL, '��');
insert into kanjiSystem values (NULL, '�Z');
insert into kanjiSystem values (NULL, '��');
