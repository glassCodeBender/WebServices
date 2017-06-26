
/* Imports for web client */
import org.apache.commons.httpclient.NameValuePair
import java.io._
import org.apache.commons
import org.apache.http._
import org.apache.http.client._
import org.apache.client.methods.HttpPost
import org.apache.impl.client.DefaultHttpClient
import java.util.ArrayList
import org.apache.http.message.BasicNameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.google.gson.Gson

object HttpJsonPost extends App {

/**
  *
  * This code is primarily from Alvin Alexander's Scala Cookbook.
  * 
  * Will probably need to use Lift-JSON library instead of GSON
  * because classes are complex. Maybe...
  *
  * What do we need to send to the client for processing?
  * Logs
  * MFT CSV
  * Prefetch file
  * Image from memory for processing w/ vol.py
  *
  */

	// create object as a JSON String
	val bbs = BBSWeb()
	val testAsJson = new Gson().toJson(information)

	// add name value pairs to a post object
	val post = new HttpPost("http://localhost:8080/posttest")
	val nameValuePairs = new ArayList[NameValuePair]()
	nameValuePairs.add(new BasicNameValuePair("JSON", testAsJson))
	post.setEntity(new UrlEncodedFormEntity(nameValuePairs))

	// send the post request
	val client = new DefaultHttpClient
	val response = client.execute(post)
	println("--- HEADERS ---")
	response.getAllHeaders.foreach(args => println(args))

} // END HttpJsonPost class
