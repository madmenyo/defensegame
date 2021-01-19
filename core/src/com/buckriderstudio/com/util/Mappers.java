package com.buckriderstudio.com.util;

import com.badlogic.ashley.core.ComponentMapper;
import com.buckriderstudio.com.components.TextureComponent;
import com.buckriderstudio.com.components.TransformComponent;

public class Mappers
{
	public static final ComponentMapper<TransformComponent> TRANSFORM_COMPONENT = ComponentMapper.getFor(TransformComponent.class);
	public static final ComponentMapper<TextureComponent> TEXTURE_COMPONENT = ComponentMapper.getFor(TextureComponent.class);
}
