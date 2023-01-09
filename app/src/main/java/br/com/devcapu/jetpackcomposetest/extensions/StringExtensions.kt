package br.com.devcapu.jetpackcomposetest.extensions

fun String.isAValidCep(): Boolean {
    return this.replace("-","").length == 8
}