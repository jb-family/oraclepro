package com.javaex.phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
	//필드
	private Scanner sc = new Scanner(System.in);
	private int personId = 0;
	private String name = null;
	private String hp = null;
	private String company = null;
	private List<PersonVo> personList = new ArrayList<PersonVo>();
	private PhoneDao phoneDao = new PhoneDao();
	
	//메소드 - 일반
	//프로그램 시작 메소드
		public void showInfo() {
			System.out.println("*****************************************");
			System.out.println("*	전화번호 관리 	프로그램		*");
			System.out.println("*****************************************");
		}

		//메뉴 입출력 메소드
		public int showMenu() {
			
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("------------------------------------------------");
			System.out.print(">메뉴번호 :");
			int num = sc.nextInt();
			return num;
		}
		
		
		//리스트 추가 메소드
		public void addList() {
			PhoneDao phoneDao = new PhoneDao();
			System.out.println("<2.등록>");
			System.out.print("이름 >");
			name = sc.next();
			System.out.print("휴대전화 >");
			hp = sc.next();
			System.out.print("회사번호 >");
			company = sc.next();
			
			PersonVo addList = new PersonVo(name, hp, company);
			phoneDao.phoneInsert(addList);
		}
		
		//리스트 수정 메소드
		public void updateList() {
			PhoneDao phoneDao = new PhoneDao();
			System.out.println("<3.수정>");
			System.out.print("번호 >");
			personId = sc.nextInt();
			System.out.print("이름 >");
			name = sc.next();
			System.out.print("휴대전화 >");
			hp = sc.next();
			System.out.print("회사번호 >");
			company = sc.next();
			
			PersonVo updateList = new PersonVo(name, hp, company, personId);
			phoneDao.phoneUpdate(updateList);
			
		}
		
		//리스트 삭제 메소드
		public void deleteList() {
			PhoneDao phoneDao = new PhoneDao();
			System.out.println("<4.삭제>");
			System.out.print(">번호 :");
			personId = sc.nextInt();
			
			PersonVo deleteList = new PersonVo(personId);
			phoneDao.phoneDelete(deleteList);
		}
		
		//리스트 검색 메소드
		public void searchList() {
			System.out.println("<5.검색>");
			System.out.print("검색어 >");
			String search = sc.next();
			printList(search);
		} 
		
		
		//리스트 출력 메소드 (오버로딩)
		public void printList() {
			printList("");
		}
		
		//리스트 출력 메소드
		public void printList(String key) {
			personList = phoneDao.phoneSelect();
			for(int i = 0; i < personList.size(); i++) {
				int personId = personList.get(i).getPersonId();
				name = personList.get(i).getName();
				hp = personList.get(i).getHp();
				company = personList.get(i).getCompany();
				if(name.contains(key) || hp.contains(key) || company.contains(key)) {
					System.out.println(personId + "." + "  " + name + "  " + hp + "  " + company);
				}
			}
		}
	
	
}
