package psi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Point> learningArray = new ArrayList<>();
		List<Integer> learningArrayAnswers = new ArrayList<>();
		
		learningArray.add(new Point(-8, 20));
		learningArrayAnswers.add(1);
		
		learningArray.add(new Point(2, 20));
		learningArrayAnswers.add(1);
		
		learningArray.add(new Point(4, 25));
		learningArrayAnswers.add(1);
		
		learningArray.add(new Point(-6, -5));
		learningArrayAnswers.add(1);
		
		learningArray.add(new Point(-9, -10));
		learningArrayAnswers.add(1);
		
		learningArray.add(new Point(5, 9));
		learningArrayAnswers.add(0);
		
		learningArray.add(new Point(4, -16));
		learningArrayAnswers.add(0);
		
		learningArray.add(new Point(1, -10));
		learningArrayAnswers.add(0);
		
		learningArray.add(new Point(-2, -10));
		learningArrayAnswers.add(0);
		
		learningArray.add(new Point(-6, -25));
		learningArrayAnswers.add(0);
		
		List<Point> checkingList = new ArrayList<>();
		List<Integer> checkingListAnswers = new ArrayList<>();
		
		checkingList.add(new Point(-2, 20));
		checkingListAnswers.add(1);
		
		checkingList.add(new Point(-6, 21));
		checkingListAnswers.add(1);
		
		checkingList.add(new Point(10, -16));
		checkingListAnswers.add(0);
		
		checkingList.add(new Point(0, -10));
		checkingListAnswers.add(0);
		
		checkingList.add(new Point(-2, 10));
		checkingListAnswers.add(1);
		
		checkingList.add(new Point(-8, -5));
		checkingListAnswers.add(1);
		
		checkingList.add(new Point(4, 1));
		checkingListAnswers.add(0);

		checkingList.add(new Point(-4, -16));
		checkingListAnswers.add(0);
		Perceptron perceptron = new Perceptron();
		do {
			perceptron.learn(learningArray, learningArrayAnswers);
		} while(perceptron.checkAnswers(checkingList, checkingListAnswers) < 0.9);
		
		int x, y;
		Scanner scanner = new Scanner(System.in);
		Point point;
		do {
			System.out.print("Podaj x: ");
			x = scanner.nextInt();
			System.out.print("Podaj y: ");
			y = scanner.nextInt();
			point = new Point(x, y);
			System.out.println("Odpowiedz: " + perceptron.calculate(point));
		} while (x != 0 || y != 0);
	}

}
