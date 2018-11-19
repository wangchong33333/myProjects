#!/bin/bash
for pid in turboes-cust-event turboes-cust-message turboes-cust-device turboes-cust-datastream turboes-cust-account turboes-api-center turboes-monitor-center turboes-discovery-center; do
  ps -ef | grep $pid | grep -v grep | awk '{print $2}' | xargs kill -9
done
