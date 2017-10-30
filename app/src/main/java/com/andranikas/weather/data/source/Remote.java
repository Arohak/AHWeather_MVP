package com.andranikas.weather.data.source;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by andranikas on 10/19/2017.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Remote {

}
