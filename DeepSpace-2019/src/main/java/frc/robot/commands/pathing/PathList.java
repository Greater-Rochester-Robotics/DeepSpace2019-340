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
			/* {"start":{"x":68,"y":116},"mid1":{"x":161,"y":116},"mid2":{"x":124,"y":82},"end":{"x":157,"y":64}} */
			new Vec2(68, 116), new Vec2(161, 116), new Vec2(124, 82), new Vec2(157, 64) 
			, 114));

		/* x -> x < .8 ? x < .125 ? .35 : .55 : .2 */
		public static final Path FAR_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":69,"y":117},"mid1":{"x":125,"y":117},"mid2":{"x":341,"y":96},"end":{"x":309,"y":64}} */
			new Vec2(69, 117), new Vec2(125, 117), new Vec2(341, 96), new Vec2(309, 64) 
			, 260));
	}

	public static final class RIGHT_ROCKET {
		
		/* x -> .4 */
		//Still needs adjusting; driver has to hit the killswitch early
		public static final Path CLOSE_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":116},"mid1":{"x":161,"y":116},"mid2":{"x":124,"y":150},"end":{"x":157,"y":168}} */
			new Vec2(68, 116), new Vec2(161, 116), new Vec2(124, 150), new Vec2(157, 168) 
			, 114));
		
		/* x -> x < .8 ? x < .125 ? .35 : .55 : .2 */
		public static final Path FAR_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":69,"y":117},"mid1":{"x":125,"y":117},"mid2":{"x":341,"y":138},"end":{"x":309,"y":170}} */
			new Vec2(69, 117), new Vec2(125, 117), new Vec2(341, 138), new Vec2(309, 170) 
			, 260));
	}

	public static final class LEFT_CARGO {

		/* x -> x < .75 ? .55 : .2 */
		public static final Path FIRST_SLOT = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":206,"y":201},"mid2":{"x":275,"y":117},"end":{"x":273,"y":160}} */
			new Vec2(68, 207), new Vec2(206, 201), new Vec2(275, 117), new Vec2(273, 160) 
			, 225));
	}

	public static final class RIGHT_CARGO {

		/* x -> x < .75 ? .55 : .2 */
		public static final Path FIRST_SLOT = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":206,"y":213},"mid2":{"x":275,"y":297},"end":{"x":273,"y":254}} */
			new Vec2(68, 207), new Vec2(206, 213), new Vec2(275, 297), new Vec2(273, 254) 
			, 226));
	}
}
