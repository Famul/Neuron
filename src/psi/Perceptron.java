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
	public int calculate(int x, int y) {
		double a;
		a = x * wx + y * wy + b;
		if (a >= 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int learn(int[][] input, int[] output ) {
		if (input.length != 2 || input[0].length != input[1].length || input[0].length != output.length) {
			return 0;
		}
		int result;
		double e;
		for (int i = 0; i < input[i].length; i ++) {	
			do {
				result = calculate(input[0][i], input[1][i]);
				e = output[i] - result;
				wx = wx + e * input[0][i];
				wy = wy + e * input[1][i];
				b = b + e;
			} while(e != 0);
		}
		return 1;
	}

}
