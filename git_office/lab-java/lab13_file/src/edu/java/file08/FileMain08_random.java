package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain08_random {

    public static void main(String[] args) {
        // Student를 저장하는 ArrayList를 선언, 생성.
        // ArrayList에 Student 객체 5개를 저장.
        // ArrayList를 파일에 write.
        
        ArrayList<Student> students = new ArrayList<>();
        Random random = new Random();
        String file = "data/student_list.dat";
        
        for (int i =0; i<5; i++) {
//            Score score = new Score(random.nextInt(101) , random.nextInt(101) , random.nextInt(101));
            Student stu = new Student(i,"학생"+i, new Score(random.nextInt(101) , random.nextInt(101) , random.nextInt(101)));
            students.add(stu);
        }
//        for (Student s : students) {
//            System.out.println(s);
//        }
        
        try (FileOutputStream out = new FileOutputStream(file);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
                ) { 
            long start = System.currentTimeMillis();
            oout.writeObject(students);
            long end = System.currentTimeMillis();
            System.out.println("write " + (end-start) + "ms");
            
        } catch (Exception e ) {
            e.printStackTrace();
        }
        
        
        
        // 파일에서 ArrayList 객체를 read.
        // ArrayList의 원소들을 한 줄씩 출력.
        try (FileInputStream in = new FileInputStream("data/student_list.dat");
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);
                ){
            long start = System.currentTimeMillis();
            
//            Object obj =oin.readObject();
            ArrayList<Student> list = (ArrayList<Student>) oin.readObject();
            long end = System.currentTimeMillis();
            System.out.println("read "+ (end-start) + "ms");
            
//            if (obj instanceof Student) {
//                Student s = (Student) obj;
//                System.out.println(s);
//            }
            for (Student s : list ) {
                System.out.println(s);
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }

    }

}