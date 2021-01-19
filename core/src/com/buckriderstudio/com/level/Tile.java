package com.buckriderstudio.com.level;

import com.badlogic.gdx.math.GridPoint2;

public class Tile
{
	/** bitwise connections specified in {@link Direction} **/
	public Connection north;
	public Connection South;
	public Connection East;
	public Connection West;


	public Tile()
	{
	}

	public void connect(Tile other){
		Connection connection = new Connection(this, other);
	}

}
