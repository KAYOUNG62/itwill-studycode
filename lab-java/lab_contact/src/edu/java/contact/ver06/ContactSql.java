package edu.java.contact.ver06;

import static edu.java.contact.ver06.Contact.Entity.*;

public interface ContactSql {
    //ContactDao.read() 메서드에서 사용할 sql 문장
    String SQL_SELECT_ALL = String.format("select * from %s order by %s", 
            TBL_CONTACTS, COL_NAME );
    
    //ContactDao.read(integer cid)
    String SQL_SELECT_BY_CID = String.format("select * from %s where %s = ? ", 
            TBL_CONTACTS, COL_CID);
    
    //  create 
    String SQL_CREATE = String.format("insert into %s (%s ,%s ,%s ) values (? , ?, ?)" , 
            TBL_CONTACTS, COL_NAME , COL_PHONE, COL_EMAIL );
    
    //  update
    String SQL_UPDATE = String.format("update %s set %s = ? , %s = ?, %s = ? " , 
            TBL_CONTACTS, COL_NAME, COL_PHONE, COL_EMAIL);
    
    //  delete 
    //delete from contacts where cid = ? 
    String SQL_DELETE = String.format("delete from %s where %s = ? ", 
            TBL_CONTACTS, COL_CID );

}
