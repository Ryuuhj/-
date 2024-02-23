WITH D AS (SELECT DR_NAME, DR_ID FROM DOCTOR WHERE MCDP_CD = 'CS')

SELECT APNT_NO, PT_NAME, A.PT_NO, MCDP_CD, D.DR_NAME, APNT_YMD
FROM APPOINTMENT A
LEFT JOIN D ON A.MDDR_ID = D.DR_ID
LEFT JOIN PATIENT P USING (PT_NO)
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = '2022-04-13' 
    AND APNT_CNCL_YN = 'N'
ORDER BY APNT_YMD;