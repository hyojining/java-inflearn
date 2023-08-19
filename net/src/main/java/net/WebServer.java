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

public class WebServer {

	public static void main(String[] args) throws IOException {
		// 클라이언트가 접속할 때까지 대기
		ServerSocket serverSocket = new ServerSocket(9090);
		
		try {
			while (true) {
				// 대기한다. 클라이언트가 접속하면 클라이언트와 통신하는 Socket이 반환된다.
				Socket clientSocket = serverSocket.accept();
				
				ClientThread ct = new ClientThread(clientSocket);
				ct.start();
			}
		} finally {
			serverSocket.close();
		}	
	}
}

class ClientThread extends Thread{
	private Socket clientSocket;
	public ClientThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		try {
			InputStream inputStream = clientSocket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
	
			OutputStream outputStream = clientSocket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));
			
			// http://localhost:9090/hello 접속했을 때 GET /hello HTTP/1.1 출력
			// http://localhost:9090/hi
			String firstLine = br.readLine();
			String msg = "";
			if(firstLine.indexOf("/hello") >= 0)
				msg = "hello";
			else if(firstLine.indexOf("/hi") >= 0)
				msg = "hi";
			System.out.println(firstLine);
			
			String line = null;
			while(!(line = br.readLine()).equals("")) {
				System.out.println(line);
			} // 빈 줄까지 읽어들이면 끝
			
			System.out.println("3 - 응답한다.");
			
			pw.println("HTTP/1.1 200 OK"); //응답
			pw.println("name: Kim");
			pw.println("email: gywls1390@gmail.com");
			pw.println();
			pw.println("<html>");
			pw.println(msg + " world!");
			pw.println("</html>");
			
			pw.flush();
			br.close();
			pw.close();
			
			clientSocket.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
