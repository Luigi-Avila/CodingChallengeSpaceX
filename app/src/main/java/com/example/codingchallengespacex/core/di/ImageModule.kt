package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.core.data.PicassoImageUtilsImp
import com.example.codingchallengespacex.core.domain.IImageUtils
import org.koin.dsl.module

val imageModule = module {
    single<IImageUtils> { PicassoImageUtilsImp() }
}