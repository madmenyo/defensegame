package com.buckriderstudio.com.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent implements Component
{
	public Vector2 position = new Vector2();
	public Vector2 scale = new Vector2(1, 1);
	public int zBreaker = 1;
	public float angle = 0;
}
