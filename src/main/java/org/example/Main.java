package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] date1 = br.readLine().split(" ");
		String[] date2 = br.readLine().split(" ");
		int year1 = Integer.parseInt(date1[0]);
		int month1 =Integer.parseInt( date1[1]);
		int day1 = Integer.parseInt(date1[2]);

		int year2 = Integer.parseInt(date2[0]);
		int month2 = Integer.parseInt(date2[1]);
		int day2 = Integer.parseInt(date2[2]);

		final int[] days = {365,31,28,31,30,31,30,31,31,30,31,30,31};

		if(year2-year1 ==1000){
			if(month2 >month1){
				System.out.println("gg");
				return;
			}
			if(month2==month1 && day1<=day2){
				System.out.println("gg");
				return;
			}
		}
		if(year2 -year1 >1000){
			System.out.println("gg");
			return;
		}

		int answer = 0;
		if(year1==year2){
			answer= getDays(year1,month1,day1,month2,day2,days);
			System.out.println("D-"+answer);
			return;
		}
		int days1 = getDays(year1, month1, day1, 12, 31, days);
		int days2 = getDays(year2, 1, 1, month2, day2, days);

		year1++;
		int sum = 1;
		while(year1<year2){
			if(isLeapYear(year1)){
				sum = sum + days[0] + 1;
			}else {
				sum = sum + days[0];
			}
			year1++;
		}
		int an = days1 + days2 + sum;
		System.out.println("D-"+an);

	}

	private static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			return true;
		}
		return false;
	}

	private static int getDays(int year1, int month1, int day1, int month2, int day2, int[] days) {
		boolean leapYear = isLeapYear(year1);
		int sum = 0;
		for (int i = month1; i <=month2 ; i++) {
			int day =days[i];
			if(i==2){
				if(leapYear){
					day++;
				}
			}
			if(month1==month2){
				sum =sum+ day2-day1;
			} else if(i==month1){
				sum=sum + (day-day1);
			}else if(i==month2){
				sum=sum + day2;
			}else{
				sum=sum+day;
			}
		}
		return sum;
	}
}