package info.quantlab.numericalmethods.assignments.computerarithmetics.quadraticequation;

import info.quantlab.numericalmethods.lecture.computerarithmetics.quadraticequation.QuadraticEquation;

public class QuadraticEquationFromCoefficients implements QuadraticEquation {

	// the two coefficients characterizing the quadratic equation
	private double p, q;

	/**
	 * Constructor for objects representing the quadratic equation
	 *
	 * @param q, the constant coefficient
	 * @param p, the linear coefficient
	 */
	public QuadraticEquationFromCoefficients(double q, double p) {
		this.q = q;
		this.p = p;
	}

	@Override
	public double[] getCoefficients() {
		return new double[] { q, p };
	}

	@Override
	public boolean hasRealRoot() {

		// we simply return such a boolean. Note that no parenthesis are needed
		return p * p / 4 - q >= 0;
	}

	@Override
	public double getSmallestRoot() {
		// the case when the quadratic equation has no solution
		if (!hasRealRoot()) {
			return Double.NaN;
		}
		// a simple case
		if (q == 0) {
			return -p;
		} else {
			if (p > 0) {
				/*
				 * the two terms have same sign in this case, so the large absolute error
				 * remains now on a large scale.
				 */
				return -p / 2 - Math.sqrt(p * p / 4 - q);
			} else {
				/*
				 * in this case instead taking the classical solution we would get a positive
				 * term (given by -p/2) which is added to a negative term (given by -
				 * Math.sqrt(p * p / 4 - q)). If both are large, you might have huge errors,
				 * because the large absolute error you get Math.sqrt(p * p / 4 - q) is now
				 * translated to a small scale. Then we multiply and divide the classical
				 * solution by -p/2 + sqrt(p^2/4-q), and find the expression below. This has the
				 * advantage that the denominator is given by two terms with same sign, so the
				 * large absolute error remains now on a large scale.
				 *
				 */
				return q / (-p / 2 + Math.sqrt(p * p / 4 - q));
			}
		}
	}

}