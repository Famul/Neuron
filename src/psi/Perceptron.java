package psi;

import java.util.Random;

public class Perceptron {
	private double wx;
	private double wy;
	private double b;
	
	public Perceptron() {
		Random generator = new Random();
		wx = generator.nextDouble();
		wy = generator.nextDouble();
		b = generator.nextDouble();
	}
	public int calculate(Point point) {
		double a;
		a = point.getX() * wx + point.getY() * wy + b;
		if (a >= 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int learn(Point[] input, int[] output ) {
		if (input.length != output.length) {
			return 0;
		}
		int result;
		double e;
		for (int i = 0; i < input.length; i ++) {	
			do {
				result = calculate(input[i]);
				e = output[i] - result;
				wx = wx + e * input[i].getX();
				wy = wy + e * input[i].getY();
				b = b + e;
			} while(e != 0);
		}
		return 1;
	}
	
	public double checkAnswers(Point[] input, int[] output) {
		if (input.length != output.length) {
			return 0;
		}
		int numberOfChecks = input.length;
		int numberOfGoodAnswers = 0;
		int result;
		for (int i = 0; i < numberOfChecks; i ++) {	
			result = calculate(input[i]);
			if(result == output[i]) {
				numberOfGoodAnswers++;
			}
		}
		return numberOfGoodAnswers / input.length;
	}

}
