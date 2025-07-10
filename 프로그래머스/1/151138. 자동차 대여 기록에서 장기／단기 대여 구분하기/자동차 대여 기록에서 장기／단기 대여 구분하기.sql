-- 코드를 입력하세요
SELECT 
    HISTORY_ID
    , CAR_ID
    , DATE_FORMAT(START_DATE,'%Y-%m-%d') START_DATE
    , DATE_FORMAT(END_DATE,'%Y-%m-%d') END_DATE
    , if(TIMESTAMPDIFF(DAY, start_date, end_date) + 1 >= 30, '장기 대여', '단기 대여') as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where start_date between '2022-09-01' and '2022-09-30'
order by history_id desc
 