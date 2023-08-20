package io.github.ozzyozbourne;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

/**
 * Singleton Property Mapper
 */
public enum JPropSingleton {

    INSTANCE(config());

    final JavaPropsMapper javaPropsMapper;

    JPropSingleton(final JavaPropsMapper javaPropsMapper) {this.javaPropsMapper = javaPropsMapper;}

    private static  JavaPropsMapper config(){return new JavaPropsMapper();}

}
