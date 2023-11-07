package com.pereyrarg11.drinks.core.data.util

class MissingQueryParamsException(vararg missingParams: String) :
    Exception("Missing query param(s): ${missingParams.joinToString(", ")}")
