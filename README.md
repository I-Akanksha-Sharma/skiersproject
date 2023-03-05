# skiersproject
This project has two folders
1.) API Invocation Client which is termed as Skiers_Server
2.) Skiers_MultithreadClient which contains the Single-Threaded and Multithreaded Client
To run the project sucessfully the server should be up and running
Our server is located on Cloud, this server is managed by Servlet code which invokes the API calls
The client then uses these API calls to POST 10k by using 32 threads, all of which send 1000 requests each. 
However, once 10k requests are posted the program is terminated.

