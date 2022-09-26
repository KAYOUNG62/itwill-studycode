
package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.java.file06.Product;

public class FileMain07 {

    public static void main(String[] args) {
        // edu.java.file06.Product 타입의 객체를 1,000,000개 생성(for). ArrayList에 저장.
        // ArrayList의 내용을 product_list.dat 파일에 write - 시간 측정
        // product_list.dat 파일에서 데이터를 읽어서 ArrayList 타입으로 변환 - 시간 측정.

        // write
        ArrayList<Product> productList = new ArrayList<>(); // products , productList등의 변수 이름 사용이 관습
        for (int i = 0; i < 1_000_000; i++) { // , 사용 불가능 _ 로 대체.
//            Product p = new Product(i, null, 1000);
            productList.add(new Product(i, "sin_" +i, 1000));
        }
        System.out.println("List size : " + productList.size());
        
        String productName = "data/product_list.dat";
        try (FileOutputStream out = new FileOutputStream(productName);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);) {

            long startTime = System.currentTimeMillis();
            oout.writeObject(productList);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("write " + elapsedTime + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // read
        try (FileInputStream in = new FileInputStream(productName);
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);) {

            long startTime = System.currentTimeMillis();
            
//            Object obj = oin.readObject();
            ArrayList<Product> list = (ArrayList<Product>) oin.readObject(); 

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("read " + elapsedTime + "ms");
//            if (obj instanceof Product) {
//                Product p = (Product) obj;
//                System.out.println(p);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
