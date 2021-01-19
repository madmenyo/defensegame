package com.buckriderstudio.com.level;

import com.badlogic.gdx.math.GridPoint2;

import java.util.ArrayList;
import java.util.List;

public class Connection
{
	private List<String> blackList = new ArrayList<>();
	private Tile tileA;
	private Tile tileB;

	public Connection(Tile tileA, Tile tileB)
	{
		this.tileA = tileA;
		this.tileB = tileB;
	}
}
