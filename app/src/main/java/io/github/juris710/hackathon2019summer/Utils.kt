package io.github.juris710.hackathon2019summer

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.github.juris710.hackathon2019summer.vat_relief.EXTRA_PERCENTAGE
import io.github.juris710.hackathon2019summer.vat_relief.ResultActivity
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import org.xml.sax.SAXException
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.Exception
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

fun openImageFromAssets(context:Context, imagePath: String): Bitmap? {
    try {
        context.assets.open(imagePath).use { inputStream -> return BitmapFactory.decodeStream(inputStream) }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return null
}
fun convertInputStreamToString(inputStream: InputStream?): String {
    val encoding = "UTF-8"
    val sb = StringBuilder()
    try{
        InputStreamReader(inputStream, encoding).use{
            val buf = CharArray(1024)
            var numRead: Int = it.read(buf)
            while (numRead >= 0) {
                sb.append(buf, 0, numRead)
                numRead = it.read(buf)
            }
        }
    }catch (e: IOException){
        e.printStackTrace()
        return ""
    }
    return sb.toString()
}
fun openFromAssets(context: Context, path: String): String =
    try{
        context.assets.open(path).use{
            convertInputStreamToString(it)
        }
    }catch(e: IOException){
        ""
    }

fun openResultOnClick(button: Button, extraValue: String){
    button.setOnClickListener {
        val i = Intent(button.context, ResultActivity::class.java).apply{
            putExtra(EXTRA_PERCENTAGE, extraValue)
        }
        button.context.startActivity(i)
    }
}
fun openActivityOnClick(button: Button, activityClass: Class<out AppCompatActivity>){
    button.setOnClickListener {
        val i = Intent(button.context, activityClass)
        button.context.startActivity(i)
    }
}
fun NodeList.toList(): List<Node>{
    val list: MutableList<Node> = mutableListOf()
    for(i in 0..this.length){
        val item = this.item(i) ?: continue
        list.add(item)
    }
    return list
}
fun<T1, T2, T3> List<T1>.toMap(expr: (T1) -> Pair<T2, T3>): Map<T2, T3>{
    val map: MutableMap<T2, T3> = mutableMapOf()
    this.forEach {
        val pair = expr(it)
        map[pair.first] = pair.second
    }
    return map
}
fun parseStringToXML(xmlStyledString: String): Document?{
    try{
        val reader = StringReader(xmlStyledString)
        val source = InputSource(reader)
        val factory = DocumentBuilderFactory.newInstance()
        factory.isIgnoringComments = true
        val builder = factory.newDocumentBuilder()
        return builder.parse(source)
    }catch(e: Exception){
        when(e){
            is ParserConfigurationException, is SAXException, is IOException ->{
                e.printStackTrace()
                return null
            }
            else -> throw e
        }
    }
}
