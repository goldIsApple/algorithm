package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int max = 1;
		for (int i = 0; i < size; i++) {
			int count = 1;
			int order = 0;// 0 초기화 1:left 2:right
			if(size-max+1==i ){
				System.out.println(max);
				return;
			}
			for (int j = i; j < size-1; j++) {
				int leftNumber = numbers[j];
				int rightNumber = numbers[j+1];

				if(leftNumber==rightNumber){
					count++;
				}else if(leftNumber<rightNumber){
					if(order==1){
						break;
					}
					order=2;
					count++;
				}else if(leftNumber>rightNumber){
					if(order==2){
						break;
					}
					order=1;
					count++;
				}

			}
			if(count>max){
				max=count;
			}
		}
		System.out.println(max);

	}
}