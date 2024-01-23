package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		StringTokenizer st4 = new StringTokenizer(br.readLine());
		StringTokenizer st5 = new StringTokenizer(br.readLine());

		List<String> colors = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();

		colors.add(st1.nextToken());
		colors.add(st2.nextToken());
		colors.add(st3.nextToken());
		colors.add(st4.nextToken());
		colors.add(st5.nextToken());

		numbers.add(Integer.parseInt(st1.nextToken()));
		numbers.add(Integer.parseInt(st2.nextToken()));
		numbers.add(Integer.parseInt(st3.nextToken()));
		numbers.add(Integer.parseInt(st4.nextToken()));
		numbers.add(Integer.parseInt(st5.nextToken()));


		numbers= numbers.stream().sorted().collect(Collectors.toList());
		Set<String> setColors = new HashSet<>(colors);
		Set<Integer> setNumbers =new HashSet<>(numbers);
		int answer = 0;
		
		//연속적인 수
		boolean isContinue = true;
		for (int i = 0; i <numbers.size()-1; i++) {
			if (numbers.get(i) + 1 != numbers.get(i + 1)) {
				isContinue = false;
				break;
			}
		}

		boolean isFront = numbers.get(0) == numbers.get(3);
		boolean isBack = numbers.get(1) == numbers.get(4);
		boolean isFront2 = numbers.get(0) == numbers.get(2);
		boolean isBack2 = numbers.get(2) == numbers.get(4);
		boolean isBetween2 = numbers.get(1)==numbers.get(3);

		boolean isFront3 = numbers.get(0) == numbers.get(1);
		boolean isBetween3 = numbers.get(1) == numbers.get(2);
		boolean isBewtweenn3 = numbers.get(2) == numbers.get(3);
		boolean isBack3 = numbers.get(3) == numbers.get(4);

		if(setColors.size()==1 && isContinue){ // case1.5장 같은색, 연속적인 숫자.
			answer = 900+ numbers.get(4);
		}else if(setNumbers.size() ==2 && (isFront || isBack)){
			if(isFront){
				answer = 800 + numbers.get(0);
			}else{
				answer = 800 + numbers.get(1);
			}
		}else if(setNumbers.size() ==2 && (isFront2 || isBack2)){
			if(isFront2){
				int num = numbers.get(0) * 10;
				answer = 700 + num+numbers.get(3);
			}else{
				int num = numbers.get(4) * 10;
				answer = 700 + num+numbers.get(0);
			}
		}else if(setColors.size()==1){
			answer = 600+numbers.get(4);
		}else if(isContinue){
			answer = 500+numbers.get(4);
		}else if(setNumbers.size() ==3 && (isFront2 || isBack2 || isBetween2)){
			if(isFront2){
				answer = 400 + numbers.get(0);
			}else if (isBack2){
				answer = 400 + numbers.get(4);
			}else{
				answer = 400+numbers.get(1);
			}
		}else if(setNumbers.size()==3 && (isFront3 || isBack3 || isBetween3) ){
			if(isBetween3 && isBack3){
				int num = numbers.get(4) * 10;
				answer = 300 + num+numbers.get(1);
			}else if (isFront3 && isBack3){
				int num = numbers.get(4) * 10;
				answer = 300 + num+numbers.get(0);
			}else{
				int num = numbers.get(3) * 10;
				answer = 300 + num+numbers.get(0);
			}
		}else if(isFront3 || isBack3 || isBetween3 || isBewtweenn3){
			if(isFront3){
				answer = 200 + numbers.get(0);
			}else if (isBetween3){
				answer = 200 + numbers.get(1);
			}else if (isBewtweenn3){
				answer = 200+numbers.get(2);
			}else{
				answer = 200+numbers.get(3);
			}
		}else{
			answer =  100+ numbers.get(4);
		}
		System.out.println(answer);
	}
}