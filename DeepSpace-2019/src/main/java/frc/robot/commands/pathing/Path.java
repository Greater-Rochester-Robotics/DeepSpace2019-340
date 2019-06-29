package frc.robot.commands.pathing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Path extends ArrayList<PathSegment> {
	public static final long serialVersionUID = 340; // Because why not?
	private Function<Double, Double> speedFunction = x -> .4; //Function defining speed based on percent of curve. Defaults to 40% everywhere

	public Path(PathSegment... paths) {
		super(Arrays.asList(paths));
	}

	public Path(Function<Double, Double> speedFunction, PathSegment... paths) {
		this(paths);
		this.speedFunction = speedFunction;
	}

	public double getTotalLength() {
		// Returns the sum of the lengths of each Path
		return this.stream().mapToDouble(PathSegment::getLength).sum();
	}

	public double getTotalOfCompletedPaths(double distance) {
		PathSegment current = getPathAtDistance(distance);
		Path previous = new Path();
		for (PathSegment p : this) {
			if (current.equals(p)) {
				return previous.getTotalLength();
			} else {
				previous.add(p);
			}
		}

		return previous.getTotalLength();
	}

	/**
	 * ex: if you traveled past the first Path's length, it returns the second (or
	 * third, or fourth...)
	 */
	public PathSegment getPathAtDistance(double distance) {
		int i = 0;
		while (distance >= 0 && i < this.size()) {
			distance -= this.get(i).getLength();
			i++;
		}

		return this.get(i - 1);
	}

	public Function<Double, Double> getSpeed() {
		return speedFunction;
	}
}
