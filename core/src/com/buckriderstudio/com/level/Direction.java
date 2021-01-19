package com.buckriderstudio.com.level;

import com.badlogic.gdx.math.GridPoint2;

public class Direction
{
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = 4;
	public static final int WEST = 8;

	public static int getOppositeDirection(int direction){
		if (direction == NORTH) return SOUTH;
		if (direction == EAST) return WEST;
		if (direction == SOUTH) return NORTH;
		if (direction == WEST) return EAST;

		throw new IllegalArgumentException("Given parameter is not corresponding to a valid direction: [" + direction + "]");
	}

	public static GridPoint2 getCellDirection (int direction, GridPoint2 out){
		if (direction == NORTH) return out.set(0, 1);
		if (direction == EAST) return out.set(1, 0);
		if (direction == SOUTH) return out.set(0, -1);
		if (direction == WEST)return out.set(-1, 0);

		throw new IllegalArgumentException("Given parameter is not corresponding to a valid direction: [" + direction + "]");
	}

	public static boolean isFlagSet(byte value, byte flags)
	{
		return (flags & value) == value;
	}

	public static byte setFlag(byte value, byte flags)
	{
		return (byte) (flags | value);
	}

	public static byte unsetFlag(byte value, byte flags)
	{
		return (byte) (flags & ~value);
	}
}
