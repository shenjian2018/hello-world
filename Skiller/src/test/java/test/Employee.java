package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Employee {

	String name;
	String age;

	public String toString() {
		return this.name;

	}

	public boolean equals(Object obj) {
		return obj.equals(this.name);
	}

	void daSth(Employee[] emps) {
		int idx = 0;
		for (;;) {
			idx++;
			if (emps[idx].equals("张三")) {
				System.out.println("OK");
			}
		}

	}

	public static void main(String[] args) {
		Employee  fst=new Employee();
		fst.name="zhangsan";
		Employee  fnd=fst;
		
		HashMap   map=new HashMap<>();
		map.put("first", fst);
		map.put("second", fnd);
		Set<String> se= map.entrySet();
		
		HashSet set=new HashSet();
		set.add(fst);
		set.add(fnd);
		fst=null;
		System.out.println(map.size());
		System.out.println(set.size());
		System.out.println(map.get("second"));
		System.out.println(map.values().size());
		
		Map<String,String>  data=new HashMap<String,String>();
		Set<Entry<String, String>>  entry=  data.entrySet();
		for (Entry<String, String> entry1 : entry) {
			System.out.println(entry1.getKey()+":"+entry1.getValue());
		}
		
	}

}