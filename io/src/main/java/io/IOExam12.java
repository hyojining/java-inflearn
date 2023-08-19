package io;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class IOExam12 {

	public static void main(String[] args) throws Exception{
		// 문제) 이름, 국어, 영어, 수학, 총점, 평균 점수를 /tmp/score.dat 파일에서 읽어들이기
		DataInputStream in = new DataInputStream(new FileInputStream("C:/tmp/score.dat"));
		String name = in.readUTF();
		int kor = in.readInt();
		int eng = in.readInt();
		int math = in.readInt();
		double total = in.readDouble();
		double avg = in.readDouble();
		
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		System.out.println(total);
		System.out.println(avg);

		in.close();
	}

}
