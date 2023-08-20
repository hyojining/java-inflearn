package chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) throws Exception{
		if(args.length != 1) {
			System.out.println("사용법: java chat2.ChatClient 닉네임");
			return;
		}
		String name = args[0];
		Socket socket = new Socket("127.0.0.1", 8888);
		
		// 소켓을 통해 읽고 쓸 수 있는 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		// 닉네임 전송
		pw.println(name);
		pw.flush();
		
		// 백그라운드로 서버가 보내준 메시지를 읽어들여서 화면에 출력한다.
		InputThread inputThread = new InputThread(br);
		inputThread.start();
		
		// 클라이언트는 읽어들인 메시지를 서버에게 전송한다.
		try {
			String line = null;
			while((line = keyboard.readLine()) != null) {
				if("/quit".equals(line)) {
					pw.println("/quit");
					pw.flush();
					break;
				}
				pw.println(line);
				pw.flush();
			}
		} catch(Exception e) {
			System.out.println("....");
		}
		try {
			br.close();
		} catch(Exception e){
		
		}
		try {
			pw.close();
		} catch(Exception e){
			
		}
		try {
			socket.close();
		} catch(Exception e){
			
		}
	}

}

// 서버로부터 읽어들이는 스레드
class InputThread extends Thread{
	BufferedReader br;
	public InputThread(BufferedReader br) {
		this.br = br;
	}
	
	// 백그라운드에서 계속해서 읽어들임
	@Override
	public void run() {
		try {
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch(Exception e) {
			System.out.println("....");
		}
	}
	
	
}