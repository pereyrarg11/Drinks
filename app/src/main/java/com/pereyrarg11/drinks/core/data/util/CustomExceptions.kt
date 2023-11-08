package com.pereyrarg11.drinks.core.data.util

class MissingQueryParamsException(vararg missingParams: String) :
    Exception("Missing query param(s): ${missingParams.joinToString(", ")}")

class NoResultsFoundException : Exception("No results were found matching the search criteria.")
