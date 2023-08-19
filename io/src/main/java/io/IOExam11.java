package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class IOExam11 {
	public static void main(String[] args) throws Exception{
		// 문제) 이름, 국어, 영어, 수학, 총점, 평균 점수를 /tmp/score.dat 파일에 저장
		String name = "kim";
		int kor = 90;
		int eng = 50;
		int math = 70;
		double total = kor + eng + math;
		double avg = total / 3.0;
		
		// 다양한 타입 읽고 쓰려면 Data~
		DataOutputStream out = new DataOutputStream(new FileOutputStream("C:/tmp/score.dat"));
		out.writeUTF(name);
		out.writeInt(kor);
		out.writeInt(eng);
		out.writeInt(math);
		out.writeDouble(total);
		out.writeDouble(avg);
		out.close();

	}
}
