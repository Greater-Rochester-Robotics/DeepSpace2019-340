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
			/* {"start":{"x":48,"y":130},"mid1":{"x":123,"y":131},"mid2":{"x":69,"y":73},"end":{"x":116,"y":47}} */
			new Vec2(48, 130), new Vec2(123, 131), new Vec2(69, 73), new Vec2(116, 47) 
			, 137));
	}

	public static final class RIGHT_ROCKET {
		public static final Path ONE_HATCH_INITIAL_TESTING = new Path(new PathSegment( 
			/* {"start":{"x":79,"y":211},"mid1":{"x":72,"y":316},"mid2":{"x":153,"y":303},"end":{"x":203,"y":311}} */
			new Vec2(79, 211), new Vec2(72, 316), new Vec2(153, 303), new Vec2(203, 311) 
			, 188));
		
		public static final Path CURVE_TEST = new Path(new PathSegment( 
			/* {"start":{"x":74,"y":229},"mid1":{"x":101,"y":229},"mid2":{"x":148,"y":224},"end":{"x":154,"y":174}} */
			new Vec2(74, 229), new Vec2(101, 229), new Vec2(148, 224), new Vec2(154, 174) 
			, 110));
	}
}
