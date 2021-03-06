package psi;

import java.util.List;
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
		if (a > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int learn(List<Point> input, List<Integer> output ) {
		if (input.size() != output.size()) {
			return 0;
		}
		int result;
		double e;
		int j;
		System.out.println("Wartosci poczatkowe wx=" + wx + " wy=" + wy + " b=" + b);

		for (int i = 0; i < input.size(); i ++) {
			System.out.println("Wartosc nr: " + (i+1));
			j = 0;
			do {
				j++;
				result = calculate(input.get(i));
				e = output.get(i) - result;
				System.out.println("Przebieg: " + j + " Blad=" + e + " wx=" + wx + " wy=" + wy + " b=" + b);
				System.out.println("  Punkt (" + input.get(i).getX() + "," + input.get(i).getY() + ") wynik=" +
						result + " oczekiwane: " + output.get(i));

				if(e != 0) {
					wx = wx + e * input.get(i).getX();
					wy = wy + e * input.get(i).getY();
					b = b + e;
					System.out.println("Nowe wartosci: wx="+ wx + " wy=" + wy + " b=" + b);
				}
				
			} while(e != 0);
		}
		return 1;
	}
	
	public double checkAnswers(List<Point> input, List<Integer> output) {
		if (input.size() != output.size()) {
			return 0;
		}
		int numberOfChecks = input.size();
		int numberOfGoodAnswers = 0;
		int result;
		for (int i = 0; i < numberOfChecks; i ++) {	
			result = calculate(input.get(i));
			if(result == output.get(i)) {
				numberOfGoodAnswers++;
			}
		}
		return numberOfGoodAnswers / numberOfChecks;
	}
	
	

}
