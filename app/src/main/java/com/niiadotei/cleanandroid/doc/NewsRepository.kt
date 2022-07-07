package com.niiadotei.cleanandroid.doc

import android.service.autofill.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsRepository(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val userData: UserData
) {

    /**
     * Returns the favorite latest news applying transformations on the flow.
     * These operations are lazy and don't trigger the flow. They just transform
     * the current value emitted by the flow at that point in time.
     * */
    val favoriteLatestNews: Flow<List<ArticleHeadline>> = newsRemoteDataSource.latestNews.map { news ->
        news.filter {

        }

    }
}