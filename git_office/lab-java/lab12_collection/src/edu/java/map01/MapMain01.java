package edu.java.map01;

import java.util.HashMap;
import java.util.Set;

/* 
 * Collection<E>
 * |__ List<E> , Set<E>
 * List<E> , Set<E> 의 공통점: 한가지 타입(Integer, String, ...)의 객체를 여러개 저장할 수 있는 자료 타입. 
 * List<E>: 인덱스가 있음. 저장하는 순서가 중요. 중복된 값들을 저장할 수 있음.
 * Set<E>: 인덱스가 없음. 저장순서 중요하지않음. 중복된 값들을 저장할 수 없음.
 * 
 * ArrayList<E> : get 속도 빠름. add/remove 속도 느림.
 * LinkedList<E>: add/remove 속도 빠름. get 속도 느림.
 * 
 * HashSet<E>: 검색을 빨리 하기위한 set.
 * TreeSet<E>: 정렬을 빨리 하기위한 set.
 * 
 * Map<K, V>
 * |__ HashMap<K, V> , TreeMap<K, V>
 * Map<K, V>: Key(키)와 Value(값)의 쌍으로 구성된 데이터를 저장하는 자료구조.
 * 1) Key: 중복된 값을 가질 수 없음. 리스트의 인덱스와 비슷한 역할.
 *         데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도. 
 * 2) Value: 중복된 값을 가질 수 있음. 
 * 3) HashMap<K, V>: 검색을 빨리 하기 위한 map
 * 4) TreeMap<K, V>: 정렬을 빨리 하기 위한 map
 */

public class MapMain01 {

    public static void main(String[] args) {
        // 정수를 key. 문자열을 value로 하는 HashMap을 선언, 생성
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map);

        // put(K V): Map(K, V)에 key-value 쌍의 데이터를 저장
        map.put(1, "홍길동");
        System.out.println(map);

        map.put(10, "오쌤");
        System.out.println(map);

        map.put(5, "hong");
        System.out.println(map);

        // get(k) :key 에 해당하는 value 를 리턴 만약 key가 존재하지 않으면 null을 리턴.
        System.out.println(map.get(1));
        System.out.println(map.get(5));

        System.out.println();
        // getOrDefault(K,V): 검색할 key가 존재하지 않을 때 리턴할 기본 값을 argument로 전달.
        System.out.println(map.getOrDefault(1, "Unknown"));
        System.out.println(map.getOrDefault(2, "Unknown"));

        // remove(K) key에 매핑된 key-value 원소를 삭제하고, 삭제한 value(값)을 리턴
        map.remove(1);
        System.out.println(map);

        // remove() 메서드는 key에 매핑된 key-value 원소가 없으면 null을 리턴(에러가 발생하지 않음)
        map.remove(2);
        System.out.println(map);

        // put(K,V) key가 존재하지 않으면 key=value 원소를 저장.
        // key가 존자해면 해당 키의 value만 변경.
        map.put(5, "홍길동");
        System.out.println(map);

        // Map<K,V>과 반복문.
        // keySet(): Set<K>를 리턴. Map 에서 Key들로만 이루어진 Set을 리턴.
        Set<Integer> kset = map.keySet();
        System.out.println(kset);
        for (Integer k : kset) {
            String v = map.get(k);
            System.out.println(k + " - " + v);
        }

    }

}
