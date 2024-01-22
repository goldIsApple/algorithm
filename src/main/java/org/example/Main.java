package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];

		if(M==1){
			System.out.println(0);
			return;
		}
		arr[0]=1;
		int cnt = 0;
		int position = 0;
		while(true){
			cnt++;
			if(arr[position] % 2==0){ //짝수
				position = position - L;
				if(position <=-1){
					position = N +position;
				}
			}else{ // 홀수
				position = position + L;
				if(position >= N){
					position = position -N;
				}
			}
			arr[position]++;
			if(arr[position] == M){
				break;
			}
		}
		System.out.println(cnt);

	}
}