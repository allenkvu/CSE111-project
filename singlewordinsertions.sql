
--
-- Single Word Insertions
-- (excluding Japanese word weak entity set)
--

# English word insertion

insertEnglishWord = "insert into englishWord (\
  ew_wordID\
 ,ew_word\
) values (\
  NULL, %s\
);"

# Hiragana, Katakana, Romaji insertion (together)
insertKanaWord = "insert into kanaSystem (\
  kns_kanaID\
 ,kns_hiragana\
 ,kns_katakana\
 ,kns_romaji\
) values (\
 NULL, ?, ?, ?\
);"

# Kangi character insertion
insertKangiWord = "insert into kangiSystem (\
  ks_kangiID\
 ,ks_char\
) values (\
  NULL, ?\
);"



