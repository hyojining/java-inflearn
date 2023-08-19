package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

// 정보 입출력 클래스 (User Interface와 관련된 것들)
public class UserUI {
	private BufferedReader br;
	
	public UserUI() {
		// 키보드로부터 입력받을 수 있는 BufferedReader 선언
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// 메뉴를 화면에 출력하고 사용자로부터 입력받은 메뉴 번호를 읽어서 반환
	public int menu() {
		System.out.println("1. 회원 등록");
		System.out.println("2. 회원 목록 보기");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 정보 삭제");
		System.out.println("5. 종료");

		int menuID = -1;
		try{
			String line = br.readLine(); // 한 줄 입력받기 (문자열)
			menuID = Integer.parseInt(line); // 문자열을 정수로 변환
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return menuID;
	}
	
	// 회원 등록을 위한 사용자 정보를 입력받아 User 정보 리턴 (User 객체로 리턴)
	public User regUser() {
		try{
			System.out.println("email을 입력하세요.");
			String email = br.readLine();
			
			System.out.println("이름을 입력하세요.");
			String name = br.readLine();
			
			System.out.println("생년을 입력하세요.");
			String strBirthYear = br.readLine();
			int birthYear = Integer.parseInt(strBirthYear);
			
			User user = new User(email, name, birthYear); // 입력받은 정보로 User 인스턴스 생성
			return user;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	// User 목록을 화면에 출력
	public void printUserList(Iterator<User> iter) {
		System.out.println("email        이름        생년");
		System.out.println("==========================");
		while(iter.hasNext()) {
			User user = iter.next();
			
			System.out.print(user.getEmail());
			System.out.print("    ");
			System.out.print(user.getName());
			System.out.print("    ");
			System.out.print(user.getBirthYear());
			System.out.println();
		}
	}
	
	// 수정할 회원의 이메일을 입력받아 리턴
	public String inputEmeil() {
		System.out.println("수정할 회원의 email을 입력하세요.");
		String email = "";
		try{
			email = br.readLine();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return email;
	}
	
	// 수정할 회원의 이메일을 받아 회원 정보를 수정하여 User 객체 생성하고 리턴
	public User inputUser(String email) {
		try{
			System.out.println(email + " 회원의 정보를 수정합니다.");
			
			System.out.println("이름을 입력하세요.");
			String name = br.readLine();
			
			System.out.println("생년을 입력하세요.");
			String strBirthYear = br.readLine();
			int birthYear = Integer.parseInt(strBirthYear);
			
			User user = new User(email, name, birthYear);
			return user;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}