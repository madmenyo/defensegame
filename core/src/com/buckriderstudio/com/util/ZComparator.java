package com.buckriderstudio.com.util;

import com.badlogic.ashley.core.Entity;

import java.util.Comparator;

public class ZComparator implements Comparator<Entity>
{

	@Override
	public int compare(Entity a, Entity b)
	{

		float az = Mappers.TRANSFORM_COMPONENT.get(a).position.y;
		float bz = Mappers.TRANSFORM_COMPONENT.get(b).position.y;
		int res = 0;
		if(az > bz){
			res = 1;
		}else if(az < bz){
			res = -1;
		}
		// Use Z breaker if Z fighting issues evolve

		return res;
	}
}
