package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// User Data Object
// 파일에서 List<User> 정보를 저장하거나 읽어오는 기능
public class UserDao {
	private String filename;
	
	public UserDao(String filename) {
		this.filename = filename;
	}
	
	// List<User> 정보를 받아서 파일에 저장
	public void saveUser(Iterator<User> iter) {
		List<User> users = new ArrayList<>();
		while(iter.hasNext()) { // 꺼낼 정보가 있는지 없는지
			User user = iter.next(); // 정보 꺼내기
			users.add(user); // 꺼낸 정보를 List에 저장
		}
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(users); // 파일에 저장
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 파일로부터 List<User> 정보 읽기
	public List<User> getUsers(){
		File file = new File(filename);
		if(!file.exists()) { // 파일이 존재하지 않으면
			return new ArrayList<>(); // 빈 ArrayList 인스턴스 만들어서 리턴
		}
		
		List<User> list = null;
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			list = (List<User>)in.readObject(); // 리스트 자체를 읽어들이기
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}