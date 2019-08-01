package com.test.demo.test.apiDemo.search.suggestProvider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by DEV002 on 2018/6/14.
 */

public class MySuggestionProvider extends SearchRecentSuggestionsProvider {

    //AUTHORITY建议设置为包名
    public final static String AUTHORITY = "com.test.demo.test.apiDemo.search.suggestProvider.MySuggestionProvider";
    //MODE中DATABASE_MODE_QUERIES时必须的，可选DATABASE_MODE_2LINES
    public final static int MODE = DATABASE_MODE_QUERIES;
    //        public final static int MODE = DATABASE_MODE_QUERIES | DATABASE_MODE_2LINES;
    public MySuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
