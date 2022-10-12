package edu.java.contact.ver06;

import java.util.List;

// CRUDE (Create(insert) / Read(select) / Update / Delete) 를 담당하는 Controller
public interface ContactDao {
    List<Contact> read(); // 연락처 전체 검색

    Contact select(Integer cid); // 연락처 테이블의 고유키로 검색

    int create(Contact contact); // insert 문장 실행

    int update(Contact contact); // update 문장 실행
    
    int delete(Integer cid); // delete 문장 실행
    

}
