package app.trian.plugins

data class ResponseFactory<T>(val code:Int,val message:String,val data:T)