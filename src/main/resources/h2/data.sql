-- [MEMBER] Default member add
insert into member (member_seq, email, name, password, phone)
values (default, 'gojgho@naver.com', '고정효', 'aabb123', '010-1234-1234');

insert into member (member_seq, email, name, password, phone)
values (default, 'woodo@naver.com', '우도', 'AA123', '010-7777-7777');

-- [BOOK] ADD TYPE = [COMPUTER ECONOMY SOCIETY LANGUAGE SCIENCE SELF COMIC NORMAL]

insert into book (book_seq, isbn, name, type)
values  (default, 9791168473690, '세이노의 가르침', 'SELF');


insert into book (book_seq, isbn, name, type)
values  (default, 9791136783134,  '주술회전 25: 인외마경 신주쿠 결전', 'COMIC');


insert into book (book_seq, isbn, name, type)
values  (default, 9788901276533, '나는 메트로폴리탄 미술관의 경비원입니다', 'NORMAL');


insert into book (book_seq, isbn, name, type)
values  (default, 9791192300818, '마흔에 읽는 쇼펜하우어', 'SELF');


insert into book (book_seq, isbn, name, type)
values  (default, 9791191777628, '내 삶을 지키는 바운더리', 'SELF');


insert into book (book_seq, isbn, name, type)
values  (default, 9788997743605, '퍼스널 MBA(10주년 기념 증보판)', 'SELF');


insert into book (book_seq, isbn, name, type)
values  (default, 9791187799252,  '공장 투자 이렇게 쉬웠어?', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791193506202, '아이는 무엇으로 자라는가', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791190227339, '항복론: 성공을 위한 내려놓기', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9788965422785, '해커스 토익 기출 VOCA(보카)', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791171251179, '나는 행복한 푸바오 할부지입니다', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9788965424772, '해커스 토익 LC Listening(리스닝) 기본서', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9788998441012, '모순', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791198621504, '발상의 회로', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791130646381, '이처럼 사소한 것들', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9788917239508, 'ETS 토익 정기시험 기출문제집', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791193506332, '무례한 친구가 생겼어요', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9788901280516, '마음 해방', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791160274455, '여행 드롭', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791193080146, '느리게 나이 드는 습관', 'SELF');

--------------------------------------------------

insert into book (book_seq, isbn, name, type)
values  (default, 9791158682798, '읽으면서 바로 써먹는 어린이 세계 여행', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791191836219, '아홉 살에 시작하는 똑똑한 초등신문', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791171252565, '웡카', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791186494967, '네모아저씨의 페이퍼 블레이드 히든카드', 'SELF');

insert into book (book_seq, isbn, name, type)
values  (default, 9791198428547, '오늘부터 초등 지식왕', 'SELF');


-- [BookEntrustHistory]
insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서1', 1700, 9991168473691, 1, 'ENTRUST', 0, current_timestamp);

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서2', 1700, 9991168473692, 1, 'ENTRUST', 0, '2024-02-28 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서3', 1400, 9991168473693, 1, 'ENTRUST', 0, '2024-02-27 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서4', 1400, 9991168473694, 1, 'ENTRUST', 0, '2024-02-26 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서5', 1500, 9991168473695, 1, 'ENTRUST', 0, '2024-02-25 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서6', 1500, 9991168473696, 1, 'ENTRUST', 0, '2024-02-24 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서7', 1500, 9991168473697, 1, 'ENTRUST', 0, '2024-02-23 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서8', 1100, 9991168473698, 1, 'ENTRUST', 0, '2024-02-22 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서9', 1200, 9991168473699, 1, 'ENTRUST', 0, '2024-02-21 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서10', 1200, 9991168473700, 1, 'ENTRUST', 0, '2024-02-20 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서11', 1900, 9991168473701, 1, 'ENTRUST', 0, '2024-02-19 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서12', 1700, 9991168473702, 1, 'ENTRUST', 0, '2024-02-18 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서13', 1500, 9991168473703, 1, 'ENTRUST', 0, '2024-02-17 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서14', 1500, 9991168473704, 1, 'ENTRUST', 0, '2024-02-16 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서15', 1500, 9991168473705, 1, 'ENTRUST', 0, '2024-02-15 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서16', 1510, 9991168473706, 1, 'ENTRUST', 0, '2024-02-14 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서17', 1310, 9991168473707, 1, 'ENTRUST', 0, '2024-02-13 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서18', 1320, 9991168473708, 1, 'ENTRUST', 0, '2024-02-12 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서19', 1200, 9991168473709, 1, 'ENTRUST', 0, '2024-02-11 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서20', 1800, 9991168473710, 1, 'ENTRUST', 0, '2024-02-09 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서21', 1700, 9991168473711, 1, 'ENTRUST', 0, '2024-02-08 19:00:05.223879');

insert into book_entrust_history (book_entrust_seq, book_name, entrust_price, isbn, member_member_seq, status, rental_count, registration_date)
values (default, '테스트용 도서22', 1600, 9991168473712, 1, 'ENTRUST', 0, '2024-02-07 19:00:05.223879');
