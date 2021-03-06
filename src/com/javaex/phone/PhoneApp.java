package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Person person = new Person();
		
		/*
		PersonVo pVo1 = new PersonVo("이효리","010-1111-1111","02-1111-1111");
		PersonVo pVo2 = new PersonVo("정우성","010-2222-2222","02-2222-2222");
		PersonVo pVo3 = new PersonVo("유재석","010-3333-3333","02-3333-3333");
		PersonVo pVo4 = new PersonVo("이정재","010-4444-4444","02-4444-4444");
		PersonVo pVo5 = new PersonVo("서장훈","010-5555-5555","02-5555-5555");
		PersonVo pVo6 = new PersonVo("임창정","010-5555-6666","02-5555-5555");
		
		phoneDao.phoneInsert(pVo1);
		phoneDao.phoneInsert(pVo2);
		phoneDao.phoneInsert(pVo3);
		phoneDao.phoneInsert(pVo4);
		phoneDao.phoneInsert(pVo5);
		phoneDao.phoneInsert(pVo6);
		
		
		PersonVo uVo1 = new PersonVo("임창정", "010-6666-6666", "02-6666-6666", 6);
		phoneDao.phoneUpdate(uVo1);
		
		PersonVo dvo1 = new PersonVo(6);
		phoneDao.phoneDelete(dvo1);
		*/
		
		
		
		person.showInfo();//프로그램 시작
		
		while(run) {
			int num = person.showMenu();//매뉴정보 출력 
						
			
			if(num == 1) {//리스트 불러오기
				person.printList();
			}else if(num == 2) {//리스트 추가
				person.addList();
			}else if(num == 3) {//리스트 수정
				person.updateList();
			}else if(num == 4) {//리스트 삭제
				person.deleteList();
			}else if(num == 5) {//리스트 검색
				person.searchList();
			}else if(num == 6) {//프로그램 종료
				System.out.println("종료되었습니다.");	
				run = false;
			}else {
				System.out.println("잘못입력하셨습니다.");
			}//if문 끝
			
			
		}//while문 끝
		
		
		sc.close();//스캐너 끝
		
		
		
	}

}
