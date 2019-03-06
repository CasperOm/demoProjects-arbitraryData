package com.casper.arb.util;

import com.mongodb.MongoClient;

public class DbConnection {

	// Connecting with the default connection type
	public static MongoClient getConnection() {
		int port_no = 27017;
		String url = "localhost";
		MongoClient mongoClntObj = null;
		mongoClntObj = new MongoClient(url, port_no);
		return mongoClntObj;
	}

}
