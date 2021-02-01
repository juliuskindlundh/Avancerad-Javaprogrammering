package inlupp2_juliuskindlundh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class inlupp2_juliusKindlundh {

	public static void main(String[] args) throws FileNotFoundException {
		
		File f = new File("D:\\regex.txt");
		Scanner sc = new Scanner(f);
		
		String s1 = "(?i)abcdefghijklmnopqrstuvxyz";
		String s2 = "Ola";
		String s3 = "[A-Za-z0-9]";
		String s4 = "[A-Z|a-z|0-9|.|_|%]+[@][A-Z|a-z|-|.|_]+[.][A-Z|a-z]{2,3}";
		String s5 = "[0-9]{8,8}|[0-9]{3,3}[/][0-9]{6,6}|[0-9]{3,3}[-][0-9]{6,6}";
		String s6 = "([A-Z|a-z])\\1{3}";
		String s7 = "[a-z]{3}[/|_][0-9]{3}";
		String s8 = "[(][a-z|A-Z|0-9| ]*[)]";
		String s9 = "(if|for)[(].+?(?=[)])[)][{].+?(?=[}])[}]";
		String s10 = "[A|a]{3,5}";
		
		Pattern p1 = Pattern.compile(s1);
		Pattern p2 = Pattern.compile(s2);
		Pattern p3 = Pattern.compile(s3);
		Pattern p4 = Pattern.compile(s4);
		Pattern p5 = Pattern.compile(s5);
		Pattern p6 = Pattern.compile(s6);
		Pattern p7 = Pattern.compile(s7);
		Pattern p8 = Pattern.compile(s8);
		Pattern p9 = Pattern.compile(s9);
		Pattern p10 = Pattern.compile(s10);
		
		int cnt = 1;
		int alphabet = -1;
		int[] ola = new int[10];
		int olacnt = 0;
		int a = 0;
		int upg4 = 0;
		int pncnt = 0;
		int four = 0;
		int[] reg = new int[10];
		int regcnt = 0;
		int[] forif = new int[10];
		int forifcnt = 0;
		while(sc.hasNextLine()) {
			String temp = sc.nextLine();
			Matcher m1 = p1.matcher(temp);
			Matcher m2 = p2.matcher(temp);
			Matcher m3 = p3.matcher(temp);
			Matcher m4 = p4.matcher(temp);
			Matcher m5 = p5.matcher(temp);
			Matcher m6 = p6.matcher(temp);
			Matcher m7 = p7.matcher(temp);
			Matcher m8 = p8.matcher(temp);
			Matcher m9 = p9.matcher(temp);
			Matcher m10 = p10.matcher(temp);
			
			if(m1.find()) {
				alphabet = cnt;
			}				
			if(m2.find()) {
				ola[olacnt] = cnt;
				olacnt++;
			}
			if(!m3.find()) {
				upg4++;
			}
			if(m4.find()) {
				System.out.println("Email address: "+m4.toString().substring(m4.toString().lastIndexOf("=")+1,m4.toString().length()-1) + "on line: "+cnt);
			}
			if(m5.find()) {
				System.out.println("Phone number: "+m5.toString().substring(m5.toString().lastIndexOf("=")+1,m5.toString().length()-1) + " on line: "+cnt);
				pncnt++;
			}
			if(m6.find()) {
				four++;
			}
			if(m7.find()) {
				reg[regcnt] = cnt;
				regcnt++;
			}
			if(m8.find()) {
				System.out.println("Closed parentheses: "+m8.toString().substring(m8.toString().lastIndexOf("=")+1,m8.toString().length()-1) + " on line: "+cnt);
			}
			if(m9.find()) {
				forif[forifcnt] = cnt;
				forifcnt++;
			}
			if(m10.find()) {
				a++;
			}
			cnt++;
		}
		
		System.out.println("************************\nAlphabet on line: "+alphabet);
		System.out.print("Ola on lines: ");
		for(int i = 0; i < olacnt;i++) {
			System.out.print(" "+ola[i]);
		}		
		System.out.println("\nNumber of places with 3-5 concecutive 'a's: "+a);
		System.out.println("Number of strings not containing [A-Za-z0-9]: " + upg4);
		System.out.println("Number of phone numbers: "+ pncnt);
		System.out.println("number of places with four of the same letters after each other: "+four);

		System.out.print("Reg-nr on lines: ");
		for(int i = 0; i < regcnt;i++) {
			System.out.print(" "+reg[i]);
		}
		
		System.out.print("\nfor/if on lines: ");
		for(int i = 0; i < forifcnt;i++) {
			System.out.print(" "+forif[i]);
		}	

	}

}
