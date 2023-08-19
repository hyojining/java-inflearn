package io;

import java.io.File;

public class FileList {

	public static void main(String[] args) {
		File file = new File("C:/tmp");
		
		if(file.isDirectory()) { // 디렉토리일 경우
			File[] files = file.listFiles(); // 폴더에 있는 파일 배열 리턴
			for(int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		}else {
			System.out.println(file.getName());
		}
		
	}

}
