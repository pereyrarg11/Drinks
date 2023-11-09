package com.pereyrarg11.drinks.core.data.util

class MissingParamsException(vararg missingParams: String) :
    Exception("Missing param(s): ${missingParams.joinToString(", ")}")

class NoResultsFoundException : Exception("No results were found.")
