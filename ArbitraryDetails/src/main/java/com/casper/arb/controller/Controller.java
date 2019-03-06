package com.casper.arb.controller;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casper.arb.service.Service;
import com.mongodb.DBObject;

@WebServlet(name = "EmpServlet", urlPatterns = "/arbitraryData")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		Service empService = new Service();
		StringBuffer req = new StringBuffer();
		try {
			String line = null;
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				req.append(line.trim());
			}
			response.getOutputStream().print(empService.insertData(req.toString()));
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		Service empService = new Service();
		List<DBObject> dbObjectList = null;
		StringBuffer str = new StringBuffer();

		try {
			Map<String, String[]> reqMap = request.getParameterMap();
			dbObjectList = empService.findData(reqMap);
			for (DBObject dbObject : dbObjectList) {
				str.append("\n" + dbObject);
			}
			if(!str.toString().isEmpty()) {
				response.getOutputStream().println(str.toString());
			} else {
				response.getOutputStream().println("No Records Found !!!");
			}
			response.getOutputStream().flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
