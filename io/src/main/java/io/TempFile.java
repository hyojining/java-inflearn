package io;

import java.io.File;
import java.io.IOException;

public class TempFile {

	public static void main(String[] args) {
		try {
			File f = File.createTempFile("tmp_", ".dat"); // tmp_로 시작하고 .dat로 끝나는 임시 파일 생성 
			System.out.println(f.getAbsolutePath());
			System.out.println("60초 동안 멈춰있습니다.");
			try {
				// 1000ms = 1초
				Thread.sleep(60000);
			}catch(InterruptedException e1) {
				System.out.println(e1);
			}
			f.deleteOnExit(); // JVM이 종료될 때 임시 파일을 자동으로 삭제
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
