package org.example;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr =new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] eat = new int[d+1];
		int rt = 0;
		int count = 0;
		for (rt = 0; rt < k; rt++) {
			if(eat[arr[rt]]==0){
				count++;
			}
			eat[arr[rt]]++;
		}
		int max =  eat[c] ==0 ? count + 1 : count;
		int lt = 0;
		while(lt<N-1){

			if(eat[arr[lt]]>0){
				eat[arr[lt]]--;
			}
			if(eat[arr[lt]]==0){
				count--;
			}
			if(eat[arr[rt]]==0){
				count++;
			}
			eat[arr[rt]]++;

			int answer =count;
			if(eat[c] ==0){
				answer++;
			}
			max = Math.max(max,answer);
			if(max==k+1){
				break;
			}

			lt++;
			if(rt==N-1){
				rt=0;
			}else{
				rt++;
			}

		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}