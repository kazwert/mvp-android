/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.nbs.mvpsample.di.component;

import com.nbs.mvpsample.di.components.ApplicationComponent;
import com.nbs.mvpsample.di.modules.ApiTestModule;
import com.nbs.mvpsample.di.modules.ApplicationTestModule;
import com.nbs.mvpsample.di.modules.DbTestModule;
import com.nbs.mvpsample.di.modules.PreferenceTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by amitshekhar on 03/02/17.
 */
@Singleton
@Component(modules = {ApplicationTestModule.class, ApiTestModule.class, PreferenceTestModule.class, DbTestModule.class})
public interface TestComponent extends ApplicationComponent {
}
