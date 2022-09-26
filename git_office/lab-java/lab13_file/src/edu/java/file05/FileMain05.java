package edu.java.file05;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * try-with-resource 문장 
 * 
 * FileInputStream, FileOutputStream 과 같은 클래스의 객체를 생성하고 사용한 후에는,
 * 반드시 그 객에츼 close() 메서드를 호출해서 리소스를 해제해야함.
 * 기존의 try-catch-finally 문장을 사용하게되면, 생성자 호출(객체생성)은 try 블록에서 작성,
 * 리소스 해제(close 호출)는 finally 블록에서 작성하게됨.
 * close 메서드를 자동으로 호출하는 try-with-resource 문장이 생기게됨.
 * 
 * try (리소스 생성;) {
 *      정상적인 경우에 실행할 문장들;
 *  } catch (예외클래스 변수 선언) {
 *      예외 상황일때 실행할 문장들;
 *  } 
 * 
 * try {
 *      리소스 생성;
 *      실행 코드;
 *  } catch (예외클래스 변수 선언){ 
 *      예외 상황 코드;
 *  } finally {
 *      try {
 *          리소스 해제;
 *      } catch () {
 *      }
 *  }
 */

public class FileMain05 {

    public static void main(String[] args) {
        // data/test.txt. 파일을 test_copy3.txt 로 복사

        try (FileInputStream in = new FileInputStream("data/test.txt");
                FileOutputStream out = new FileOutputStream("data/test_copy3.txt");) { // try 안에서만 사용할 수 있는 변수들
            while (true) {
                int read = in.read();
                if (read == -1) {
                    break;
                }
                out.write(read);
            }
            System.out.println("파일 복사 종료");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
