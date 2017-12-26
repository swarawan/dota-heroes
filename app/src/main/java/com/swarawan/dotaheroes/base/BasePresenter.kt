package com.swarawan.dotaheroes.base

import com.github.ajalt.timberkt.d
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by rioswarawan on 12/24/17.
 */
open class BasePresenter<T : BaseView> : Presenter<T> {

    var view: T? = null
    lateinit var compositeDisposable: CompositeDisposable

    override fun attachView(view: T) {
        d { "Base presenter attached" }
        this.view = view
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {
        d { "Base presenter detached" }
        this.view = null
        compositeDisposable.dispose()
    }

    val isViewAttached: Boolean
        get() = view != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.attachView(MvpView) " +
            "before requesting data through presenter")
}