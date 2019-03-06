package com.casper.arb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.casper.arb.util.DbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@Component
public class Service {

	/*********************************************************************
	 * Function Name: insertData
	 * Description: Method to insert the records in the db
	 *
	 * @param 
	 * @return String
	 * 
	 ********************************************************************/
	public String insertData(String req) throws InterruptedException {

		DB db = null;
		MongoClient mongoClnt = null;
		mongoClnt = DbConnection.getConnection();
		String status = "SUCCESS";
		if (mongoClnt != null) {
			db = mongoClnt.getDB("arbDatadb");
		}

		try {
			DBObject dbObject = (DBObject) JSON.parse(req);
			if (db != null) {
				DBCollection collection = db.getCollection("arbData");
				collection.insert(dbObject);
			}
		} catch (Exception e) {
			status = "FAILED";
			e.printStackTrace();
		} finally {
			mongoClnt.close();
		}
		return status;
	}

	/*********************************************************************
	 * Function Name: findData
	 * Description: Method to find the data inserted into the db
	 *
	 * @param 
	 * @return List<DBObject>
	 * 
	 ********************************************************************/
	public List<DBObject> findData(Map<String, String[]> reqMap) {
		DB db = null;
		MongoClient mongoClnt = null;
		DBCursor cursor = null;
		mongoClnt = DbConnection.getConnection();
		List<DBObject> dbObjectList = new ArrayList<DBObject>();
		
		if (mongoClnt != null) {
			db = mongoClnt.getDB("testdb");
		}

		try {
			if (db != null) {
				DBCollection collection = db.getCollection("empData");
				BasicDBObject whereQuery = new BasicDBObject();
				for (Entry<String, String[]> req : reqMap.entrySet()) {
					for (int i = 0; i < req.getValue().length; i++) {
						whereQuery.put(req.getKey(), req.getValue()[i]);
					}
				}
				cursor = collection.find(whereQuery);
				dbObjectList = cursor.toArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mongoClnt.close();
		}

		return dbObjectList;

	}
}
