package org.example;

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int count = 0;


		int size = String.valueOf(end).length();
		int pow = (int) Math.pow(10, size);

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i < pow; i++) {
			boolean flag = true;
			int num = i;

			while (num > 0) {
				int number = num % 10;
				if(number != 7 && number!=4){
					flag=false;
					break;
				}
				num /= 10;
			}
			if(flag){
				list.add(i);
			}
			if(i==end){
				break;
			}
		}


		for (Integer i : list) {
			if (start <= i && end >= i) {
				count++;
			}
		}
		System.out.println(count);
	}
}