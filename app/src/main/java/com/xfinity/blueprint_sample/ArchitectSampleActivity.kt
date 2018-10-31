/*
 * Copyright 2017 Comcast Cable Communications Management, LLC
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xfinity.blueprint_sample

import android.view.Menu
import android.view.MenuItem
import com.xfinity.blueprint.event.ComponentEventManager
import com.xfinity.blueprint.presenter.ScreenPresenter
import com.xfinity.blueprint_architecture.DefaultScreenView
import com.xfinity.blueprint_architecture.DefaultScreenViewArchitect
import com.xfinity.blueprint_architecture.activity.ScreenViewActivity
import com.xfinity.blueprint_sample.blueprint.AppComponentRegistry
import com.xfinity.blueprint_sample.mvp.presenter.ArchitectSamplePresenter

/**
 * Sample activity that demonstrates using the Blueprint Architecture Components
 */
class ArchitectSampleActivity : ScreenViewActivity() {
    //Dependencies.  These would normally be injected
    private val componentEventManager = ComponentEventManager()
    private val componentRegistry = AppComponentRegistry(componentEventManager, defaultItemId, defaultItemName)
    private lateinit var resourceProvider: ResourceProvider
    override var architect: DefaultScreenViewArchitect = DefaultScreenViewArchitect(componentRegistry)

    private lateinit var presenter: ArchitectSamplePresenter

    override fun getPresenter(): ScreenPresenter<DefaultScreenView> {
        resourceProvider = ResourceProvider(this)
        presenter = ArchitectSamplePresenter(componentEventManager, resourceProvider)

        return presenter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.remove -> {
                presenter.removeItemRequested()
                true
            }
            R.id.refresh_data_items -> {
                presenter.refreshDataItems()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
        presenter.present()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    companion object {
        const val defaultItemName = "DefaultDataItemName"
        const val defaultItemId = 0
    }
}
