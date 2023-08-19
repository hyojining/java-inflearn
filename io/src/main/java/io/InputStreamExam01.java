package io;

import java.io.IOException;
import java.io.InputStream;

/*
 1byte가 표현할 수 있는 값 : 00000000 ~ 11111111
 read()메소드가 읽어들일 수 있는 정보. 00000000 ~ 11111111 중에 한개
 1byte씩 파일 읽어들인다. 100byte
 1byte씩 읽어들이는데 파일의 크기를 모르면? 더 이상 읽어들일 것이 없을 때까지 읽어들임(EOF)
 int에 1byte값을 담자. 00000000 00000000 00000000 00000000
                   00000000 00000000 00000000 11111111
 EOF : -1
 1 --> 00000000 00000000 00000000 00000001
 1의보수 11111111 11111111 11111111 11111110
 2의보수 11111111 11111111 11111111 11111111 : -1
 */

public class InputStreamExam01 {

	public static void main(String[] args) {
		InputStream in = null;
		
		try {
			// byte단위로 읽어들이는 read 메소드가 왜 int로 return하는가? 
			// EOF를 표현할 수 있는 방법이 없어서
			// byte 단위를 벗어나는 값이 필요해서
			int data = in.read();
		}catch(IOException ex) {
			System.out.println(ex);
		}finally {
			try {
				in.close();
			}catch(Exception ex2) {
				System.out.println(ex2);
			}
		}
	}

}
