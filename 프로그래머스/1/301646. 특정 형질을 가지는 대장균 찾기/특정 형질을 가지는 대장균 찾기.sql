SELECT COUNT(ID) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0       -- 2번 형질을 보유하지 않음
  AND (GENOTYPE & 5) > 0;      -- 1번(1) 혹은 3번(4) 형질을 보유함 (1 | 4 = 5)