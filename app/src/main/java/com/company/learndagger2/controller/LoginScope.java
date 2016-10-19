package com.company.learndagger2.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by liusiming on 2016/10/14.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginScope {
}
