package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String[] str = new String[size];
		for (int i = 0; i < size; i++) {
			str[i] = br.readLine().replaceAll("[a-z]+", ",");
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			String[] split = str[i].split(",");
			for (int j = 0; j <split.length ; j++) {
				String s1 = split[j];
				if(s1.length()==0){
					continue;
				}
				if(s1.equals("0")){
					list.add(s1);
				}else{
					list.add(s1.replaceAll("^0+(?!$)",""));
				}
			}
		}
		list.stream()
			.sorted((a,b)->{
				if(a.length()==b.length()) {
					if(a.compareTo(b) >0){
						return 1;
					}
					return -1;
				}else if(a.length()>b.length()){
					return 1;
				}else if(a.length()<b.length()){
					return -1;
				}
				return 1;
			}).forEach(System.out::println);
	}

}