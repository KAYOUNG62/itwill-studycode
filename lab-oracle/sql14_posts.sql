SELECT * from posts;

INSERT INTO posts(title, content, author, created_time, modified_time) 
    VALUES ('test','테스트','admin',sysdate, sysdate);

commit;

delete from POSTS where id = 26;