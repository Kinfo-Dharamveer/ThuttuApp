package com.kinfo.thuttu.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ActivityContext
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}
