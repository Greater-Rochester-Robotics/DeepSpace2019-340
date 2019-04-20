package frc.robot.commands.pathing;

import frc.robot.commands.pathing.PathSegment.Vec2;

/**
 * All of our paths. We have a lot of them.<br>
 * Part of me wants to convert this double-nested class
 * crap into an enum thing, but it's not worth the effort
 */
public class PathList {

	//Close hatch good
	//Far hatch GOD-TIER
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

	//Use the left-based!!! They work!
	public static final class RIGHT_ROCKET {
		
		/* x -> .4 */
		@Deprecated
		public static final Path CLOSE_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":188,"y":209},"mid2":{"x":163,"y":248},"end":{"x":180,"y":268}} */
			new Vec2(68, 207), new Vec2(188, 209), new Vec2(163, 248), new Vec2(180, 268) 
			, 142));
		
		/* x -> .4 */
		public static final Path CLOSE_HATCH_LEFT_BASED = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":116},"mid1":{"x":182,"y":114},"mid2":{"x":159,"y":164},"end":{"x":181,"y":172}} */
			new Vec2(68, 116), new Vec2(182, 114), new Vec2(159, 164), new Vec2(181, 172) 
			, 137));
		
		/* x -> x < .8 ? .55 : .2 */
		@Deprecated
		public static final Path FAR_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":129,"y":211},"mid2":{"x":338,"y":263},"end":{"x":290,"y":283}} */
			new Vec2(68, 207), new Vec2(129, 211), new Vec2(338, 263), new Vec2(290, 283) 
			, 254));
		
		/* x -> x < .8 ? x < .125 ? .35 : .55 : .2 */
		public static final Path FAR_HATCH_LEFT_BASED = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":118,"y":204},"mid2":{"x":305,"y":238},"end":{"x":277,"y":272}} */
			new Vec2(68, 207), new Vec2(118, 204), new Vec2(305, 238), new Vec2(277, 272) 
			, 234));
	}

	//Muchos bueno
	public static final class LEFT_CARGO {

		/* x -> x < .75 ? .55 : .2 */
		public static final Path FIRST_SLOT = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":182,"y":205},"mid2":{"x":242,"y":141},"end":{"x":253,"y":180}} */
			new Vec2(68, 207), new Vec2(182, 205), new Vec2(242, 141), new Vec2(253, 180) 
			, 197));
	}

	//All good
	public static final class RIGHT_CARGO {

		/* x -> x < .75 ? .55 : .2 */
		public static final Path FIRST_SLOT = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":182,"y":209},"mid2":{"x":255,"y":280},"end":{"x":259,"y":235}} */
			new Vec2(68, 207), new Vec2(167, 205), new Vec2(274, 277), new Vec2(273, 246) 
			, 217));
	}
}
