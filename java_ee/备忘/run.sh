#!/bin/bash
nohup java -jar turboes-discovery-center*.jar >> nohup.out &

sleep 5

nohup java -jar turboes-monitor-center*.jar >> nohup.out &

sleep 5

nohup java -jar turboes-api-center*.jar >> nohup.out &

sleep 5

nohup java -jar turboes-cust-account*.jar >> nohup.out &
nohup java -jar turboes-cust-datastream*.jar >> nohup.out &
nohup java -jar turboes-cust-device*.jar >> nohup.out &
nohup java -jar turboes-cust-message*.jar >> nohup.out &
nohup java -jar turboes-cust-event*.jar >> nohup.out &
