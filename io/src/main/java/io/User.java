package io;

import java.io.Serializable; // 메소드가 하나도 없는 interface => 마크 인터페이스

public class User implements Serializable{
	// 필드들도 다 직렬화 가능
	private String email;
	private String name;
	private int birthYear;
	
	public User(String email, String name,int birthYear) {
		this.email = email;
		this.name = name;
		this.birthYear = birthYear;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", birthYear=" + birthYear + "]";
	}
	
	
}