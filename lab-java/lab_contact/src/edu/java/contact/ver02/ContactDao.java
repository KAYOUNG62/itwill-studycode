package edu.java.contact.ver02;

//MVC 아키텍쳐에서 Controller의 인터페이스 - 메서드 선언 
public interface ContactDao {
    //리턴타입, 이름, 파라미터 재정의
    //기능 전체검색, 인덱스검색, 생성, 수정 재정의
    
    /**
     * 전체 목록 검색 기능.
     * @return 연락처 저장 배열 
     */
    Contact[] select();
    
    /**
     * 인덱스에 저장된 연락처 검색 
     * @param index 연락처 검색 인덱스
     * @return 배열의 index 위치에 null 이 아닌 Member 객체가 있으면 그 객체를 리턴
     */
    Contact select(int index);
    
    /**
     * 신규 연락처 등록
     * @param c 신규연락처
     * @return 배열에 새로운 회원 저장이 성공하면 1, 그렇지 않으면 0을 리턴.
     */
    int create(Contact c);
    
    /**
     * 회원정보 수정 기능
     * @param index
     * @param name
     * @param phone
     * @param email
     * @return 수정 성공하면 1, 그렇지않으면 0을 리턴
     */
    int update(int index, String name, String phone, String email);
    
    
}
