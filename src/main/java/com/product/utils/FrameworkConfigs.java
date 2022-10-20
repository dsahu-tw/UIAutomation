package com.product.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConfigs {

    public static Configs configs = ConfigFactory.create(Configs.class);


}
