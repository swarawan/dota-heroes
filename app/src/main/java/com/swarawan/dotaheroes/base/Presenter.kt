package com.swarawan.dotaheroes.base

/**
 * Created by rioswarawan on 12/24/17.
 */
interface Presenter<in V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}