# spring-cloud-stream-kafka-user-location
Producer consumer example to pass location data through the kafka messaging stream. This project will be expanded overtime and certain parts will be used in production for a navigation service I am developing. Longitude, latitude and timestamp can be passed through the messaging stream to various consumers to be further processed (Spark, other apps, etc) or stored (NoSql, etc). 

Start the zookeeper server
$ zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

Start the kafka server (new terminal window)
$ kafka-server-start usr/local/etc/kafka/server.properties

Create a topic (location-data or whatever name you would like to assign the message channel that will pass the location data)
$ kafka-topics --bootstrap-server localhost:9092 --topic location-data --create --partitions 1 --replication-factor 1

Start the producer project and the consumer project. The server-ports have been configured in the application.properties to run on different ports. If you make a /post request to the /publish-user-location endpoint via postman, the logger has been configured to show you the location object being passed through the stream. You may verify the results on your console.



