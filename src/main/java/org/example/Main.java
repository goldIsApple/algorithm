package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = {1,3,5};
		int[] b = {2, 3, 6, 7, 9};
		int ac = 0,bc = 0;
		List<Integer> data = new ArrayList<>();
		while(ac<a.length && bc<b.length){
			if(a[ac] <= b[bc]){
				data.add(a[ac]);
				ac++;
			}else if(a[ac] > b[bc]){
				data.add(b[bc]);
				bc++;
			}
		}
		while(ac<a.length){
			data.add(a[ac]);
			ac++;
		}
		while(bc<b.length){
			data.add(b[bc]);
			bc++;
		}
		System.out.println(data);
	}
}