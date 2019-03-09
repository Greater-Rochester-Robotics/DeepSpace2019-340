package frc.robot.commands.pathing;

import frc.robot.commands.pathing.PathSegment.Vec2;

/**
 * All of our paths. We have a lot of them.<br>
 * Part of me wants to convert this double-nested class
 * crap into an enum thing, but it's not worth the effort
 */
public class PathList {
	public static final class LEFT_ROCKET {
		public static final Path TWO_HATCH_INITIAL_TESTING = new Path(new PathSegment( 
			/* {"start":{"x":71,"y":118},"mid1":{"x":171,"y":120},"mid2":{"x":151,"y":70},"end":{"x":196,"y":33}} */
			new Vec2(71, 118), new Vec2(171, 120), new Vec2(151, 70), new Vec2(196, 33) 
			, 163));
	}

	public static final class RIGHT_ROCKET {
		public static final Path ONE_HATCH_INITIAL_TESTING = new Path(new PathSegment( 
			/* {"start":{"x":74,"y":217},"mid1":{"x":73,"y":109},"mid2":{"x":130,"y":179},"end":{"x":207,"y":127}} */
			new Vec2(74, 217), new Vec2(73, 109), new Vec2(130, 179), new Vec2(207, 127) 
			, 187));
		
		public static final Path CURVE_TEST = new Path(new PathSegment( 
			/* {"start":{"x":131,"y":217},"mid1":{"x":170,"y":217},"mid2":{"x":201,"y":252},"end":{"x":249,"y":254}} */
			new Vec2(131, 217), new Vec2(170, 217), new Vec2(201, 252), new Vec2(249, 254) 
			, 125));
	}
}
