package io;

import java.util.List;

public class UserMain {

	public static void main(String[] args) {
		UserUI userUI = new UserUI();
		UserDao userDao = new UserDao("c:/tmp/users.dat");
		// List<User> users= userDao.getUsers(); // 메모리상에 User 정보를 관리한다. (등록, 수정, 삭제 기능) -> 인터페이스로 관리
		UserService userService = new UserServiceInMemory(userDao.getUsers());
		
		while(true) {
			int menuID = userUI.menu(); // 메뉴 출력되고 입력받은 메뉴 번호 읽어서 리턴
			if(menuID == 5) {
				System.out.println("종료합니다.");
				userDao.saveUser(userService.getUsers()); // list를 iterator로 변환 후 저장
				break;
			}else if(menuID == 1) {
				User user = userUI.regUser(); // 정보를 등록한 회원
				userService.addUser(user); // 메모리상에 회원 저장
				System.out.println("등록되었습니다.");
			}else if(menuID == 2) {
				userUI.printUserList(userService.getUsers());
			}else if(menuID == 3) {
				String email = userUI.inputEmeil(); // 수정할 회원의 이메일
				boolean isFindEmail = userService.exists(email); // 해당 이메일의 존재 여부
				
				if(isFindEmail) {
					User updateUser = userUI.inputUser(email); // 수정한 회원 정보
					userService.updateUSer(updateUser); // 기존 정보 지우고 수정된 정보 추가
					System.out.println("수정되었습니다.");
				}else { // 해당 이메일을 찾지 못한 경우
					System.out.println("수정할 회원 정보가 없습니다.");
				}
			}else if(menuID == 4) {
				String email = userUI.inputEmeil(); // 삭제할 회원의 이메일
				boolean isFindEmail = userService.exists(email); // 해당 이메일의 존재 여부
				
				if(isFindEmail) {
					userService.deleteUser(email); // 회원 정보 삭제
					System.out.println("삭제하였습니다.");
				}else {
					System.out.println("삭제할 회원 정보가 없습니다.");
				}
			}
		}
		
	}

}