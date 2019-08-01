package com.test.retrofitlib;

import android.support.annotation.Nullable;

abstract class ParameterHandler<T> {

    abstract void apply(RequestBuilder builder, @Nullable String value);

    public static class Query<T> extends ParameterHandler<T> {

        private String name;
        private boolean encoded;

        public Query(String name, boolean encoded) {
            this.name = name;
            this.encoded = encoded;
        }

        @Override
        void apply(RequestBuilder builder, @Nullable String value) {
            if (value == null) return; // Skip null values.
            builder.addQueryParam(name, value, encoded);
        }
    }
}
