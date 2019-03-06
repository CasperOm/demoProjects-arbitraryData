# demoProjects-arbitraryData # arbitrary_data_fetch/insert # mongodb

Desciption: This project is maven based project which will insert arbitrary data from servlet endpoint to mongodb and will fetch the data from servlet endpoint with any number of pramaters.

Prerequisite: Install mongodb and execute the mongod from cmd.

Run this maven project in you desired IDE.

Below is the endpoint to be used.

fetch records: GET : localhost:9001/arbitraryData?Name=Om&id=2

insert records: POST : localhost:9001/arbitraryData 
Request: any json request.

Note: This project will be using the default connection details of MongoDb.

Incase of any further clarification/doubts you can contact me on om.bhayani31@gmail.com
