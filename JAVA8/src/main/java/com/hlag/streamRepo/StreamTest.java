package com.hlag.streamRepo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	     public static void main(String[] args) {
			List<String> words = Arrays.asList("apple","banana","cherry","date");
			//List<String> result = new ArrayList<>();
			
//			Long startTime = System.currentTimeMillis();
//			for (String word : words) {
//				if(word.length()>5) {
//					result.add(word.toUpperCase());
//				}			
//			}
//			
//			Long endTime = System.currentTimeMillis();
//			System.out.println("Diffence : "+ (startTime- endTime) );
//			System.out.println("result : "+result);
//
//		}
//			
			List<String> result = words.stream()
					.filter(e->e.length()>5)
					.map(e->e.toUpperCase())
					.collect(Collectors.toList());
			
			result.stream().forEach(e->System.out.println(e));
			result.forEach(e->System.out.println(e));
			System.out.println(result);
				
			}
		}

