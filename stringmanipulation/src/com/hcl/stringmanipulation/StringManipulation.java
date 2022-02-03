/*
 * 1. Given string made up of name separated by _ replace _ with " ".
 * 2. Given string made up of name separated by :, tokenize and print
 * 		each part.
 * 3. Given data in format day/month/year put each into separate variables
 * 4. Given string made up of name append two data items to the end.
 */

package com.hcl.stringmanipulation;

import java.util.StringTokenizer;

public class StringManipulation {

	public static void main(String[] args) {
		// part 1:
		String name = "FirstName_MiddleName_LastName";
		StringBuffer sb = new StringBuffer();
		String[] namearr = name.split("_");

		for(String x: namearr) {
			sb.append(x);
			sb.append(" ");
		}
		System.out.println(sb);
		
		// part 2:
		String name2 = "FIRSTNAME:MIDDLENAME:LASTNAME";
		StringTokenizer st = new StringTokenizer(name2,":");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		};
		
		// part 3:
		String date = "03/02/2022";
		String[] datearr = date.split("/");
		String[] dateformat = {"Day: ", "Month: ", "Year: "};
		
		for(int i = 0; i<datearr.length; i++) {
			System.out.println(dateformat[i] + datearr[i]);
		}
		
		// part 4:
		String otherData = "qualification";
		sb.append(date + " ");
		sb.append(otherData);
		System.out.println(sb);
		

	}

}
