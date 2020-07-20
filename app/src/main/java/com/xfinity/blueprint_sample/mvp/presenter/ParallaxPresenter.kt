package com.xfinity.blueprint_sample.mvp.presenter

import com.xfinity.blueprint.event.ComponentEvent
import com.xfinity.blueprint.event.ComponentEventManager
import com.xfinity.blueprint.presenter.EventEmittingComponentPresenter
import com.xfinity.blueprint_annotations.DefaultPresenter
import com.xfinity.blueprint_annotations.DefaultPresenterConstructor
import com.xfinity.blueprint_sample.mvp.model.ParallaxModel
import com.xfinity.blueprint_sample.mvp.view.ParallaxView

@DefaultPresenter(viewClass = ParallaxView::class)
class ParallaxPresenter
@DefaultPresenterConstructor constructor(override val componentEventManager: ComponentEventManager) :
        EventEmittingComponentPresenter<ParallaxView, ParallaxModel> {

    override fun present(view: ParallaxView, model: ParallaxModel) {
        componentEventManager.postEvent(OnScrolledEvent(behavior = { dx, dy ->
            // TODO
        }))
    }
}

data class OnScrolledEvent(val behavior: (Int, Int) -> Unit) : ComponentEvent