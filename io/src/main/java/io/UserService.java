package io;

import java.util.Iterator;
import java.util.List;

// 시스템의 기능
public interface UserService {
	// 회원정보를 등록하다.
	public void addUser(User user);
	
	// 회원정보를 수정하다. user.getEmail()에 해당하는 회원정보를 수정한다.
	public boolean updateUSer(User user);
	
	// 회원정보를 삭제하다.
	public boolean deleteUser(String email);
	
	// 모든 회원정보를 반환하다.
	public Iterator<User> getUsers();
	
	// email에 해당하는 회원정보가 있는지 없는지 확인
	public boolean exists(String email);
}