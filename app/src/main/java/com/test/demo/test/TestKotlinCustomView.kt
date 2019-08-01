package com.test.demo.test

import android.content.Context
import android.util.AttributeSet
import android.view.View

class TestKotlinCustomView : View {



    constructor(context: Context) : super(context)

    constructor(context: Context,attributeSet: AttributeSet? = null) : super(context,attributeSet)

    constructor(context: Context,attributeSet: AttributeSet? = null,int: Int = 0) :super(context,attributeSet,int);

    init {
        initData()
    }

    private fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

}