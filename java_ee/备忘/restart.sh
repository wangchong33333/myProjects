#!/bin/bash
for pid in turboes-cust-event turboes-cust-message turboes-cust-device turboes-cust-datastream turboes-cust-account turboes-api-center turboes-monitor-center turboes-discovery-center; do
  ps -ef | grep $pid | grep -v grep | awk '{print $2}' | xargs kill -9
done
source /etc/profile

setsid java -jar /opt/customer_server/turboes-discovery-center*.jar >> nohup.out &


sleep 5

setsid java -jar /opt/customer_server/turboes-monitor-center*.jar >> nohup.out &

sleep 5

setsid java -jar /opt/customer_server/turboes-api-center*.jar >> nohup.out &

sleep 5

setsid java -jar /opt/customer_server/turboes-cust-account*.jar >> nohup.out &
setsid java -jar /opt/customer_server/turboes-cust-datastream*.jar >> nohup.out &
setsid java -jar /opt/customer_server/turboes-cust-device*.jar >> nohup.out &
#setsid java -jar /opt/customer_server/turboes-cust-message*.jar >> nohup.out &
#setsid java -jar /opt/customer_server/turboes-cust-event*.jar >> nohup.out &
