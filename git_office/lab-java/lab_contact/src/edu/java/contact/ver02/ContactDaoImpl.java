package edu.java.contact.ver02;

//MVC 아키텍쳐에서 Controller (구현)클래스
public class ContactDaoImpl implements ContactDao {
    public static final int MAX_LENGTH = 3;

    private Contact[] contactList = new Contact[MAX_LENGTH];
    private int count = 0;

    public int getCount() {
        return count;
    }

    // singleton 
    //
    private static ContactDaoImpl instance = null;

    private ContactDaoImpl() {
    }

    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }

    @Override
    public Contact[] select() { 
        //contactList 에 저장된 Contact 객체의 개수만큼 크기의 배열을 새로 생성.
        Contact[] contacts = new Contact[count];
        for (int i = 0; i < count; i++) {
            contacts[i] = contactList[i];
        }
        return contacts;
    }

    @Override
    public Contact select(int index) {
        if (index >= 0 && index < MAX_LENGTH) {
            return contactList[index];
        } else {
            return null;
        }
    }

    @Override
    public int create(Contact c) {
        if (count >= MAX_LENGTH) { // 배열에 저장할 공간이 부족할때
            return 0;
        }
        contactList[count] = c;
        count++;
        return 1;
    }

    @Override
    public int update(int index, String name, String phone, String email) {
        if (index >= 0 && index < count) {
            contactList[index].setName(name);
            contactList[index].setPhone(phone);
            contactList[index].setEmail(email);
            return 1;
        } else {
            return 0;
        }
    }
    
    
}
