package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class VerySimpleWebServer {

	public static void main(String[] args) throws IOException {
		// 9090 port로 대기한다.
		ServerSocket ss = new ServerSocket(9090);
		
		// 클라이언트를 대기한다.
		// 클라이언트가 접속하는 순간, 클라이언트와 통신할 수 있는 socket을 반환한다.
		// 브라우저에서 http://127.0.0.1:9090/ 입력한다.
		// 2번째는 http://127.0.0.1:9090/board/hello.html
		System.out.println("클라이언트 접속을 기다립니다.");
		// Socket은 브라우저(client)와 통신할 수 있는 객체이다.
		Socket socket = ss.accept();
		
		// Client와 읽고 쓸 수 있는 InputStream, OutputStream 반환한다.
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String firstLine = br.readLine();
		List<String> headers = new ArrayList<>();
		String line = null;
		// 빈 줄을 만나면 while문을 끝낸다.
		while(!(line = br.readLine()).equals("")) {
			headers.add(line);
		}
		// 요청 정보 읽기가 끝
		
		System.out.println(firstLine);
		for(int i = 0; i < headers.size(); i++) {
			System.out.println(headers.get(i));
		}
		
		// 서버에게 응답 메세지 보내기
		// HTTP/1.1 200 OK <--상태메시지
		// 헤더 1
		// 헤더 2
		// 헤더 ...
		// 빈 줄
		// 브라우저가 표시해 줄 내용
		pw.println("HTTP/1.1 200 OK");
		pw.println("name: Kim");
		pw.println("email: gywls1390@gmail.com");
		pw.println();
		pw.println("<html>");
		pw.println("<h1>Hello!!!</h1>");
		pw.println("</html>");
		pw.close();
		
		ss.close();
		System.out.println("서버가 종료됩니다.");
	}

}
