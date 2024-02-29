WITH AVG_SCORE AS (SELECT EMP_NO, AVG(SCORE) SCORE FROM HR_GRADE
                  GROUP BY EMP_NO)
                  
SELECT A.EMP_NO, E.EMP_NAME, 
        CASE
            WHEN SCORE >= 96 THEN 'S'
            WHEN SCORE >= 90 THEN 'A'
            WHEN SCORE >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE,
        CASE
            WHEN SCORE >= 96 THEN SAL * 0.2
            WHEN SCORE >= 90 THEN SAL * 0.15
            WHEN SCORE >= 80 THEN SAL * 0.1
            ELSE 0
        END AS BONUS
FROM AVG_SCORE A
JOIN HR_EMPLOYEES E
USING (EMP_NO)
ORDER BY A.EMP_NO;