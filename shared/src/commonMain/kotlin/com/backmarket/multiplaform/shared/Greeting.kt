package com.backmarket.multiplaform.shared


class Greeting {
    fun greeting(): String {
        return "Hello BackMaker!\nYour device's platform is '${Platform().platform}'!"
    }
}
