package utils;

import java.util.List;

public class DesviacionTipica {

	public double calculateSD(double[] numarray) {

		double sum = 0.0, standardDeviation = 0.0;

		int length = numarray.length;

		for (double num : numarray) {
			sum += num;
		}
		double mean = sum / length;

		for (double num : numarray) {
			standardDeviation += Math.pow(num - mean, 2);
		}
		return Math.sqrt(standardDeviation / length);

	}

}
