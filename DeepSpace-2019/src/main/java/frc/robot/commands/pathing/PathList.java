package frc.robot.commands.pathing;

import frc.robot.commands.pathing.PathSegment.Vec2;

/**
 * All of our paths. We have a lot of them.<br>
 * Part of me wants to convert this double-nested class
 * crap into an enum thing, but it's not worth the effort
 */
public class PathList {

	public static final class LEFT_ROCKET {

		/* x -> .4 */
		public static final Path CLOSE_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":116},"mid1":{"x":182,"y":118},"mid2":{"x":159,"y":68},"end":{"x":181,"y":60}} */
			new Vec2(68, 116), new Vec2(182, 118), new Vec2(159, 68), new Vec2(181, 60) 
			, 137));

		/* x -> x < .8 ? x < .125 ? .35 : .55 : .2 */
		public static final Path FAR_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":69,"y":117},"mid1":{"x":123,"y":120},"mid2":{"x":357,"y":105},"end":{"x":309,"y":64}} */
			new Vec2(69, 117), new Vec2(123, 120), new Vec2(357, 105), new Vec2(309, 64) 
			, 270));
	}

	public static final class RIGHT_ROCKET {
		
		/* x -> .4 */
		//Still needs adjusting; driver has to hit the killswitch early
		public static final Path CLOSE_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":116},"mid1":{"x":182,"y":114},"mid2":{"x":159,"y":164},"end":{"x":181,"y":172}} */
			new Vec2(68, 116), new Vec2(182, 114), new Vec2(159, 164), new Vec2(181, 172) 
			, 137));
		
		/* x -> x < .8 ? x < .125 ? .35 : .55 : .2 */
		public static final Path FAR_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":69,"y":117},"mid1":{"x":123,"y":114},"mid2":{"x":357,"y":129},"end":{"x":309,"y":170}} */
			new Vec2(69, 117), new Vec2(123, 114), new Vec2(357, 129), new Vec2(309, 170) 
			, 270));
	}

	public static final class LEFT_CARGO {

		/* x -> x < .75 ? .55 : .2 */
		public static final Path FIRST_SLOT = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":206,"y":201},"mid2":{"x":271,"y":127},"end":{"x":259,"y":173}} */
			new Vec2(68, 207), new Vec2(206, 201), new Vec2(271, 127), new Vec2(259, 173) 
			, 213));
	}

	public static final class RIGHT_CARGO {

		/* x -> x < .75 ? .55 : .2 */
		public static final Path FIRST_SLOT = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":206,"y":213},"mid2":{"x":271,"y":287},"end":{"x":259,"y":241}} */
			new Vec2(68, 207), new Vec2(206, 213), new Vec2(271, 287), new Vec2(259, 241) 
			, 213));
	}
}
