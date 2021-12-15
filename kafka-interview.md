#### 1. What is the Retention Period in Kafka Topic ?
   Answer :  Kafka events or Messages older than retention period will not be available for Consumer to Consume. Because it gets deleted. Kafka Retain the data only for retention period. Let;s say if Retention period is 7 days, Then You cannot get the data older than 7 days.

#### 2. One Job which reads data from kafka topic and then process it,is failing because it has offset to read which are older than retention period?

Answer : it should have property failOnDataLoss to be false , in that case it will not fail the job with error, But you would lose the data.

below is the description of property from Kafka Documentation

failOnDataLoss: Whether to fail the query when it’s possible that data is lost (e.g., topics are deleted, or offsets are out of range). This may be a false alarm. You can disable it when it doesn’t work as you expected. Batch queries will always fail if it fails to read any data from the provided offsets due to lost data.

#### 3. Which mechanism [Push Or Pull] is used by Kafka Consumer to read data from Brokers ?

Answer :It is Pulled from the broker by Consumer.Because It if it is Pushed by Brokers to the Consumers , Rate is Controlled by Broker and not by the Consumer.  If Pulled , then each consumer can read from broker at the maximum rate of Consumer, Independent of Other consumers which might be Slower or Faster. That’s why Pull Mechanism is used.

#### 4. Is it Possible to Read data from kafka topic from fixed offset using command line ?

Answer : Yes it is possible , Depending on partitions of topic ,we will have different offset. To read date from fixed offset use below command. 