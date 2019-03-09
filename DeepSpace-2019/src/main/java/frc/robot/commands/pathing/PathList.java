package frc.robot.commands.pathing;

import frc.robot.commands.pathing.PathSegment.Vec2;

/**
 * All of our paths. We have a lot of them.<br>
 * Part of me wants to convert this double-nested class
 * crap into an enum thing, but it's not worth the effort
 */
public class PathList {

	//Close hatch good-ish enough
	public static final class LEFT_ROCKET {

		/* x -> .4 */
		public static final Path CLOSE_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":116},"mid1":{"x":182,"y":118},"mid2":{"x":146,"y":64},"end":{"x":181,"y":55}} */
			new Vec2(68, 116), new Vec2(182, 118), new Vec2(146, 64), new Vec2(181, 55) 
			, 140));

		/* x -> x < .8 ? .55 : .2 */
		public static final Path FAR_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":182,"y":205},"mid2":{"x":353,"y":165},"end":{"x":286,"y":137}} */
			new Vec2(68, 207), new Vec2(182, 205), new Vec2(353, 165), new Vec2(286, 137) 
			, 268));
	}

	//Close hatch might be good?
	public static final class RIGHT_ROCKET {
		
		/* x -> .4 */
		public static final Path CLOSE_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":159,"y":205},"mid2":{"x":137,"y":259},"end":{"x":165,"y":277}} */
			new Vec2(68, 207), new Vec2(159, 205), new Vec2(137, 259), new Vec2(165, 277) 
			, 132));
		
		/* x -> x < .8 ? .55 : .2 */
		public static final Path FAR_HATCH = new Path(new PathSegment( 
			/* {"start":{"x":68,"y":207},"mid1":{"x":182,"y":209},"mid2":{"x":353,"y":249},"end":{"x":286,"y":277}} */
			new Vec2(68, 207), new Vec2(182, 209), new Vec2(353, 249), new Vec2(286, 277) 
			, 268));
	}

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
			/* {"start":{"x":68,"y":207},"mid1":{"x":182,"y":209},"mid2":{"x":242,"y":273},"end":{"x":253,"y":234}} */
			new Vec2(68, 207), new Vec2(182, 209), new Vec2(242, 273), new Vec2(253, 234) 
			, 197));
	}
}
