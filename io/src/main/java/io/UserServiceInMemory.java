package io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 메모리상에 User 정보를 관리하는 클래스
public class UserServiceInMemory implements UserService{
	private List<User> users; // user 정보를 가지는 자료구조
	
	public UserServiceInMemory() {
		this.users = new ArrayList<>();
	}
	
	public UserServiceInMemory(List<User> users) {
		this.users = users;
	}
	
	// 회원 정보 등록
	@Override
	public void addUser(User user) {
		users.add(user); // 받아들인 user를 메모리상에 저장
	}

	// 수정할 회원의 메일을 받아서 해당 회원 정보 삭제 후 저장
	// 입력받은 메일이 있을 수도 있고, 없을 수도 있으므로
	// 삭제를 성공했으면 true, 실패했으면 false 리턴 -> boolean
	@Override
	public boolean updateUSer(User user) {
		boolean deleteFlag = deleteUser(user.getEmail());
		if(deleteFlag) { // 해당 회원 정보 삭제했다면
			users.add(user); // 수정된 회원 정보 저장
			return true;
		}else {
			return false;
		}
	}

	// 삭제할 회원의 메일을 받아서 해당 회원 정보 삭제
	// 입력받은 메일이 있을 수도 있고, 없을 수도 있으므로
	// 해당 이메일이 있으면 true, 없으면 false 리턴 -> boolean
	@Override
	public boolean deleteUser(String email) {
		int findIndex = findIndex(email);

		if(findIndex > -1) { // 리스트에 해당 메일이 있으면
			users.remove(findIndex); // 해당 회원 정보 삭제
			return true;
		}else {
			return false;
		}
	}

	// 필드 users 정보를 그대로 리턴할 것이냐? -> 외부에서 리스트를 조작(삭제, 수정)할 수 있음
	// users 정보를 복사한 후 리턴할 것이냐? -> 복사한 걸 리턴하고 삭제하면, 삭제한 정보도 나올 수 있음 
	// 따라서 users 정보를 읽기 전용으로 리턴 -> List가 아닌 읽어들이기 전용인 인터페이스 iterator 사용
	@Override
	public Iterator<User> getUsers() {
		return users.iterator();
	}

	// 해당 메일을 가진 회원이 있는지 없는지 확인
	@Override
	public boolean exists(String email) {
		if(findIndex(email) >= 0)
			return true;
		else // findIndex = -1
			return false;
	}
	
	// 해당 메일을 가진 회원의 인덱스 찾기
	private int findIndex(String email) {
		int findIndex = -1;
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(email)) {
				findIndex = i;
				break;
			}
		}
		return findIndex;
	}
	
}