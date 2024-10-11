WITH FECODE AS(SELECT SUM(CODE) AS FECODE FROM SKILLCODES WHERE CATEGORY = 'Front End'), 
    PYCODE AS(SELECT CODE AS PYCODE FROM SKILLCODES WHERE NAME = 'Python'), 
    CSCODE AS(SELECT CODE AS CSCODE FROM SKILLCODES WHERE NAME = 'C#'), 
    GRDEVS AS(
        SELECT
        CASE
            WHEN (SKILL_CODE & FECODE) AND (SKILL_CODE & PYCODE) THEN 'A'
            WHEN SKILL_CODE & CSCODE THEN 'B'
            WHEN SKILL_CODE & FECODE THEN 'C'
        END AS GRADE, ID, EMAIL
        FROM DEVELOPERS, FECODE, PYCODE, CSCODE)
        
SELECT * FROM GRDEVS WHERE GRADE IS NOT NULL ORDER BY GRADE ASC, ID ASC